package com.oracle.education.coherence.examples.test;

import java.net.URISyntaxException;

import com.oracle.education.coherence.examples.domain.AirCraftPO;
import com.tangosol.io.pof.PortableObjectSerializer;
import com.tangosol.io.pof.SimplePofContext;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Base;
import com.tangosol.util.Binary;
import com.tangosol.util.ExternalizableHelper;

public class TestAirCrafttPO extends Base {

	public static void main(String[] args) {

    
        
        SimplePofContext ctx = new SimplePofContext();
        ctx.registerUserType(1001, AirCraftPO.class ,new PortableObjectSerializer(1001));
	

        
        AirCraftPO original = new AirCraftPO(1l, 200l, "Airbus", "A 300");
        
        Binary binary   = ExternalizableHelper.toBinary(original, ctx);
        Object copy     = ExternalizableHelper.fromBinary(binary, ctx);
        
        
        System.out.println("Returned: " + copy);
	}

}
