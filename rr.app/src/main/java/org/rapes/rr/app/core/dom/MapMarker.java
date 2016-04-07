package org.rapes.rr.app.core.dom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MAP_MARKER")
public class MapMarker {

	@Id 
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="PARENT_MAP_REFFERENCE_ID")
	private MapRefference parentMapRefference;
	
	@Column(name="LATITUDE")
	private double latitude;
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@Column(name="TITLE")
	private String title;
	
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
        MapMarker that = (MapMarker) obj;
        return id.equals(that.id);
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MapRefference getParentMapRefference() {
		return parentMapRefference;
	}

	public void setParentMapRefference(MapRefference parentMapRefference) {
		this.parentMapRefference = parentMapRefference;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
