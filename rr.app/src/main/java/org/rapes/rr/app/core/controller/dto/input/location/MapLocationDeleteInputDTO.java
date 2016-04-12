package org.rapes.rr.app.core.controller.dto.input.location;

import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapLocationDeleteInputDTO implements InputDTO{

	private long mapLocationId;

	public long getMapLocationId() {
		return mapLocationId;
	}

	public void setMapLocationId(long mapLocationId) {
		this.mapLocationId = mapLocationId;
	}

	@Override
	public boolean isValid() {
		return mapLocationId !=0L;
	}
	
	
}
