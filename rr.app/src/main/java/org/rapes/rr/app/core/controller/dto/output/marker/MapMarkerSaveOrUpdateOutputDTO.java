package org.rapes.rr.app.core.controller.dto.output.marker;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapMarker;

public class MapMarkerSaveOrUpdateOutputDTO extends OutputDTO {

	private MapMarker marker;
	
	private MapMarkerSaveOrUpdateOutputDTO(boolean valid) {
		super(valid); 
	}
	
	private MapMarkerSaveOrUpdateOutputDTO(MapMarker marker) {
		super(true); 
		this.marker=marker;
	}
	
	public static final MapMarkerSaveOrUpdateOutputDTO asInvalid(){
		return new MapMarkerSaveOrUpdateOutputDTO(false);
	}
	
	public static final MapMarkerSaveOrUpdateOutputDTO from(MapMarker marker){
		return new MapMarkerSaveOrUpdateOutputDTO(marker);
	}

	public MapMarker getMarker() {
		return marker;
	}

	public void setMarker(MapMarker marker) {
		this.marker = marker;
	}
}
