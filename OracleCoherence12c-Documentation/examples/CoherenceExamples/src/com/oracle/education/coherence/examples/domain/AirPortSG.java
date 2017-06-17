package com.oracle.education.coherence.examples.domain;

import java.io.Serializable;

import com.seovic.coherence.identity.IdentityGenerator;
import com.seovic.coherence.identity.sequence.SequenceGenerator;

/**
 * Airport Coherence Example
 * @author Oracle Education
 *
 */
public class AirPortSG implements Serializable, Comparable {
	
	private static final long serialVersionUID = 7966518463749957720L;
	private static IdentityGenerator<Long> idGen = new SequenceGenerator("airport.id",20);
	private long id;
	private String code;
	private String city;
	private String name;
	private String country;
	public static AirPortSG create(String code, String city, String name, String country){
	
		return new AirPortSG(code,city,name,country); 
	}
	private  AirPortSG(String code, String city, String name, String country) {
		this.id = idGen.generateIdentity();
		this.code = code;
		this.city = city;
		this.name = name;
		this.country = country;
	}
	public AirPortSG() { this.id = idGen.generateIdentity(); }

	
	public long getId() {
		return id;
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
		AirPortSG ap = (AirPortSG)o;
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
