
import com.tangosol.io.pof.PortableObjectSerializer;
import com.tangosol.io.pof.SimplePofContext;
import com.tangosol.util.Base;
import com.tangosol.util.Binary;
import com.tangosol.util.ExternalizableHelper;

/**
 * Test to calculate the size of various data objects
 * 
 */
public class SerializationTest extends Base {
	
	public static void main(String[] args) {
		int c = 100000;
		try {
			c = Integer.parseInt(args[0]);
		} catch (Exception e) {
		}

		Value value = new Value();
		ELValue valueEL = new ELValue();
		XmlBeanValue valueXml = new XmlBeanValue();
		PofValue valuePof = new PofValue();
		
        SimplePofContext ctx = new SimplePofContext();
        ctx.registerUserType(1000, PofValue.class ,new PortableObjectSerializer(1000));
        ctx.registerUserType(1001, ChildPofValue.class ,new PortableObjectSerializer(1001));

		// show the details of what is produced
		show("Java Serialization -------------> ", testSerTime(value, c));
		show("Coherence ExternalizableLite ----> ", testSerTime(valueEL, c));
		show("Coherence XmlBean Serialization -> ", testSerTime(valueXml, c));
		show("Coherence POF Serialization -> ", testSerTime(ctx,valuePof, c));

		out();

		start("Serialized a Value " + c + " times --------> ");
		testSerTime(value, c);
		stop();

		start("Serialized a ELValue " + c + " times ------> ");
		testSerTime(valueEL, c);
		stop();

		start("Serialized a XmlBeanValue " + c + " times -> ");
		testSerTime(valueXml, c);
		stop();

		
		start("Serialized a Pof Value " + c + " times --------> ");
		testSerTime(ctx,valuePof, c);

		stop();
		
		out();
		out("Done.");
	}
	public static Binary testSerTime(Object value, int c) {
		return testSerTime(null,value, c);

	}

	public static Binary testSerTime(SimplePofContext ctx,Object value, int c) {
		Binary binValue = null;
		for (int i = 0; i < c; ++i) {
			if ( ctx != null)
				binValue = ExternalizableHelper.toBinary(value,ctx);
			else 
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
		s_sTest = sTest;
		s_ldtStart = System.currentTimeMillis();
	}

	static void stop() {
		long cMillis = System.currentTimeMillis() - s_ldtStart;
		out(s_sTest + cMillis + "ms");
	}

	static long s_ldtStart;

	static String s_sTest;
}
