package retail.cachestore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.tangosol.net.cache.CacheStore;
import com.tangosol.net.cache.CacheLoader;


//
// TODO: Once completed, this class needs to be registered as a CacheStore with appropriate initializer arguments
//
//
// TODO: Change the implements to CacheStore and implement the required missing methods
//       erase, eraseAll, store and storeAll
//
@SuppressWarnings("unchecked")
public class CustomerCachestore extends CustomerJdbcSupport implements CacheLoader {

	
	//
	// TODO: create a constructor which takes three arguments
	// the connection info, uName and password
	// and uses them rather then hard coded values
	//  Perhaps the simplest way is via the eclipse right click > source > generate from super class
		
	private static String connectionInfo = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String uName = "COHERENCE";
	private static String pwd = "COHERENCE";
	
	
	public CustomerCachestore() {
		super(connectionInfo, uName, pwd);
	}

	//
	// TODO: Implement erase, eraseAll, store and storeAll
	//
	
	
	@Override
	public Object load(Object oKey) {
		System.out.println("\n\n\n+++++++++++++++++++");
		System.out.println("CustomerCachestore.load('"+oKey+"') called ");
		System.out.println("+++++++++++++++++++\n\n\n");

		Object result = readById(oKey);
		System.out.println("\n\n\n+++++++++++++++++++");
		System.out.println("CustomerCachestore.load('"+oKey+"') returning '"+result+"'");
		System.out.println("+++++++++++++++++++\n\n\n");
		return result;
	}

	@Override
	public Map loadAll(Collection colKeys) {
		Map results = new HashMap();
		
		for (Object key: colKeys ) {
			Object value = readById(key);
			
			if ( value != null)
				results.put(key,value);
		}
		return (results.isEmpty()? null: results);
	}


}
