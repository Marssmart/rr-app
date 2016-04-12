package org.rapes.rr.app.core.controller.dto.output.article;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.Article;

public class ArticleSaveOrUpdateOutputDTO extends OutputDTO{
	
	private Article article;
	
	private ArticleSaveOrUpdateOutputDTO(boolean valid){
		super(valid);
	}
	
	private ArticleSaveOrUpdateOutputDTO(Article article){
		super(true);
		this.article=article;
	}
	
	public static final ArticleSaveOrUpdateOutputDTO asInvalid(){
		return new ArticleSaveOrUpdateOutputDTO(false);
	}

	public static final ArticleSaveOrUpdateOutputDTO from(Article article){
		return new ArticleSaveOrUpdateOutputDTO(article);
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
