import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.oracle.education.loader.Loader;
import com.oracle.education.retail.Order;
import com.oracle.education.retail.repository.CoherenceOrderRepository;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CacheTester {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Load cache using Loader
		try {
			Loader.load();
		} catch (Exception e) {
			System.out.println("Loading cache failed. Check output for errors.");
			System.out.println("Most likely there is an issue with localstorage disabled or no cacheserver running.");
			e.printStackTrace();
			return;
		}
		System.out.println("\nCache is loaded\n");

		NamedCache orders = CacheFactory.getCache(CoherenceOrderRepository.CACHENAME);

		// TODO: Place CohQL query code here

		System.out.println("\nOrders over $999.99 before EntryProcessor");
		Set<Long> keys = new HashSet<Long>();
		for (Map.Entry entry : (Set<Map.Entry>)orders.entrySet(filter)) {
			keys.add((Long)entry.getKey());
			System.out.println("Order: " + entry.getKey() + " orderTotal="
					+ ((Order)entry.getValue()).getOrderTotal());
		}

		System.out.println("\nInvoking EntryProcessor");
		// TODO: Place code to invoke EntryProcessor here
		System.out.println("\nEntryProcessor invoked");

		System.out.println("\nThe same orders after EntryProcessor");
		for (Long orderId : keys) {
			System.out.println("Order: " + orderId + " orderTotal="
					+ ((Order)orders.get(orderId)).getOrderTotal());
		}

		CacheFactory.shutdown();
	}
}
