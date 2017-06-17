package com.oracle.education.coherence.examples.domain;

import java.util.Date;

public class Flight {

	AirPort from;
	AirPort to;
	AirCraftJS aircraft;
	String flightId;
	Date departs;
	boolean inFlight = false;
	public AirCraftJS getAircraft() {
		return aircraft;
	}
	public void setAircraft(AirCraftJS aircraft) {
		this.aircraft = aircraft;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public boolean isInFlight() {
		return inFlight;
	}
	public void setInFlight(boolean inFlight) {
		this.inFlight = inFlight;
	}
	public AirPort getFrom() {
		return from;
	}
	public AirPort getTo() {
		return to;
	}
	public Date getDeparts() {
		return departs;
	}
	
	
}
