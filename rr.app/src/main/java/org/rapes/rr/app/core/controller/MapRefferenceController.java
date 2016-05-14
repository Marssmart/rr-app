package org.rapes.rr.app.core.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.rapes.rr.app.core.controller.dto.input.refference.MapRefferenceDeleteInputDTO;
import org.rapes.rr.app.core.controller.dto.input.refference.MapRefferenceSaveOrUpdateInputDTO;
import org.rapes.rr.app.core.controller.dto.input.refference.MapRefferencesInputDTO;
import org.rapes.rr.app.core.controller.dto.output.refference.MapRefferenceDeleteOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.refference.MapRefferenceSaveOrUpdateOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.refference.MapRefferencessOutputDTO;
import org.rapes.rr.app.core.controller.params.RequestParams;
import org.rapes.rr.app.core.controller.params.RequestPaths;
import org.rapes.rr.app.core.dao.ArticleRepository;
import org.rapes.rr.app.core.dao.MapLocationRepository;
import org.rapes.rr.app.core.dao.MapMarkerRepository;
import org.rapes.rr.app.core.dao.MapRefferenceRepository;
import org.rapes.rr.app.core.dao.MapRouteRepository;
import org.rapes.rr.app.core.dom.Article;
import org.rapes.rr.app.core.dom.MapRefference;
import org.rapes.rr.app.core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapRefferenceController {
	
	@Autowired
	private MapLocationRepository mapLocationRepository;
	
	@Autowired
	private MapRouteRepository mapRouteRepository;
	
	@Autowired
	private MapMarkerRepository mapMarkerRepository;
	
	@Autowired
	private MapRefferenceRepository mapRefferenceRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private NotificationService notificationService;
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_REFFERENCES_LOAD_FOR_ARTICLE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapRefferencessOutputDTO loadMapRefferences(@RequestBody MapRefferencesInputDTO dto){
	
		if(dto == null){
			return MapRefferencessOutputDTO.asInvalid();
		}
		
		Article article = articleRepository.findOne(dto.getArticleId());
		
		if(article == null){
			return MapRefferencessOutputDTO.asInvalid();
		}
		
		List<MapRefference> mapRefferences = mapRefferenceRepository.getMapRefferencesforArticle(article);
		
		if(CollectionUtils.isEmpty(mapRefferences)){
			return MapRefferencessOutputDTO.asEmpty();
		}
		
		return MapRefferencessOutputDTO.from(mapRefferences);
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_REFFERENCES_SAVE_OR_UPDATE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapRefferenceSaveOrUpdateOutputDTO saveOrUpdate(@RequestBody MapRefferenceSaveOrUpdateInputDTO dto){
		if(dto == null || !dto.isValid()){
			return MapRefferenceSaveOrUpdateOutputDTO.asInvalid();
		}
		
		Article parent = articleRepository.findOne(dto.getParentArticleId());
		
		if(parent == null){
			return MapRefferenceSaveOrUpdateOutputDTO.asInvalid();
		}
		
		MapRefference refference = mapRefferenceRepository.findOne(dto.getId());
		
		if(refference == null){
			refference = new MapRefference();
		}
		
		refference.setParentArticle(parent);
		refference.setLatitude(dto.getLatitude());
		refference.setLongitude(dto.getLongitude());
		
		notificationService.notifyRefreshArticles();
		
		return MapRefferenceSaveOrUpdateOutputDTO.from(mapRefferenceRepository.save(refference));
	}
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_REFFERENCES_DELETE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapRefferenceDeleteOutputDTO delete(@RequestBody MapRefferenceDeleteInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return MapRefferenceDeleteOutputDTO.asInvalid();
		}
		
		MapRefference refference = mapRefferenceRepository.findOne(dto.getMapRefferenceId());
				
		if(refference == null){
			return MapRefferenceDeleteOutputDTO.asInvalid();
		}
		
		mapLocationRepository.deleteLocatonsForRoutesOfRefference(refference);
		mapRouteRepository.deleteRoutesForRefference(refference);
		mapMarkerRepository.deleteMarkerForRefference(refference);
		mapRefferenceRepository.delete(refference);
		
		notificationService.notifyRefreshArticles();
		
		return MapRefferenceDeleteOutputDTO.success();
	}
}
