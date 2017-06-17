package retail.test;

import java.util.Map;
import java.util.Set;

import retail.*;
import retail.listener.AddStateMapListener;

import com.oracle.education.loader.Loader;
import com.oracle.education.retail.repository.CoherenceCustomerRepository;
import com.oracle.education.retail.repository.CoherenceStateRepository;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Binary;
import com.tangosol.util.ExternalizableHelper;
import com.tangosol.util.Base;
import com.tangosol.util.Filter;
import com.tangosol.util.MapTriggerListener;
import com.tangosol.util.filter.EqualsFilter;
import com.tangosol.util.filter.*;

public class TestMapListener {

	
	public static void main(String[] args) {

        NamedCache customerCache=
            CacheFactory.getCache(CoherenceCustomerRepository.CACHENAME);
        //Filter stateFilter = new EqualsFilter();
        
        customerCache.addMapListener(new AddStateMapListener(),new MapEventFilter(MapEventFilter.E_INSERTED,
     	       new EqualsFilter("getAddress.getState","CA")),false);

        
        
		try {
			Loader.load();
		} catch (Exception e) {
			System.out.println("Loading cache failed. Check output for errors.");
			System.out.println("Most likely there is an issue with localstorage disabled or no cacheserver running.");
			e.printStackTrace();
			return;
		}
		System.out.println("\nCache is loaded\n");
		
		
        NamedCache stateCache=
            CacheFactory.getCache(CoherenceStateRepository.CACHENAME);
      
        Set<Map.Entry> entries = stateCache.entrySet();
        for (Map.Entry entry: entries) {
        	System.out.println("Returned '"+entry.getKey()+"' for '"+entry.getValue()+"'");
        }
       	CacheFactory.shutdown();		
       
	}	
}
