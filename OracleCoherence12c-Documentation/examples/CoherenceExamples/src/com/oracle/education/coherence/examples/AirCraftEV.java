package com.oracle.education.coherence.examples;

import java.io.Serializable;

import com.tangosol.io.Evolvable;
import com.tangosol.util.Binary;

public class AirCraftEV implements Entity<Long>, Comparable, Serializable, Evolvable {
	private Long id;
	private Long capacity;
	private String type;
	private String description;
	
	public static final int VERSION = 1;
	private int dataVersion;
	private Binary futureData;
	
	public AirCraftEV(long id, long capacity, String type, String description) {
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
		AirCraftEV ap = (AirCraftEV)o;
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
	@Override
	public int getDataVersion() {
		return dataVersion;
	}
	@Override
	public Binary getFutureData() {
		// TODO Auto-generated method stub
		return futureData;
	}
	@Override
	public int getImplVersion() {
		// TODO Auto-generated method stub
		return VERSION;
	}
	@Override
	public void setDataVersion(int dataVersion) {
		this.dataVersion = dataVersion;
		
	}
	public void setFutureData(Binary futureData) {
		this.futureData = futureData;
	}
	
	
}