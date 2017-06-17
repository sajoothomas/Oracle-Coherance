package com.oracle.education.coherence.examples;

import java.util.*;

import com.oracle.education.coherence.examples.domain.AirPort;
public class AirportComparator implements Comparator {

	@Override
	public int compare(Object first, Object second) {
		
		if (!( first instanceof AirPort) ||
			!( second instanceof AirPort)){
			throw new IllegalArgumentException("object not an Airport");
		}
		
		AirPort firstAP = (AirPort) first;
		AirPort secondAP = (AirPort) second;
		
		if (firstAP.getCountry().equals(secondAP.getCountry())) {
			return firstAP.getCity().compareTo(secondAP.getCity());
		} else {
			return firstAP.getCountry().compareTo(secondAP.getCountry());
		}
	}
}
