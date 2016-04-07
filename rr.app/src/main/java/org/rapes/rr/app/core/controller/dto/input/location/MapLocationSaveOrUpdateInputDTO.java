package org.rapes.rr.app.core.controller.dto.input.location;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.rapes.rr.app.core.controller.dto.input.InputDTO;

public class MapLocationSaveOrUpdateInputDTO implements InputDTO{

	private long id;
	private long parentRouteId;
	private int order;
	private String name;
	
	@Override
	public boolean isValid() {
		return new EqualsBuilder()
				.append(true,parentRouteId!= 0L)
				.append(true,order!= 0)
				.append(false,StringUtils.isEmpty(name))
				.isEquals();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getParentRouteId() {
		return parentRouteId;
	}

	public void setParentRouteId(long parentRouteId) {
		this.parentRouteId = parentRouteId;
	}
}
