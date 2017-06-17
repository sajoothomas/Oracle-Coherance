package com.oracle.education.coherence.examples.test;

import com.oracle.education.coherence.examples.domain.AirCraftEL;
import com.oracle.education.coherence.examples.domain.AirCraftJS;
import com.oracle.education.coherence.examples.domain.AirCraftPO;
import com.tangosol.io.pof.PortableObjectSerializer;
import com.tangosol.io.pof.SimplePofContext;
import com.tangosol.util.Base;
import com.tangosol.util.Binary;
import com.tangosol.util.ExternalizableHelper;

public class TestAirCraftSerialize extends Base {

	public static void main(String[] args) {

		AirCraftEL craftEL = new AirCraftEL(1l, 200l, "Airbus", "A 300");
		AirCraftJS craftJS = new AirCraftJS(1l, 200l, "Airbus", "A 300");
		AirCraftPO craftPO = new AirCraftPO(1l, 200l, "Airbus", "A 300");

		SimplePofContext ctx = new SimplePofContext();
        ctx.registerUserType(1000, AirCraftPO.class ,new PortableObjectSerializer(1000));
		
		int count = 50000;

		show("Java Serialization -> ", testSerTime(craftJS, count));
		show("ExternalizableLite Serialization -> ", testSerTime(craftEL, count));

		start("Serialized an AirCraftJS " + count + " times  ");
        testSerTime(craftJS, count);
        stop();
        
		start("Serialized an AirCraftEL " + count + " times  ");
        testSerTime(craftEL, count);
        stop();
        
     
        
	}

	public static Binary testSerTime(Object value, int c) {
		Binary binValue = null;
		for (int i = 0; i < c; ++i) {
			binValue = ExternalizableHelper.toBinary(value);
		}
		return binValue;
	}

	static void show(String sDesc, Binary binValue) {
		out(sDesc + binValue.length() + " bytes");
		out(toHexDump(binValue.toByteArray(), 16));
		out();
	}

	static void start(String sTest) {
		test = sTest;
		startTime = System.currentTimeMillis();
	}

	static void stop() {
		long cMillis = System.currentTimeMillis() - startTime;
		out(test + cMillis + "ms");
	}

	private static String test;
	private static long startTime;
}
