package com.oracle.education.coherence.examples;


import com.oracle.education.coherence.examples.domain.AirPortJS;
import com.tangosol.util.MapTrigger;

public class ToUpperMapTrigger implements MapTrigger {

	private static final long serialVersionUID = 1L;

	@Override
	public void process(Entry entry) {
		System.out.println("\n\nProcess('" + entry.getValue() + "')");
		
		Object o = entry.getValue();
		System.out.println("class" + o.getClass().getName());
		if (o != null && (o instanceof AirPortJS )) {
			AirPortJS ap = (AirPortJS)o;

			String upper = ap.getName().toUpperCase();
			ap.setName(upper);
			System.out.println("Replacing entry with:" + ap);
			entry.setValue(ap);
		}
	}

	public boolean equals(Object o) {
		return o != null && o.getClass() == this.getClass();
	}

	public int hashCode() {
		return getClass().getName().hashCode();
	}

}
