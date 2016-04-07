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

import org.rapes.rr.app.core.dom.enums.TravelMode;

@Entity
@Table(name="MAP_ROUTE")
public class MapRoute {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@ManyToOne
    @JoinColumn(name="PARENT_MAP_REFFERENCE_ID")
	private MapRefference parentMapRefference;
	
	@Column(name="START_ADDRESS")
	private String startAddress;
	
	@Column(name="END_ADDRESS")
	private String endAddress;
	
	@Column(name="TRAVEL_MODE")
	@Enumerated(EnumType.STRING)
	private TravelMode travelMode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	public TravelMode getTravelMode() {
		return travelMode;
	}

	public void setTravelMode(TravelMode travelMode) {
		this.travelMode = travelMode;
	}

	public MapRefference getParentMapRefference() {
		return parentMapRefference;
	}

	public void setParentMapRefference(MapRefference parentMapRefference) {
		this.parentMapRefference = parentMapRefference;
	}
}
