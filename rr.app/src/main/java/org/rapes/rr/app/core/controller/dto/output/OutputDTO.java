package org.rapes.rr.app.core.controller.dto.output;

public abstract class OutputDTO {

	private final boolean valid;

	public OutputDTO(boolean valid){
		this.valid=valid;
	}
	
	public boolean isValid() {
		return valid;
	}
}
