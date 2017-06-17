package com.oracle.education.coherence.examples;

import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import com.oracle.education.coherence.examples.domain.LogElement;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class LogElementTest {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException {
        

        CacheFactory.ensureCluster();

        NamedCache cache=
                     CacheFactory.getCache("logging");

        cache.clear();

        for ( int i = 0; i < 10; i++) {
        	for ( int j = 0; j < 5; j++ ) {
        		try { Thread.sleep(10);} catch (InterruptedException e) {}
        		LogElement le = new LogElement(i,"Log element of severity i:'"+i+"' j'"+j+"'");
        	
        		cache.put(le.getKey(),le);
        	}
        }
        
        Set<Map.Entry> entries = cache.entrySet(null,null);
        for (Map.Entry entry: entries) {
        	System.out.println("Returned '"+entry.getKey()+"' for '"+entry.getValue()+"'");
        }
       	CacheFactory.shutdown();

	}

}
