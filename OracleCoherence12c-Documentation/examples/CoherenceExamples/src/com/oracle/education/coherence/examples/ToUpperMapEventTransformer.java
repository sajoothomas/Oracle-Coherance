package com.oracle.education.coherence.examples;

import java.io.Serializable;

import com.oracle.education.coherence.examples.domain.AirPortJS;
import com.tangosol.util.MapEvent;
import com.tangosol.util.MapEventTransformer;

public class ToUpperMapEventTransformer implements MapEventTransformer, Serializable {

	@Override
	public MapEvent transform(MapEvent event) {

		MapEvent result = event;
		System.out.println("ToUpperMapEventTransformer: '" + event + "'\n");
		Object o = event.getNewValue();
		if (o != null && (o instanceof AirPortJS )) {
			AirPortJS ap = (AirPortJS)o;

			String upper = ap.getName().toUpperCase();
			ap.setName(upper);
			System.out.println("Replacing entry with:" + ap);
		
			result = new MapEvent(event.getMap(), event.getId(),
					event.getKey(),event.getOldValue(), ap);
		}		
		System.out.println("Returning : + '"+result +"'\n");
		return result;
	}

}
