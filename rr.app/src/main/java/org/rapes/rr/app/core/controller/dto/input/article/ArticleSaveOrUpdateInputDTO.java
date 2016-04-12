package org.rapes.rr.app.core.controller.dto.input.article;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class ArticleSaveOrUpdateInputDTO implements InputDTO{
	
	private long id;
	private String mainTitle;
	private String subTitle;
	private String text;
	
	@Override
	public boolean isValid() {
		return new EqualsBuilder()
				.append(false, StringUtils.isEmpty(mainTitle))
				.append(false, StringUtils.isEmpty(subTitle))
				.append(false, StringUtils.isEmpty(text))
				.isEquals();
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
