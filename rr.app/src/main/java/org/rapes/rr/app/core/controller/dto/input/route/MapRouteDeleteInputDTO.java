package org.rapes.rr.app.core.controller.dto.input.route;

import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapRouteDeleteInputDTO implements InputDTO {

	private long mapRouteId;
	
	@Override
	public boolean isValid() {
		return mapRouteId !=0L;
	}

	public long getMapRouteId() {
		return mapRouteId;
	}

	public void setMapRouteId(long mapRouteId) {
		this.mapRouteId = mapRouteId;
	}

}
