package com.oracle.education.coherence.examples;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


import com.tangosol.io.ExternalizableLite;
import com.tangosol.util.ExternalizableHelper;

public class AirCraftEL implements Entity<Long>, Comparable, ExternalizableLite {
	private Long id;
	private Long capacity;
	private String type;
	private String description;
	
	
	public AirCraftEL(long id, long capacity, String type, String description) {
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
		AirCraftEL ap = (AirCraftEL)o;
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
	public void readExternal(DataInput in) throws IOException {
		id = new Long(in.readLong());
		capacity = new Long(in.readLong());
		type = ExternalizableHelper.readSafeUTF(in);
		description = ExternalizableHelper.readSafeUTF(in);
	}
	@Override
	public void writeExternal(DataOutput out) throws IOException {
		out.writeLong(id.longValue());
		out.writeLong(capacity.longValue());
		ExternalizableHelper.writeSafeUTF(out, type);
		ExternalizableHelper.writeSafeUTF(out, description);
	}
	
	
}
