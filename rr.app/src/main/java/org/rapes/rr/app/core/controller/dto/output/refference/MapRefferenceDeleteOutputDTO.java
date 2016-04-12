package org.rapes.rr.app.core.controller.dto.output.refference;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;

public class MapRefferenceDeleteOutputDTO extends OutputDTO {

	private MapRefferenceDeleteOutputDTO(boolean valid) {
		super(valid);
	}
	
	public static final MapRefferenceDeleteOutputDTO asInvalid(){
		return new MapRefferenceDeleteOutputDTO(false);
	}
	
	public static final MapRefferenceDeleteOutputDTO success(){
		return new MapRefferenceDeleteOutputDTO(true);
	}

}
