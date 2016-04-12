package org.rapes.rr.app.core.controller;

import javax.transaction.Transactional;

import org.rapes.rr.app.core.controller.dto.input.route.MapRouteDeleteInputDTO;
import org.rapes.rr.app.core.controller.dto.input.route.MapRouteInputDTO;
import org.rapes.rr.app.core.controller.dto.input.route.MapRouteSaveOrUpdateInputDTO;
import org.rapes.rr.app.core.controller.dto.output.route.MapRouteDeleteOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.route.MapRouteOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.route.MapRouteSaveOrUpdateOutputDTO;
import org.rapes.rr.app.core.controller.params.RequestParams;
import org.rapes.rr.app.core.controller.params.RequestPaths;
import org.rapes.rr.app.core.dao.MapLocationRepository;
import org.rapes.rr.app.core.dao.MapRefferenceRepository;
import org.rapes.rr.app.core.dao.MapRouteRepository;
import org.rapes.rr.app.core.dom.MapRefference;
import org.rapes.rr.app.core.dom.MapRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapRouteController {

	@Autowired
	private MapLocationRepository mapLocationRepository;
	
	@Autowired
	private MapRouteRepository mapRouteRepository;
	
	@Autowired
	private MapRefferenceRepository mapRefferenceRepository;
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_ROUTE_LOAD_FOR_MAP_REFFERENCE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapRouteOutputDTO loadPage(@RequestBody MapRouteInputDTO dto){
		
		if(dto == null){
			return MapRouteOutputDTO.asInvalid();
		}
		
		MapRefference parentMapRefference = mapRefferenceRepository.findOne(dto.getMapRefferenceId());
		
		if(parentMapRefference == null){
			return MapRouteOutputDTO.asEmpty();
		}
		
		return MapRouteOutputDTO.from(mapRouteRepository.getMapRoutesForMapRefference(parentMapRefference));
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_ROUTE_SAVE_OR_UPDATE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapRouteSaveOrUpdateOutputDTO saveOrUpdate (@RequestBody MapRouteSaveOrUpdateInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return MapRouteSaveOrUpdateOutputDTO.asInvalid();
		}
		
		MapRefference parent = mapRefferenceRepository.findOne(dto.getParentRefferenceId());
		
		if(parent == null){	
			return MapRouteSaveOrUpdateOutputDTO.asInvalid();
		}
		
		MapRoute route = mapRouteRepository.findOne(dto.getId());
		
		if(route == null){
			route = new MapRoute();
		}
		
		route.setParentMapRefference(parent);
		route.setStartAddress(dto.getStartAddress());
		route.setEndAddress(dto.getEndAddress());
		
		return MapRouteSaveOrUpdateOutputDTO.from(mapRouteRepository.save(route));
	}
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_ROUTE_DELETE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapRouteDeleteOutputDTO delete(@RequestBody MapRouteDeleteInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return MapRouteDeleteOutputDTO.asInvalid();
		}
		
		MapRoute route = mapRouteRepository.findOne(dto.getMapRouteId());
		
		if(route == null){
			return MapRouteDeleteOutputDTO.asInvalid();			
		}
		
		mapLocationRepository.deleteLocationsForRoute(route);
		mapRouteRepository.delete(route);
		
		return MapRouteDeleteOutputDTO.success();
	}
}
