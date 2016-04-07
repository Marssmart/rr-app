package org.rapes.rr.app.core.controller.dto.output.notification;

import java.util.Collections;
import java.util.List;

import org.rapes.rr.app.core.controller.dto.output.OutputDTO;
import org.rapes.rr.app.core.dom.Notification;

public class NotificationOutputDTO extends OutputDTO{

	private List<Notification> notifications;
	
	private NotificationOutputDTO(boolean valid) {
		super(valid);
	}
	
	private NotificationOutputDTO(List<Notification> notifications) {
		super(true);
		this.notifications=notifications;
	}

	public static final NotificationOutputDTO asInvalid(){
		return new NotificationOutputDTO(false);
	}
	
	public static final NotificationOutputDTO asEmpty(){
		return new NotificationOutputDTO(Collections.<Notification>emptyList());
	}
	
	public static final NotificationOutputDTO from(List<Notification> notifications){
		return new NotificationOutputDTO(notifications);
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
}
