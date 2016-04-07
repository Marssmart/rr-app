package org.rapes.rr.app.core.dao;

import java.time.LocalDateTime;

import org.rapes.rr.app.core.dom.NotificationSession;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface NotificationSessionRepository extends PagingAndSortingRepository<NotificationSession, Long>{

	@Modifying
	@Query("DELETE FROM NotificationSession ns WHERE ns.createdAt <= :stamp")
	public void cleanup(@Param("stamp") LocalDateTime stamp);
}
