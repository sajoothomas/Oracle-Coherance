package com.oracle.education.coherence.examples.domain;

import com.tangosol.net.PartitionedService;
import com.tangosol.net.partition.KeyAssociator;

public class BookingAssociator implements KeyAssociator {

	private transient PartitionedService service;
	public void init(PartitionedService service) { this.service = service; }
	
	
	public Object getAssociatedKey(Object key) {
		
		if ( key instanceof Booking.Id)
			return ((Booking.Id)key).getCustomerId();
		else
		return key;
	}
}
