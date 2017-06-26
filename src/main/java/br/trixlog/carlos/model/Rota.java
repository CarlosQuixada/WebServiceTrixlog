package br.trixlog.carlos.model;

import java.util.Date;
import java.util.List;

public class Rota {
	private String name;
	private Date routeDate;
	private Long vehicledId;
	private List<Parada> stops;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRouteDate() {
		return routeDate;
	}

	public void setRouteDate(Date routeDate) {
		this.routeDate = routeDate;
	}

	public Long getVehicledId() {
		return vehicledId;
	}

	public void setVehicledId(Long vehicledId) {
		this.vehicledId = vehicledId;
	}

	public List<Parada> getStops() {
		return stops;
	}

	public void setStops(List<Parada> stops) {
		this.stops = stops;
	}

}
