package org.rapes.rr.app.core.controller;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.rapes.rr.app.core.controller.dto.input.article.ArticleDeleteInputDTO;
import org.rapes.rr.app.core.controller.dto.input.article.ArticleLoadPageInputDTO;
import org.rapes.rr.app.core.controller.dto.input.article.ArticleSaveOrUpdateInputDTO;
import org.rapes.rr.app.core.controller.dto.output.article.ArticleDeleteOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.article.ArticleLoadPageOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.article.ArticleSaveOrUpdateOutputDTO;
import org.rapes.rr.app.core.controller.params.RequestParams;
import org.rapes.rr.app.core.controller.params.RequestPaths;
import org.rapes.rr.app.core.dao.ArticleRepository;
import org.rapes.rr.app.core.dao.MapLocationRepository;
import org.rapes.rr.app.core.dao.MapMarkerRepository;
import org.rapes.rr.app.core.dao.MapRefferenceRepository;
import org.rapes.rr.app.core.dao.MapRouteRepository;
import org.rapes.rr.app.core.dom.Article;
import org.rapes.rr.app.core.service.NotificationService;
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
	
	@Autowired
	private NotificationService notificationService;
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.ARTICLE_SAVE_OR_UPDATE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON)
	@ResponseBody
	public ArticleSaveOrUpdateOutputDTO saveOrUpdate(@RequestBody ArticleSaveOrUpdateInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return ArticleSaveOrUpdateOutputDTO.asInvalid();
		}
		
		Article article =articleRepository.findOne(dto.getId());
		if(article == null){
			article = new Article();
			article.setCreatedAt(LocalDateTime.now());
		}
		
		article.setMainTitle(dto.getMainTitle());
		article.setSubTitle(dto.getSubTitle());
		article.setContent(dto.getText());
		
		ArticleSaveOrUpdateOutputDTO output = ArticleSaveOrUpdateOutputDTO.from(articleRepository.save(article));
		
		notificationService.notifyRefreshArticles();
		
		return output;
	}
	

	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.ARTICLE_LOAD_ALL,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON)
	@ResponseBody
	public ArticleLoadPageOutputDTO loadAll(){
		
		return ArticleLoadPageOutputDTO.from(FluentIterable.from(articleRepository.findAll()).toList());
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.ARTICLE_LOAD_PAGE,
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
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value=RequestPaths.ARTICLE_DELETE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public ArticleDeleteOutputDTO delete(@RequestBody ArticleDeleteInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return ArticleDeleteOutputDTO.asInvalid();
		}
		
		Article article = articleRepository.findOne(dto.getArticleId());
		
		if(article == null){
			return ArticleDeleteOutputDTO.asInvalid();
		}
		
		mapLocationRepository.deleteLocationsForRoutesForRefferencesOfArticle(article);
		mapRouteRepository.deleteRoutesForRefferencesOfArticle(article);
		mapMarkerRepository.deleteMarkersForRefferencesOfArticle(article);
		mapRefferenceRepository.deleteRefferencesForArticle(article);
		articleRepository.delete(article);

		notificationService.notifyRefreshArticles();
		
		return ArticleDeleteOutputDTO.success();
	}
}
