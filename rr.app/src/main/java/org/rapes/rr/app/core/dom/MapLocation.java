package org.rapes.rr.app.core.dom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MAP_LOCATION")
public class MapLocation {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="PARENT_MAP_ROUTE_ID")
	private MapRoute parentMapRoute;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION_ORDER")
	private int locationOrder;

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
        MapLocation that = (MapLocation) obj;
        return id.equals(that.id);
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MapRoute getParentMapRoute() {
		return parentMapRoute;
	}

	public void setParentMapRoute(MapRoute parentMapRoute) {
		this.parentMapRoute = parentMapRoute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocationOrder() {
		return locationOrder;
	}

	public void setLocationOrder(int locationOrder) {
		this.locationOrder = locationOrder;
	}	
}
