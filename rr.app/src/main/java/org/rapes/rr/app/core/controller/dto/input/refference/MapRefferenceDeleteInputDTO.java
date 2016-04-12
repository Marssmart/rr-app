package org.rapes.rr.app.core.controller.dto.input.refference;

import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapRefferenceDeleteInputDTO implements InputDTO {

	private long mapRefferenceId;
	
	@Override
	public boolean isValid() {
		return mapRefferenceId != 0L;
	}

	public long getMapRefferenceId() {
		return mapRefferenceId;
	}

	public void setMapRefferenceId(long mapRefferenceId) {
		this.mapRefferenceId = mapRefferenceId;
	}

}
