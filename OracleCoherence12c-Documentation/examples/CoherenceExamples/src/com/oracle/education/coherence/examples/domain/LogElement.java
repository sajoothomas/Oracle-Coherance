package com.oracle.education.coherence.examples.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogElement implements Serializable, Comparable {

	public class LogKey implements Serializable {
		private Long severity;
		private Timestamp time;
		public LogKey (long severity) {
			this.severity = severity;
			this.time = new Timestamp(System.currentTimeMillis());
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((severity == null) ? 0 : severity.hashCode());
			result = prime * result + ((time == null) ? 0 : time.hashCode());
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
			LogKey other = (LogKey) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (severity == null) {
				if (other.severity != null)
					return false;
			} else if (!severity.equals(other.severity))
				return false;
			if (time == null) {
				if (other.time != null)
					return false;
			} else if (!time.equals(other.time))
				return false;
			return true;
		}
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("LogElement.LogKey (\n");
			sb.append("\t").append("Severity:").append(severity).append("\n");
			sb.append("\t").append("Time:").append(time).append(")\n");
			return sb.toString();
		}
		private LogElement getOuterType() {
			return LogElement.this;
		}
	}
	private LogKey key;
	private long severity;
	private String description;
	public LogElement(long severity, String description) {
		super();
		this.severity = severity;
		this.description = description;
		
		key = new LogKey (severity);
	}
	public long getSeverity() {
		return severity;
	}
	public void setSeverity(long severity) {
		this.severity = severity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LogKey getKey() {
		return key;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("LogElement (\n");
		sb.append("\t").append(getKey().toString()).append("\n");
		sb.append("\t").append("Severity:").append(severity).append("\n");
		sb.append("\t").append("Description:").append(description).append("\n");
		return sb.toString();
	}
	@Override
	public int compareTo(Object o) {

		LogElement le = (LogElement)o;
		LogKey lk = le.getKey();
		if ( lk.severity == this.severity)
			return lk.time.compareTo(this.getKey().time);
		
		return (int)( this.severity - lk.severity );
	}
	
	
	
}
