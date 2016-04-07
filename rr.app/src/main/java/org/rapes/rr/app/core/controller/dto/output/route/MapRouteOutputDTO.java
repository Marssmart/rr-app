package org.rapes.rr.app.core.controller.dto.output.route;

import java.util.Collections;
import java.util.List;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.MapRoute;

public class MapRouteOutputDTO extends OutputDTO {

	private List<MapRoute> mapRoutes;
	
	private MapRouteOutputDTO(boolean valid) {
		super(valid);
	}
	
	private MapRouteOutputDTO(List<MapRoute> mapRoutes) {
		super(false);
		this.mapRoutes=mapRoutes;
	}

	public static final MapRouteOutputDTO asInvalid(){
		return new MapRouteOutputDTO(false);
	}
	
	public static final MapRouteOutputDTO asEmpty(){
		return new MapRouteOutputDTO(Collections.<MapRoute>emptyList());
	}
	
	public static final MapRouteOutputDTO from(List<MapRoute> mapRoutes){
		return new MapRouteOutputDTO(mapRoutes);
	}

	public List<MapRoute> getMapRoutes() {
		return mapRoutes;
	}

	public void setMapRoutes(List<MapRoute> mapRoutes) {
		this.mapRoutes = mapRoutes;
	}


}
