package org.rapes.rr.app.core.dao;

import java.util.List;

import org.rapes.rr.app.core.dom.Article;
import org.rapes.rr.app.core.dom.MapRefference;
import org.rapes.rr.app.core.dom.MapRoute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRouteRepository extends PagingAndSortingRepository<MapRoute, Long>{

	@Query("SELECT mr FROM MapRoute mr WHERE mr.parentMapRefference=:mapRefference")
	public List<MapRoute> getMapRoutesForMapRefference(@Param("mapRefference")MapRefference mapRefference);
	
	@Query("DELETE FROM MapRoute mr WHERE mr.parentMapRefference = :refference")
	public void deleteRoutesForRefference(@Param("refference") MapRefference refference);
	
	@Query("DELETE FROM MapRoute route WHERE route.parentMapRefference in ("
			+ "SELECT ref FROM MapRefference ref WHERE ref.parentArticle = :article)")
	public void deleteRoutesForRefferencesOfArticle(@Param("article") Article article);
}
