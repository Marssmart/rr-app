package org.rapes.rr.app.core.dao;

import java.util.List;

import org.rapes.rr.app.core.dom.Article;
import org.rapes.rr.app.core.dom.MapLocation;
import org.rapes.rr.app.core.dom.MapRefference;
import org.rapes.rr.app.core.dom.MapRoute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MapLocationRepository  extends PagingAndSortingRepository<MapLocation, Long>{

	@Query("SELECT l FROM MapLocation l WHERE l.parentMapRoute = :route")
	public List<MapLocation> getLocationsForRoute(@Param("route") MapRoute route);
	
	@Query("DELETE FROM MapLocation l WHERE l.parentMapRoute = :route")
	public void deleteLocationsForRoute(@Param("route") MapRoute route);
	
	@Query("DELETE FROM MapLocation loc WHERE loc.parentMapRoute in ("
			+ "SELECT rou FROM MapRoute rou WHERE rou.parentMapRefference in ("
				+ "SELECT ref FROM MapRefference ref WHERE ref.parentArticle = :article))")
	public void deleteLocationsForRoutesForRefferencesOfArticle(@Param("article") Article article);
	
	@Query("DELETE FROM MapLocation loc WHERE loc.parentMapRoute in ("
			+ "SELECT rou FROM MapRoute rou WHERE rou.parentMapRefference = :refference)")
	public void deleteLocatonsForRoutesOfRefference(@Param("refference") MapRefference refference);
}
