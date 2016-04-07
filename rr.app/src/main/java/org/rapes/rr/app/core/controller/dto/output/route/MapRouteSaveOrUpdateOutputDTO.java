package org.rapes.rr.app.core.controller.dto.output.route;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapRoute;

public class MapRouteSaveOrUpdateOutputDTO extends OutputDTO {

	private MapRoute route;
	
	private MapRouteSaveOrUpdateOutputDTO(boolean valid) {
		super(valid);
	}
	
	private MapRouteSaveOrUpdateOutputDTO(MapRoute route) {
		super(true);
		this.route=route;
	}

	public static final MapRouteSaveOrUpdateOutputDTO asInvalid(){
		return new MapRouteSaveOrUpdateOutputDTO(false);
	}
	
	public static final MapRouteSaveOrUpdateOutputDTO from(MapRoute route){
		return new MapRouteSaveOrUpdateOutputDTO(route);
	}
	
	public MapRoute getRoute() {
		return route;
	}

	public void setRoute(MapRoute route) {
		this.route = route;
	}
	
	

}
