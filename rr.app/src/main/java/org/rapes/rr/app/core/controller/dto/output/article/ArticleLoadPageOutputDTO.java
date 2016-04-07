package org.rapes.rr.app.core.controller.dto.output.article;

import java.util.List;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.Article;

public class ArticleLoadPageOutputDTO extends OutputDTO{

	private List<Article> articles;
	
	private ArticleLoadPageOutputDTO(List<Article> articles){
		super(true);
		this.articles=articles;
	}
	
	private ArticleLoadPageOutputDTO(boolean valid){
		super(valid);
	}
	
	public static final ArticleLoadPageOutputDTO asInvalid(){
		return new ArticleLoadPageOutputDTO(false);
	}
	
	public static final ArticleLoadPageOutputDTO from(List<Article> articles){
		return new ArticleLoadPageOutputDTO(articles);
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
