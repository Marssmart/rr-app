package org.rapes.rr.app.core.dom;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATION_SESSION")
public class NotificationSession {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@ManyToOne
    @JoinColumn(name="NOTIFICATION_ID")
	private Notification notification;
	
	@Column(name="SEEN_BY")
	private String seenBy;
	
	@Column(name="CREATED_AT")
	private LocalDateTime createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public String getSeenBy() {
		return seenBy;
	}

	public void setSeenBy(String seenBy) {
		this.seenBy = seenBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
