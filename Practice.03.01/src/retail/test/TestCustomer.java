package retail.test;

import retail.Address;
import retail.Customer;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class TestCustomer {

	
	public static void main(String[] args) {

        //CacheFactory.ensureCluster();

        NamedCache cache=
            CacheFactory.getCache("retail.customers");
      
        cache.clear();
      

        Address address = new Address("8 Van de Graaf Drive", "Burlington", "MA","01803");
        
        Customer customer = new Customer(1l,"Bill Iards",address);
        cache.put(customer.getId(),customer);
        
        
        Customer customerOut = (Customer)cache.get(customer.getId());
        
        System.out.println("Returned: " + customerOut);
	}	
}
