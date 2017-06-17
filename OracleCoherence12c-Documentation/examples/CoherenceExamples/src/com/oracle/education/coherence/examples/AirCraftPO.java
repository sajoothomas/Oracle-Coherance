package com.oracle.education.coherence.examples;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


import com.tangosol.io.ExternalizableLite;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.ExternalizableHelper;

public class AirCraftPO implements Entity<Long>, Comparable, PortableObject {
	private Long id;
	private Long capacity;
	private String type;
	private String description;
	
	
	public AirCraftPO(long id, long capacity, String type, String description) {
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
		AirCraftPO ap = (AirCraftPO)o;
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
	public void readExternal(PofReader in) throws IOException {
		id = in.readLong(0);
		capacity = in.readLong(1);
		type = in.readString(2);
		description = in.readString(3);
		
	}
	@Override
	public void writeExternal(PofWriter out) throws IOException {
		out.writeLong(0,id);
		out.writeLong(1,capacity);
		out.writeString(2,type);
		out.writeString(3,description);
		
	}
	
	
}
