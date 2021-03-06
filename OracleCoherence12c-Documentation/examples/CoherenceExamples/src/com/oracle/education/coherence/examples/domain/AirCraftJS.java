package com.oracle.education.coherence.examples.domain;

import java.io.Serializable;


public class AirCraftJS implements Entity<Long>, Comparable, Serializable {
	private Long id;
	private Long capacity;
	private String type;
	private String description;
	
	
	public AirCraftJS(long id, long capacity, String type, String description) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.type = type;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	@Override
	public int compareTo(Object o) {
		AirCraftJS ap = (AirCraftJS)o;
		return description.compareTo(ap.getDescription());
		
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AirCraft [capacity=" + capacity + ", description="
				+ description + ", id=" + id + "]";
	}
	
	
}
