package org.rapes.rr.app.core.dao;

import java.util.List;

import org.rapes.rr.app.core.dom.Article;
import org.rapes.rr.app.core.dom.MapRefference;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRefferenceRepository extends PagingAndSortingRepository<MapRefference, Long>{

	@Query("SELECT mr FROM MapRefference mr WHERE mr.parentArticle=:article")
	public List<MapRefference> getMapRefferencesforArticle(@Param("article")Article article);
	
	@Modifying
	@Query("DELETE FROM MapRefference mr WHERE mr.parentArticle = :article")
	public void deleteRefferencesForArticle(@Param("article") Article article);
}
