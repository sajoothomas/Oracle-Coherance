package com.oracle.education.coherence.examples;

import java.io.Serializable;

/**
 * Airport Coherence Example
 * @author Oracle Education
 *
 */
public class AirPortEntity implements Entity<Long>, Serializable, Comparable {
	
	private static final long serialVersionUID = 7966518463749957720L;
	private long id;
	private String code;
	private String city;
	private String name;
	private String country;
	public AirPortEntity(int id, String code, String city, String name, String country) {
		this.id = id;
		this.code = code;
		this.city = city;
		this.name = name;
		this.country = country;
	}
	public AirPortEntity() { }

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() 		 {	return code;	}
	public void setCode(String code) {	this.code = code;	}
	public String getCity() {			return city; }
	public void setCity(String city) {	this.city = city; }
	public String getName() {       	return name; }
	public void setName(String name) { 	this.name = name; }
	public String getCountry() {		return country; }
	public void setCountry(String country) {	this.country = country; }
	
	@Override
	public int compareTo(Object o) {
		AirPortEntity ap = (AirPortEntity)o;
		return name.compareTo(ap.getName());
	}
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Airport: \n");
		sb.append("\t").append("ID:").append(id).append("\n");
		sb.append("\t").append("Code:").append(code).append("\n");
		sb.append("\t").append("name:").append(name).append("\n");
		sb.append("\t").append("country:").append(country).append("\n");
		return sb.toString();
	}
}
