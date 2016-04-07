package org.rapes.rr.app.core.controller.dto.output.article;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.Article;

import com.google.common.base.Function;

public class ArticleSaveOrUpdateOutputDTO extends OutputDTO{
	
	public static final Function<Article,ArticleSaveOrUpdateOutputDTO> ARTICLE_TO_DTO_CONVERTER = new Function<Article,ArticleSaveOrUpdateOutputDTO>(){

		@Override
		public ArticleSaveOrUpdateOutputDTO apply(Article article) {
			
			ArticleSaveOrUpdateOutputDTO dto = new ArticleSaveOrUpdateOutputDTO(true);
			
			dto.setId(article.getId());
			dto.setMainTitle(article.getMainTitle());
			dto.setSubTitle(article.getSubTitle());
			
			return dto;
		}};
	
	private long id;
	private String mainTitle;
	private String subTitle;
	
	private ArticleSaveOrUpdateOutputDTO(boolean valid){
		super(valid);
	}
	
	public static final ArticleSaveOrUpdateOutputDTO asInvalid(){
		return new ArticleSaveOrUpdateOutputDTO(false);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	
}
