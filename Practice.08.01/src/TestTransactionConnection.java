public class TestTransactionConnection {

	public static void main(String[] args) {

		// Get a connection
		// TODO: Place code for connection 1 here
		System.out.println("\nOPENING CONNECTION #1");

		// Get a transactional cache
		System.out.println("Getting tx-cache");
		// TODO: Place code to get transactional cache via connection 1 here

		// INSERT AN ENTRY INTO THE CACHE
		System.out.println("\nINSERTING key AND key2 INTO CACHE (BEGIN TRANSACTION)");
		// TODO: Place code that inserts two entries here

		// Update the value of the entry
		System.out.println("UPDATING key value TO value2");
		// TODO: Update key to value2 on connection 1 here
		System.out.println("Committing transaction (END TRANSACTION)");
		// TODO: Commit connection #1 here
		conn.commit();

		// Second connection
		System.out.println("\nOPENING CONNECTION #2");
		// TODO: Place code for connection 2 here
		// Get the same transactional cache from the second connection
		System.out.println("Getting same tx-cache that connection #1 is using");
		// TODO: Place code to get transactional cache via connection 2 here
		System.out.println("\nVERIFYING THAT CONNNECTION #2 CAN SEE THE SAME DATA INSERTED BY CONNECTION #1");

		// Update the value through the first cache
		System.out.println("UPDATING key value2 TO value3 USING CONNECTION #1 (BEGIN TRANSACTION)");
		cache.update("key", "value3", null);
		System.out.println("Value for key that connection #2 sees=" + cache2.get("key"));
		System.out.println("Committing the update on connection #1 (END TRANSACTION)");
		conn.commit();
		System.out.println("Value for key that connection #2 sees after commit on connection #1="
				+ cache2.get("key"));

		// Update the value through the first connection
		System.out.println("\nTESTING ROLLBACK SCENARIO");
		System.out.println("UPDATING key value3 TO value4 USING CONNECTION #1 (BEGIN TRANSACTION)");
		cache.update("key", "value4", null);
		System.out.println("Value for key that connection #2 sees=" + cache2.get("key"));
		System.out.println("Rolling back the update on connection #1 (END TRANSACTION)");
		// TODO: Rollback connection #1 here
		System.out.println("Value for key that connection #2 sees after rollback on connection #1="
				+ cache2.get("key"));

		// close the connections
		// TODO: Close both connections here
	}
}
