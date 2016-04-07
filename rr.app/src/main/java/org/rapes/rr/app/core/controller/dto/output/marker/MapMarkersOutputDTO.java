package org.rapes.rr.app.core.controller.dto.output.marker;

import java.util.Collections;
import java.util.List;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapMarker;

public class MapMarkersOutputDTO extends OutputDTO{

	private List<MapMarker> markers;
	
	private MapMarkersOutputDTO(boolean valid) {
		super(valid);
	}

	private MapMarkersOutputDTO(List<MapMarker> markers) {
		super(true);
		this.markers=markers;
	}
	
	public static final MapMarkersOutputDTO asInvalid(){
		return new MapMarkersOutputDTO(false);
	}
	public static final MapMarkersOutputDTO asEmpty(){
		return new MapMarkersOutputDTO(Collections.<MapMarker>emptyList());
	}
	public static final MapMarkersOutputDTO from(List<MapMarker> markers){
		return new MapMarkersOutputDTO(markers);
	}
	
	public List<MapMarker> getMarkers() {
		return markers;
	}

	public void setMarkers(List<MapMarker> markers) {
		this.markers = markers;
	}

}
