package org.rapes.rr.app.core.controller.dto.input.marker;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapMarkerSaveOrUpdateInputDTO implements InputDTO{

	private long id;
	private long parrentMapRefferenceId;
	private double latitude;
	private double longitude;
	private String title;
	
	@Override
	public boolean isValid() {
		return new EqualsBuilder()
				.append(true, parrentMapRefferenceId != 0L)
				.append(true, latitude != 0D)
				.append(true, longitude != 0D)
				.append(false,StringUtils.isEmpty(title))
				.isEquals();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParrentMapRefferenceId() {
		return parrentMapRefferenceId;
	}

	public void setParrentMapRefferenceId(long parrentMapRefferenceId) {
		this.parrentMapRefferenceId = parrentMapRefferenceId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
