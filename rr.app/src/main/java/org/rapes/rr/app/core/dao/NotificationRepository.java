package org.rapes.rr.app.core.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.rapes.rr.app.core.dom.Notification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends PagingAndSortingRepository<Notification, Long>{

	@Query("SELECT n FROM Notification n WHERE n NOT IN (SELECT ns.notification FROM NotificationSession ns WHERE ns.seenBy = :uuid)")
	public List<Notification> getRelevantNotifications(@Param("uuid")String uuid);

	@Modifying
	@Query("DELETE FROM Notification n WHERE n.createdAt <= :stamp")
	public void cleanup(@Param("stamp") LocalDateTime stamp);
}
