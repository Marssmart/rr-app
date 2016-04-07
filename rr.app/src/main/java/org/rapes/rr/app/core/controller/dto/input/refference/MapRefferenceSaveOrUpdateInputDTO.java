package org.rapes.rr.app.core.controller.dto.input.refference;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapRefferenceSaveOrUpdateInputDTO implements InputDTO{

	private long id;
	private long parentArticleId;
	private double latitude;
	private double longitude;
	
	@Override
	public boolean isValid() {
		return new EqualsBuilder()
				.append(true,parentArticleId != 0L)
				.append(true,latitude != 0D)
				.append(true,longitude != 0D)
				.isEquals();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentArticleId() {
		return parentArticleId;
	}

	public void setParentArticleId(long parentArticleId) {
		this.parentArticleId = parentArticleId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
