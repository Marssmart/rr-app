package org.rapes.rr.app.core.controller;

import org.rapes.rr.app.core.controller.dto.input.location.MapLocationInputDTO;
import org.rapes.rr.app.core.controller.dto.input.location.MapLocationSaveOrUpdateInputDTO;
import org.rapes.rr.app.core.controller.dto.output.location.MapLocationOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.location.MapLocationSaveOrUpdateOutputDTO;
import org.rapes.rr.app.core.controller.params.RequestParams;
import org.rapes.rr.app.core.controller.params.RequestPaths;
import org.rapes.rr.app.core.dao.MapLocationRepository;
import org.rapes.rr.app.core.dao.MapRouteRepository;
import org.rapes.rr.app.core.dom.MapLocation;
import org.rapes.rr.app.core.dom.MapRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapLocationController {

	@Autowired
	private MapLocationRepository mapLocationRepository;
	
	@Autowired
	private MapRouteRepository mapRouteRepository;
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_LOCATION_LOAD_FOR_ROUTE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapLocationOutputDTO getMapLocationsForMapRoute(@RequestBody MapLocationInputDTO dto){
		
		if(dto == null){
			return MapLocationOutputDTO.asInvalid();
		}
		
		MapRoute route = mapRouteRepository.findOne(dto.getRouteId());
		
		if(route == null){
			return MapLocationOutputDTO.asEmpty();
		}
		
		return MapLocationOutputDTO.from(mapLocationRepository.getLocationsForRoute(route));
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_LOCATION_SAVE_OR_UPDATE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapLocationSaveOrUpdateOutputDTO saveOrUpdate(@RequestBody MapLocationSaveOrUpdateInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return MapLocationSaveOrUpdateOutputDTO.asInvalid();
		}
		
		MapRoute parent = mapRouteRepository.findOne(dto.getParentRouteId());
		
		if(parent == null){
			return MapLocationSaveOrUpdateOutputDTO.asInvalid();
		}
		
		MapLocation location = mapLocationRepository.findOne(dto.getId());
		
		if(location == null){
			location = new MapLocation();
		}
		
		location.setParentMapRoute(parent);
		location.setName(dto.getName());
		location.setLocationOrder(dto.getOrder());
		
		return MapLocationSaveOrUpdateOutputDTO.from(mapLocationRepository.save(location));
	}
}
