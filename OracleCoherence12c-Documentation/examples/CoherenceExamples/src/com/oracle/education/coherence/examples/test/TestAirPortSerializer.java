package com.oracle.education.coherence.examples.test;

import com.oracle.education.coherence.examples.AirPortSerializer;
import com.oracle.education.coherence.examples.domain.AirPort;
import com.tangosol.io.pof.SimplePofContext;
import com.tangosol.util.Base;
import com.tangosol.util.Binary;
import com.tangosol.util.ExternalizableHelper;

public class TestAirPortSerializer extends Base {

	public static void main(String[] args) {

        
        SimplePofContext ctx = new SimplePofContext();
        ctx.registerUserType(1000, AirPort.class ,new AirPortSerializer());
        

        AirPort original = new AirPort(1, "LGN", "Boston","Boston Logan Airport" ,"USA");
        Binary binary = ExternalizableHelper.toBinary(original, ctx);
        
        AirPort copy = (AirPort)ExternalizableHelper.fromBinary(binary);
        
        System.out.println("Reurned " + copy);
	}

}
