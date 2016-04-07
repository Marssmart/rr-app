package org.rapes.rr.app.core.controller.dto.input.article;

import org.rapes.rr.app.core.dom.Article;

import com.google.common.base.Function;

public class ArticleSaveOrUpdateInputDTO {
	
	public static final Function<ArticleSaveOrUpdateInputDTO,Article> DTO_TO_ARTICLE_CONVERTER = new Function<ArticleSaveOrUpdateInputDTO,Article>(){

		@Override
		public Article apply(ArticleSaveOrUpdateInputDTO dto) {
			Article article = new Article();
			
			article.setId(dto.getId());
			article.setMainTitle(dto.getMainTitle());
			article.setSubTitle(dto.getSubTitle());
			
			return article;
		}};
	
	private long id;
	private String mainTitle;
	private String subTitle;
	
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
