package org.rapes.rr.app.core.service;

import java.time.LocalDateTime;

import org.rapes.rr.app.core.dao.NotificationRepository;
import org.rapes.rr.app.core.dom.Notification;
import org.rapes.rr.app.core.dom.enums.NotificationSeverity;
import org.rapes.rr.app.core.dom.enums.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	public void notifyRefreshArticles(){
		Notification notification = new Notification();
		notification.setCreatedAt(LocalDateTime.now());
		notification.setNotificationSeverity(NotificationSeverity.NORMAL);
		notification.setNotificationType(NotificationType.REFRESH_ARTICLES);
		
		notificationRepository.save(notification);
	}
}
