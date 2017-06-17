package retail.listener;


import com.oracle.education.retail.Address;
import com.oracle.education.retail.Customer;
import com.oracle.education.retail.State;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

//
// TODO: Must implement the MapListener interface
//
public class AddStateMapListener { 


	
	private String printId(int id) {
		switch(id) {
		case MapEvent.ENTRY_DELETED: return "ENTRY_DELETED";
		case MapEvent.ENTRY_INSERTED: return "ENTRY_INSERTED";
		case MapEvent.ENTRY_UPDATED: return "ENTRY_UPDATED";
		}
		return "ENTRY_UNKNOWN";
	}
	/**
	 * The printEvent method can be used to dump the content of an event to standard out
	 * @param event
	 */
	private void printEvent( MapEvent event ) {
		
		StringBuffer sb = new StringBuffer();

		sb.append("MapEvent:")
			.append("id:").append(event.getId()).append("'"+printId(event.getId())+"'").append("\n");
		
		sb.append("Key:").append(event.getKey()).append("\n");
		sb.append("New value:").append(event.getNewValue()).append("\n");
		sb.append("Old value:").append(event.getOldValue()).append("\n");
		System.out.println(sb.toString());
	}

	//
	// TODO: Implement the entryDeleted methods
	// 

	//
	// TODO: Implement the entry inserted method
	//       Note that for convenience the code snippet entry.inserted.code.snippet.txt
	//       Contains the complete contents of this method. 
	

	//
	// todo: implement the entryUpdated method
	//
}
