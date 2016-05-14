package org.rapes.rr.app.core.dom;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.rapes.rr.app.core.dom.enums.NotificationSeverity;
import org.rapes.rr.app.core.dom.enums.NotificationType;

@Entity
@Table(name="NOTIFICATION")
public class Notification {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="NOTIFICATION_TYPE",nullable=false)
	@Enumerated(EnumType.STRING)
	private NotificationType notificationType;
	
	@Column(name="NOTIFICATION_SEVERITY",nullable=false)
	@Enumerated(EnumType.STRING)
	private NotificationSeverity notificationSeverity;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="TEXT")
	private String text;
	
	@Column(name="CREATED_AT",nullable=false)
	private LocalDateTime createdAt;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public NotificationSeverity getNotificationSeverity() {
		return notificationSeverity;
	}

	public void setNotificationSeverity(NotificationSeverity notificationSeverity) {
		this.notificationSeverity = notificationSeverity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createAt) {
		this.createdAt = createAt;
	}
}
