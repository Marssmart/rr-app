package org.rapes.rr.app.core.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.rapes.rr.app.core.controller.dto.input.marker.MapMarkerDeleteInputDTO;
import org.rapes.rr.app.core.controller.dto.input.marker.MapMarkerSaveOrUpdateInputDTO;
import org.rapes.rr.app.core.controller.dto.input.marker.MapMarkersInputDTO;
import org.rapes.rr.app.core.controller.dto.output.marker.MapMarkerDeleteOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.marker.MapMarkerSaveOrUpdateOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.marker.MapMarkersOutputDTO;
import org.rapes.rr.app.core.controller.params.RequestParams;
import org.rapes.rr.app.core.controller.params.RequestPaths;
import org.rapes.rr.app.core.dao.MapMarkerRepository;
import org.rapes.rr.app.core.dao.MapRefferenceRepository;
import org.rapes.rr.app.core.dom.MapMarker;
import org.rapes.rr.app.core.dom.MapRefference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapMarkerController {

	@Autowired
	private MapRefferenceRepository mapRefferenceRepository;
	
	@Autowired
	private MapMarkerRepository mapMarkerRepository;
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_MARKERS_LOAD_FOR_ARTICLE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapMarkersOutputDTO loadMapRefferenceMarkers(@RequestBody MapMarkersInputDTO dto){
		
		if(dto == null){
			return MapMarkersOutputDTO.asInvalid();
		}
		
		MapRefference mapRefference = mapRefferenceRepository.findOne(dto.getMapRefferenceId());
		
		if(mapRefference == null){
			return MapMarkersOutputDTO.asEmpty();
		}
		
		List<MapMarker> markers = mapMarkerRepository.getMapRefferencesforArticle(mapRefference);
		
		return MapMarkersOutputDTO.from(markers);
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_MARKERS_SAVE_OR_UPDATE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapMarkerSaveOrUpdateOutputDTO saveOrUpdate(@RequestBody MapMarkerSaveOrUpdateInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return MapMarkerSaveOrUpdateOutputDTO.asInvalid();
		}
		
		MapRefference parent = mapRefferenceRepository.findOne(dto.getParrentMapRefferenceId());
		
		if(parent == null){
			return MapMarkerSaveOrUpdateOutputDTO.asInvalid();
		}
		
		MapMarker marker = mapMarkerRepository.findOne(dto.getId());
		
		if(marker == null){
			marker = new MapMarker();
		}
		
		marker.setParentMapRefference(parent);
		marker.setLatitude(dto.getLatitude());
		marker.setLongitude(dto.getLongitude());
		marker.setTitle(dto.getTitle());
	
		return MapMarkerSaveOrUpdateOutputDTO.from(mapMarkerRepository.save(marker));
	}
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value=RequestPaths.MAP_MARKERS_DELETE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public MapMarkerDeleteOutputDTO delete(@RequestBody MapMarkerDeleteInputDTO dto){
		
		if(dto == null || !dto.isValid()){
			return MapMarkerDeleteOutputDTO.asInvalid();
		}
		
		mapMarkerRepository.delete(dto.getMapMarkerId());
		
		return MapMarkerDeleteOutputDTO.success();
	}
}
