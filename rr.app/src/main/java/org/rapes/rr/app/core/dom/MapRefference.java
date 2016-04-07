package org.rapes.rr.app.core.dom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.rapes.rr.app.core.dom.enums.MapType;

import com.google.common.base.Function;

@Entity
@Table(name="MAP_REFFERENCE")
public class MapRefference {

	public static final Function<MapRefference,Long> INDEX_BY_PARENT_ARTICLE_ID = new Function<MapRefference,Long>(){

		@Override
		public Long apply(MapRefference ref) {
			return ref.getParentArticle().getId();
	}};
	
	public static final Function<MapRefference,Article> PARENT_ARTICLE_EXTRACTOR = new Function<MapRefference,Article>(){

		@Override
		public Article apply(MapRefference ref) {
			return ref.getParentArticle();
	}};
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="PARENT_ARTICLE_ID")
	private Article parentArticle;
	
	@Column(name="LATITUDE")
	private double latitude;
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@Column(name="MAP_TYPE")
	@Enumerated(EnumType.STRING)
	private MapType mapType;
	
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
        MapRefference that = (MapRefference) obj;
        return id.equals(that.id);
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Article getParentArticle() {
		return parentArticle;
	}
	public void setParentArticle(Article parentArticle) {
		this.parentArticle = parentArticle;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public MapType getMapType() {
		return mapType;
	}
	public void setMapType(MapType mapType) {
		this.mapType = mapType;
	}
	
	
	
	
}
