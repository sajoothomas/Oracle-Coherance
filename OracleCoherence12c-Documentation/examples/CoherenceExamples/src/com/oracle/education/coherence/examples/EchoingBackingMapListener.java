package com.oracle.education.coherence.examples;

import com.tangosol.net.BackingMapManagerContext;
import com.tangosol.net.BackingMapManager;
import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

public class EchoingBackingMapListener implements MapListener {

	private BackingMapManagerContext context;
	
	public EchoingBackingMapListener (BackingMapManagerContext context) {
		this.context = context;
	}
	
	protected Object getConvertedKey (MapEvent event) {
		return context.getKeyFromInternalConverter().convert(event.getKey());}
	protected Object getConvertedValue (Object internal) {    
		return context.getValueFromInternalConverter().convert(internal);
		}
	protected Object getOldValue(MapEvent event) {
		return  getConvertedValue (event.getOldValue());
		}
	
	protected Object geNewValue(MapEvent event) {
		return  getConvertedValue (event.getOldValue());    }
	
	
	
	private String printId(int id) {
		switch(id) {
		case MapEvent.ENTRY_DELETED: return "ENTRY_DELETED";
		case MapEvent.ENTRY_INSERTED: return "ENTRY_INSERTED";
		case MapEvent.ENTRY_UPDATED: return "ENTRY_UPDATED";
		}
		return "ENTRY_UNKNOWN";
	}
	private void printEvent( MapEvent event ) {
		
		StringBuffer sb = new StringBuffer();

		sb.append("MapEvent:")
			.append("id:").append(event.getId()).append("'"+printId(event.getId())+"'").append("\n");
		
		sb.append("Key:").append(event.getKey()).append("\n");
		sb.append("New value:").append(getConvertedValue(event.getNewValue())).append("\n");
		sb.append("Old value:").append(getConvertedValue(event.getOldValue())).append("\n");
		System.out.println(sb.toString());
	}
	public void entryDeleted(MapEvent event) {
		System.out.println("\n\n+++entryDeleted++++\n");
		printEvent(event);
	}

	public void entryInserted(MapEvent event) {
		System.out.println("\n\n+++entryInserted++++\n");
		printEvent(event);
	}

	public void entryUpdated(MapEvent event) {
		System.out.println("\n\n+++entryUpdated++++\n");
		printEvent(event);
	}
}
