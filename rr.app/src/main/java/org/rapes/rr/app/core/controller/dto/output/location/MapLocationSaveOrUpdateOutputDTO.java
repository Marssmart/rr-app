package org.rapes.rr.app.core.controller.dto.output.location;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapLocation;

public class MapLocationSaveOrUpdateOutputDTO extends OutputDTO {

	private MapLocation location;
	
	public MapLocationSaveOrUpdateOutputDTO(boolean valid) {
		super(valid);
	}
	
	public MapLocationSaveOrUpdateOutputDTO(MapLocation location) {
		super(true);
		this.location=location;
	}

	public static final MapLocationSaveOrUpdateOutputDTO asInvalid(){
		return new MapLocationSaveOrUpdateOutputDTO(false);
	}
	
	public static final MapLocationSaveOrUpdateOutputDTO from(MapLocation location){
		return new MapLocationSaveOrUpdateOutputDTO(location);
	}

	public MapLocation getLocation() {
		return location;
	}

	public void setLocation(MapLocation location) {
		this.location = location;
	}

}
