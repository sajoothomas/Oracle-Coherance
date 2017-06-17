package com.oracle.education.coherence.examples.test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import com.oracle.education.coherence.examples.SimpleMapListener;
import com.oracle.education.coherence.examples.ToUpperMapEventTransformer;
import com.oracle.education.coherence.examples.domain.AirPort;
import com.oracle.education.coherence.examples.domain.AirPortJS;
import com.oracle.education.coherence.loader.CoherenceTarget;
import com.oracle.education.coherence.loader.CsvSource;
import com.oracle.education.coherence.loader.Loader;
import com.oracle.education.coherence.loader.Source;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.filter.MapEventTransformerFilter;

public class TestMapEventTransform {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException {
        

        CacheFactory.ensureCluster();

        NamedCache cache=
                     CacheFactory.getCache("airports");
        Filter filter = new MapEventTransformerFilter( null, new ToUpperMapEventTransformer());
        cache.addMapListener(new SimpleMapListener(), filter,false);

        cache.clear();
        
        Source source = new CsvSource("airports.csv");
        CoherenceTarget target =
                new CoherenceTarget("airports", AirPortJS.class, "id");
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
