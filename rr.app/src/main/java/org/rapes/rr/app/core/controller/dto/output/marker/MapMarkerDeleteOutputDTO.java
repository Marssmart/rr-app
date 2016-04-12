package org.rapes.rr.app.core.controller.dto.output.marker;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;

public class MapMarkerDeleteOutputDTO extends OutputDTO {

	private MapMarkerDeleteOutputDTO(boolean valid) {
		super(valid);
	}
	
	public static final MapMarkerDeleteOutputDTO asInvalid(){
		return new MapMarkerDeleteOutputDTO(false);
	}
	
	public static final MapMarkerDeleteOutputDTO success(){
		return new MapMarkerDeleteOutputDTO(true);
	}

}
