package com.tangosol.examples.coherence.serialization;


import com.tangosol.util.Base;
import com.tangosol.util.Binary;
import com.tangosol.util.ExternalizableHelper;


/**
* Test to calculate the size of various data objects
*
* @author rmisek 2005.08.18
*/
public class SerializationTest
        extends Base
    {
    public static void main(String[] asArgs)
        {
        int c = 100000;
        try
            {
            c = Integer.parseInt(asArgs[0]);
            }
        catch (Exception e) {}

        Value        value    = new Value();
        ELValue      valueEL  = new ELValue();
        XmlBeanValue valueXml = new XmlBeanValue();

        // show the details of what is produced
        show("Java Serialization -------------> ", testSerTime(value, 1000));
        show("Tangosol ExternalizableLite ----> ", testSerTime(valueEL, 1000));
        show("Tangosol XmlBean Serialization -> ", testSerTime(valueXml, 1000));

        out();

        start("Serialized an Value " + c + " times --------> ");
        testSerTime(value, c);
        stop();

        start("Serialized an ELValue " + c + " times ------> ");
        testSerTime(valueEL, c);
        stop();

        start("Serialized an XmlBeanValue " + c + " times -> ");
        testSerTime(valueXml, c);
        stop();

        out();
        out("Done.");
        }


    public static Binary testSerTime(Object value, int c)
        {
        Binary binValue = null;
        for (int i = 0; i < c; ++i)
            {
            binValue = ExternalizableHelper.toBinary(value);
            }
        return binValue;
        }

    static void show(String sDesc, Binary binValue)
        {
        out(sDesc + binValue.length() + " bytes");
        out(toHexDump(binValue.toByteArray(), 16));
        out();
        }

    static void start(String sTest)
        {
        s_sTest = sTest;
        s_ldtStart = System.currentTimeMillis();
        }

    static void stop()
        {
        long cMillis = System.currentTimeMillis() - s_ldtStart;
        out(s_sTest + cMillis + "ms");
        }

    static long s_ldtStart;

    static String s_sTest;
    }
