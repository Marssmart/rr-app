package org.rapes.rr.app.core.dom;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARTICLE")
public class Article {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="MAIN_TITLE",nullable=false)
	private String mainTitle;
	
	@Column(name="SUB_TITLE")
	private String subTitle;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="PUBLISHED",nullable=false)
	private boolean published = false;
	
	@Column(name="CREATED_AT",nullable=false)
	private LocalDateTime createdAt;
	
	@Override
	public int hashCode() {
		return id == null ? 0 :id.hashCode(); 
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        Article that = (Article) obj;
        return id.equals(that.id);
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
