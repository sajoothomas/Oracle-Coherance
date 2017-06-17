package com.oracle.education.coherence.examples;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import com.oracle.education.coherence.loader.CoherenceTarget;
import com.oracle.education.coherence.loader.CsvSource;
import com.oracle.education.coherence.loader.Loader;
import com.oracle.education.coherence.loader.Source;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class TestAirportEntity {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException {
        

        CacheFactory.ensureCluster();

        NamedCache cache=
                     CacheFactory.getCache("airports");

        cache.clear();
        
        Source source = new CsvSource("airports.csv");
        CoherenceTarget target =
                new CoherenceTarget("airports", AirPortEntity.class, "id");
        target.setBatchSize(50);
        Loader loader = new Loader(source, target);
        loader.load();
        
        
        Set<Map.Entry> entries = cache.entrySet(null,null);
        for (Map.Entry entry: entries) {
        	System.out.println("Returned '"+entry.getKey()+"' for '"+entry.getValue()+"'");
        }
       	CacheFactory.shutdown();

	}

}
