package org.rapes.rr.app.core.dao;

import java.util.List;

import org.rapes.rr.app.core.dom.MapLocation;
import org.rapes.rr.app.core.dom.MapRoute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MapLocationRepository  extends PagingAndSortingRepository<MapLocation, Long>{

	@Query("SELECT l FROM MapLocation l WHERE l.parentMapRoute = :route")
	public List<MapLocation> getLocationsForRoute(@Param("route") MapRoute route);
}
