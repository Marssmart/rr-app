package org.rapes.rr.app.core.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapRouteSaveOrUpdateInputDTO implements InputDTO {

	private long id;
	private long parentRefferenceId;
	private String startAddress;
	private String endAddress;
	
	@Override
	public boolean isValid() {
		return new EqualsBuilder()
				.append(true, parentRefferenceId != 0L)
				.append(false,StringUtils.isEmpty(startAddress))
				.append(false,StringUtils.isEmpty(endAddress))
				.isEquals();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	public long getParentRefferenceId() {
		return parentRefferenceId;
	}

	public void setParentRefferenceId(long parentRefferenceId) {
		this.parentRefferenceId = parentRefferenceId;
	}

	
}
