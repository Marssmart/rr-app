package org.rapes.rr.app.core.controller.dto.output.refference;

import java.util.Collections;
import java.util.List;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapRefference;

public class MapRefferencessOutputDTO extends OutputDTO {

	private List<MapRefference> mapRefferences;
	
	private MapRefferencessOutputDTO(boolean valid) {
		super(valid);
	}
	
	private MapRefferencessOutputDTO(List<MapRefference> mapRefferences) {
		super(true);
		this.mapRefferences=mapRefferences;
	}
	
	public static final MapRefferencessOutputDTO asInvalid(){
		return new MapRefferencessOutputDTO(false);
	}
	
	public static final MapRefferencessOutputDTO from(List<MapRefference> mapRefferences){
		return new MapRefferencessOutputDTO(mapRefferences);
	}
	
	public static final MapRefferencessOutputDTO asEmpty(){
		return new MapRefferencessOutputDTO(Collections.<MapRefference>emptyList());
	}
	
	public List<MapRefference> getMapRefferences() {
		return mapRefferences;
	}

	public void setMapRefferences(List<MapRefference> mapRefferences) {
		this.mapRefferences = mapRefferences;
	}
	
	
}
