package org.rapes.rr.app.core.controller.dto.input.marker;

import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapMarkerDeleteInputDTO implements InputDTO {

	private long mapMarkerId;
	
	@Override
	public boolean isValid() {
		return mapMarkerId!=0L;
	}

	public long getMapMarkerId() {
		return mapMarkerId;
	}

	public void setMapMarkerId(long mapMarkerId) {
		this.mapMarkerId = mapMarkerId;
	}

}
