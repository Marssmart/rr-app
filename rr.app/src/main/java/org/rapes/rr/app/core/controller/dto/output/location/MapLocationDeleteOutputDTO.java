package org.rapes.rr.app.core.controller.dto.output.location;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;

public class MapLocationDeleteOutputDTO extends OutputDTO {

	private MapLocationDeleteOutputDTO(boolean valid) {
		super(valid);
	}

	public static final MapLocationDeleteOutputDTO asInvalid(){
		return new MapLocationDeleteOutputDTO(false);
	}
	
	public static final MapLocationDeleteOutputDTO success(){
		return new MapLocationDeleteOutputDTO(true);
	}
}
