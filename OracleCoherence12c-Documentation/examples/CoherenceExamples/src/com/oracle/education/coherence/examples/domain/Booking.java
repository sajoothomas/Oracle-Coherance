package com.oracle.education.coherence.examples.domain;

import java.io.Serializable;

import com.tangosol.net.cache.KeyAssociation;

public class Booking implements Entity<Booking.Id>, Comparable, Serializable  {
	
	public static class Id implements Serializable, KeyAssociation {
		public Long getCustomerId() {
			return customerId;
		}
		public Long getBookingId() {
			return bookingId;
		}
		public Id() { };
		public Id(long customerId, long bookingId) {
			super();
			this.customerId = customerId;
			this.bookingId = bookingId;
		}
		@Override
		public Object getAssociatedKey() {
			return customerId;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((bookingId == null) ? 0 : bookingId.hashCode());
			result = prime * result
					+ ((customerId == null) ? 0 : customerId.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (bookingId == null) {
				if (other.bookingId != null)
					return false;
			} else if (!bookingId.equals(other.bookingId))
				return false;
			if (customerId == null) {
				if (other.customerId != null)
					return false;
			} else if (!customerId.equals(other.customerId))
				return false;
			return true;
		}
		private Long customerId;
		private Long bookingId;
		
	}
	
	private Id id;
	

	

	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}



	public Booking(Long customerId, long bookingId) {
		super();
		this.id = new Id(customerId, bookingId);
		
	}



	@Override
	public Id getId() {
		return id;
	}
}
