package org.rapes.rr.app.core.controller.dto.output.route;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;

public class MapRouteDeleteOutputDTO extends OutputDTO {

	private MapRouteDeleteOutputDTO(boolean valid) {
		super(valid);
	}
	
	public static final MapRouteDeleteOutputDTO asInvalid(){
		return new MapRouteDeleteOutputDTO(false);
	}

	public static final MapRouteDeleteOutputDTO success(){
		return new MapRouteDeleteOutputDTO(true);
	}
}
