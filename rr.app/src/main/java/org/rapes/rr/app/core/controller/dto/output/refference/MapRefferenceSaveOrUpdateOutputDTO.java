package org.rapes.rr.app.core.controller.dto.output.refference;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapRefference;

public class MapRefferenceSaveOrUpdateOutputDTO extends OutputDTO {

	private MapRefference refference;
	
	private MapRefferenceSaveOrUpdateOutputDTO(boolean valid) {
		super(valid);
	}
	
	private MapRefferenceSaveOrUpdateOutputDTO(MapRefference refference) {
		super(true);
		this.refference=refference;
	}

	public static final MapRefferenceSaveOrUpdateOutputDTO asInvalid(){
		return new MapRefferenceSaveOrUpdateOutputDTO(false);
	}
	
	public static final MapRefferenceSaveOrUpdateOutputDTO from(MapRefference refference){
		return new MapRefferenceSaveOrUpdateOutputDTO(refference);
	}
	
	public MapRefference getRefference() {
		return refference;
	}

	public void setRefference(MapRefference refference) {
		this.refference = refference;
	}	
}
