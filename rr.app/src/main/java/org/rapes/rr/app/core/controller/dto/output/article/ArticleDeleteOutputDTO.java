package org.rapes.rr.app.core.controller.dto.output.article;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;

public class ArticleDeleteOutputDTO extends OutputDTO {

	private ArticleDeleteOutputDTO(boolean valid) {
		super(valid);
	}

	public static final ArticleDeleteOutputDTO asInvalid(){
		return new ArticleDeleteOutputDTO(false);
	}
	
	public static final ArticleDeleteOutputDTO success(){
		return new ArticleDeleteOutputDTO(true);
	}
}
