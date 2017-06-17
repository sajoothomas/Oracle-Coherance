import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CachedObjectSemantics {

	public static void main(String[] args) {
		CacheFactory.ensureCluster();

		// Loop through the following cache names and note the differences:
		String[] cacheNames = { "local-myCache", "repl-myCache", "dist-myCache", "near-myCache" };

		for (String cacheName : cacheNames) {
			System.out.println("\nTesting " + cacheName + " Semantics...");
			NamedCache myCache = CacheFactory.getCache(cacheName);

			CachedObject a = new CachedObject();
			System.out.println("a" + a);

			myCache.put("a", a);

			CachedObject b = (CachedObject)myCache.get("a");
			System.out.println("b" + b);

			CachedObject c = (CachedObject)myCache.get("a");
			System.out.println("c" + c);

			CachedObject d = (CachedObject)myCache.get("a");
			System.out.println("d" + d);
		}

		CacheFactory.shutdown();
	}
}
