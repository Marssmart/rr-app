package org.rapes.rr.app.core.dom.functions;

import java.time.LocalDateTime;

import org.rapes.rr.app.core.dom.Notification;
import org.rapes.rr.app.core.dom.NotificationSession;

import com.google.common.base.Function;

public final class NotificationToSessionConverter implements Function<Notification,NotificationSession>{

	private final String uuid;
	
	public NotificationToSessionConverter(String uuid){
		this.uuid=uuid;
	}
	
	@Override
	public NotificationSession apply(Notification notification) {
		NotificationSession session = new NotificationSession();
		
		session.setNotification(notification);
		session.setSeenBy(uuid);
		session.setCreatedAt(LocalDateTime.now());
		
		return session;
	}

}
