package org.rapes.rr.app.core.dao;

import java.util.List;

import org.rapes.rr.app.core.dom.MapMarker;
import org.rapes.rr.app.core.dom.MapRefference;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MapMarkerRepository  extends PagingAndSortingRepository<MapMarker, Long>{

	@Query("SELECT mr FROM MapMarker mr WHERE mr.parentMapRefference=:refference")
	public List<MapMarker> getMapRefferencesforArticle(@Param("refference")MapRefference refference);
}
