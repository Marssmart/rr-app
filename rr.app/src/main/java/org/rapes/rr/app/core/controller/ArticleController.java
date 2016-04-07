package org.rapes.rr.app.core.controller;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.rapes.rr.app.core.controller.dto.input.article.ArticleLoadPageInputDTO;
import org.rapes.rr.app.core.controller.dto.output.article.ArticleLoadPageOutputDTO;
import org.rapes.rr.app.core.controller.params.RequestParams;
import org.rapes.rr.app.core.controller.params.RequestPaths;
import org.rapes.rr.app.core.dao.ArticleRepository;
import org.rapes.rr.app.core.dao.MapLocationRepository;
import org.rapes.rr.app.core.dao.MapMarkerRepository;
import org.rapes.rr.app.core.dao.MapRefferenceRepository;
import org.rapes.rr.app.core.dao.MapRouteRepository;
import org.rapes.rr.app.core.dom.Article;
import org.rapes.rr.app.core.dom.MapLocation;
import org.rapes.rr.app.core.dom.MapMarker;
import org.rapes.rr.app.core.dom.MapRefference;
import org.rapes.rr.app.core.dom.MapRoute;
import org.rapes.rr.app.core.dom.enums.MapType;
import org.rapes.rr.app.core.dom.enums.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.FluentIterable;

@RestController
public class ArticleController {

	private static final String CREATED_AT_PROP = "createdAt";

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private MapRefferenceRepository mapRefferenceRepository;
	
	@Autowired
	private MapMarkerRepository mapMarkerRepository;
	
	@Autowired
	private MapRouteRepository mapRouteRepository;
	
	@Autowired
	private MapLocationRepository mapLocationRepository;
	
	@PostConstruct
	public void init(){
		if(!articleRepository.exists(1L)){
			Article article = new Article();
			
			article.setContent("Obsah");
			article.setMainTitle("Hlavny titulok");
			article.setSubTitle("Sub titulok");
			article.setCreatedAt(LocalDateTime.now());
			article.setPublished(true);
			
			articleRepository.save(article);
		}
		
		if(!articleRepository.exists(2L)){
			Article article = new Article();
			
			article.setContent("Obsah 2");
			article.setMainTitle("Hlavny titulok 2");
			article.setSubTitle("Sub titulok 2");
			article.setCreatedAt(LocalDateTime.now());
			article.setPublished(true);
			
			articleRepository.save(article);
		}
		
		if(!mapRefferenceRepository.exists(1L)){
			MapRefference mapRefference = new MapRefference();
			mapRefference.setParentArticle(articleRepository.findOne(1L));
			mapRefference.setLatitude(49.2222336D);
			mapRefference.setLongitude(18.7389322D);
			mapRefference.setMapType(MapType.TERRAIN);
			
			mapRefferenceRepository.save(mapRefference);
		}
		
		if(!mapRefferenceRepository.exists(2L)){
			MapRefference mapRefference = new MapRefference();
			mapRefference.setParentArticle(articleRepository.findOne(2L));
			mapRefference.setLatitude(49.2222336D);
			mapRefference.setLongitude(18.7389322D);
			mapRefference.setMapType(MapType.TERRAIN);
			
			mapRefferenceRepository.save(mapRefference);
		}
		
		if(!mapMarkerRepository.exists(1L)){
			MapMarker marker = new MapMarker();
			
			marker.setLatitude(49.2119826);
			marker.setLongitude(18.7382199);
			marker.setParentMapRefference(mapRefferenceRepository.findOne(1L));
			marker.setTitle("Radio Rapeš");
			
			mapMarkerRepository.save(marker);
		}
		
		if(!mapMarkerRepository.exists(2L)){
			MapMarker marker = new MapMarker();
			
			marker.setLatitude(49.2098546);
			marker.setLongitude(18.7582395);
			marker.setParentMapRefference(mapRefferenceRepository.findOne(1L));
			marker.setTitle("Internáty velký diel");
			
			mapMarkerRepository.save(marker);
		}
		
		if(!mapRouteRepository.exists(1L)){
			
			MapRoute route = new MapRoute();
			route.setStartAddress("Bratislava");
			route.setEndAddress("Žilina");
			route.setTravelMode(TravelMode.WALKING);
			route.setParentMapRefference(mapRefferenceRepository.findOne(1L));
			
			mapRouteRepository.save(route);
		}
		
		if(!mapLocationRepository.exists(1L)){
			MapLocation location1 = new MapLocation();
			location1.setName("Považská Bystrica");
			location1.setParentMapRoute(mapRouteRepository.findOne(1L));
			location1.setLocationOrder(1);
			
			mapLocationRepository.save(location1);
		}
		
		if(!mapLocationRepository.exists(2L)){
			MapLocation location2 = new MapLocation();
			location2.setName("Trenčín");
			location2.setParentMapRoute(mapRouteRepository.findOne(1L));
			location2.setLocationOrder(2);
			
			mapLocationRepository.save(location2);
		}
		
		if(!mapLocationRepository.exists(3L)){
			MapLocation location3 = new MapLocation();
			location3.setName("Trnava");
			location3.setParentMapRoute(mapRouteRepository.findOne(1L));
			location3.setLocationOrder(3);
			
			mapLocationRepository.save(location3);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.ARTICLE_LOAD_ALL_SERVICE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON)
	@ResponseBody
	public ArticleLoadPageOutputDTO loadAll(){
		
		return ArticleLoadPageOutputDTO.from(FluentIterable.from(articleRepository.findAll()).toList());
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.ARTICLE_LOAD_PAGE_SERVICE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public ArticleLoadPageOutputDTO loadPage(@RequestBody ArticleLoadPageInputDTO dto){
		
		if(dto == null){
			return ArticleLoadPageOutputDTO.asInvalid();
		}
		
		return ArticleLoadPageOutputDTO.from(
				articleRepository.findAll(
						new PageRequest(dto.getStartIndex(),
								dto.getPageSize(),
								Sort.Direction.DESC,
								CREATED_AT_PROP))
				.getContent());
	}
}
