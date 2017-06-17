import com.oracle.education.retail.Address;
import com.oracle.education.retail.Customer;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CachePerformance {

	public static void main(String[] args) {
		int count = 1000;

		// Loop through the following cache names and note the differences:
		String[] cacheNames = { "local-myCache", "repl-myCache", "dist-myCache", "near-myCache" };

		CacheFactory.ensureCluster();

		StopWatch stopWatch = new StopWatch();

		for (String cacheName : cacheNames) {
			System.out.println("\nTesting " + cacheName + " Performance...");

			// Create 1 of each cache type
			NamedCache myCache = CacheFactory.getCache(cacheName);

			// Create the objects to put into cache
			Address address = new Address("1313 Mockingbird Ln", "New York", "NY", "10001");
			Customer cust = new Customer("John Doe", address);

			// Store the object in cache
			myCache.put(cust.getId(), cust);

			// Read the object from each cache type and time it
			System.out.println("==================================================");
			stopWatch.start();
			for (int i = 0; i < count; i++) {
				cust = (Customer)myCache.get(cust.getId());
			}
			stopWatch.stop();
			System.out.println("Time for " + cacheName + " get():" + stopWatch.toString(count));

			// Update the object in each cache type and time it
			System.out.println("==================================================");
			stopWatch.start();
			for (int i = 0; i < count; i++) {
				myCache.put(cust.getId(), cust);
			}
			stopWatch.stop();
			System.out.println("Time for " + cacheName + " put():" + stopWatch.toString(count));

			System.out.println("==================================================");
		}

		CacheFactory.shutdown();
	}
}
