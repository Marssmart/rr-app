package org.rapes.rr.app.core.controller.dto.output.location;

import java.util.List;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapLocation;

public class MapLocationOutputDTO extends OutputDTO {

	private List<MapLocation> locations;
	
	private MapLocationOutputDTO(boolean valid) {
		super(valid);
	}
	
	private MapLocationOutputDTO(List<MapLocation> locations){
		super(true);
		this.locations=locations;
	}
	
	public static final MapLocationOutputDTO asInvalid(){
		return new MapLocationOutputDTO(false);
	}
	
	public static final MapLocationOutputDTO asEmpty(){
		return new MapLocationOutputDTO(true);
	}
	
	public static final MapLocationOutputDTO from(List<MapLocation> locations){
		return new MapLocationOutputDTO(locations);
	}

	public List<MapLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<MapLocation> locations) {
		this.locations = locations;
	}

}
