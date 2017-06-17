package com.oracle.education.coherence.examples;

import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;
import com.tangosol.net.cache.CacheEvent;

public class SimpleMapListener implements MapListener {

	private String printId(int id) {
		switch(id) {
		case MapEvent.ENTRY_DELETED: return "ENTRY_DELETED";
		case MapEvent.ENTRY_INSERTED: return "ENTRY_INSERTED";
		case MapEvent.ENTRY_UPDATED: return "ENTRY_UPDATED";
		}
		return "ENTRY_UNKNOWN";
	}
	
	private boolean isSynthetic(MapEvent event) {
		boolean result = false;
		if ( event instanceof CacheEvent) {
			return ((CacheEvent) event).isSynthetic();
		}
		return false;
	}
	private void printEvent( MapEvent event ) {
		
		StringBuffer sb = new StringBuffer();

		sb.append("MapEvent:")
			.append("id:").append(event.getId()).append("'"+printId(event.getId())+"'").append("\n");
		
		sb.append("Key:").append(event.getKey()).append("\n");
		sb.append("New value:").append(event.getNewValue()).append("\n");
		sb.append("Old value:").append(event.getOldValue()).append("\n");
		System.out.println(sb.toString());
	}
	@Override
	public void entryDeleted(MapEvent event) {
		System.out.println("\n\n+++entryDeleted++++\n");
		printEvent(event);
	}

	@Override
	public void entryInserted(MapEvent event) {
		System.out.println("\n\n+++entryInserted++++\n");
		printEvent(event);
	}

	@Override
	public void entryUpdated(MapEvent event) {
		System.out.println("\n\n+++entryUpdated++++\n");
		printEvent(event);
	}
}
