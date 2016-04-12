package org.rapes.rr.app.core.controller.dto.input.article;

import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class ArticleDeleteInputDTO implements InputDTO {

	private long articleId;
	
	@Override
	public boolean isValid() {
		return articleId !=0L;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

}
