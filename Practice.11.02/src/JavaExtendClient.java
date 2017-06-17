import com.oracle.education.retail.Address;
import com.oracle.education.retail.Customer;

public class JavaExtendClient {

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();

		// Switch this with one of the following and note the differences:
		// near-myCache - map to near local cache that uses extend*tcp for the back tier
		// myCache
		String cacheName = "myCache"; // map directly to extend*tcp by default
		int count = 5;

		for (int opts = 0; opts < args.length; opts++) {
			if ("-cache".equalsIgnoreCase(args[opts])) cacheName = args[opts + 1];
		}

		// Create 1 of each cache type
		// TODO: Put call to getCache() here

		// Create the objects to put into cache
		Address address = new Address("1313 Mockingbird Ln", "New York", "NY", "10001");
		Customer cust = new Customer("John Doe", address);

		// Store the object in cache
		// TODO: Put Customer object into cache here

		// Read the object from each cache type and time it
		System.out.println("==================================================");
		stopWatch.start();
		for (int i = 0; i < count; i++) {
			// TODO: Get Customer object from cache here
		}
		stopWatch.stop();
		System.out.println("Time for " + cacheName + " get():" + stopWatch.toString(count));

		// Update the object in each cache type and time it
		System.out.println("==================================================");
		stopWatch.start();
		for (int i = 0; i < count; i++) {
			// TODO: Put Customer object into cache here
		}
		stopWatch.stop();
		System.out.println("Time for " + cacheName + " put():" + stopWatch.toString(count));

		System.out.println("==================================================");

		// TODO: Put call to disconnect the Extend client here
	}
}
