
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import java.io.IOException;
import java.sql.Date;

/**
 * Example data object using Coherence ExternalizableLite Serialization
 * 
 */
public class PofValue implements PortableObject {
	public PofValue() {	}

	public String getId() {
		return m_sId;
	}

	public void setId(String sString) {
		m_sId = sString;
	}

	public java.util.Date getDate() {
		return m_Date;
	}

	public void setDate(Date date) {
		m_Date = date;
	}

	public Long getLong() {
		return m_Long;
	}

	public void setLong(Long aLong) {
		m_Long = aLong;
	}

	public Integer getInteger() {
		return m_Integer;
	}

	public void setInteger(Integer integer) {
		m_Integer = integer;
	}

	public Float getFloat() {
		return m_Float;
	}

	public void setFloat(Float aFloat) {
		m_Float = aFloat;
	}

	public Double getDouble() {
		return m_Double;
	}

	public void setDouble(Double aDouble) {
		m_Double = aDouble;
	}

	public ChildPofValue getChild() {
		return m_child;
	}

	public void setChild(ChildPofValue child) {
		m_child = child;
	}


	public String m_sId = new String(new char[20]);
	public java.util.Date m_Date = new Date(System.currentTimeMillis());
	public Long m_Long = new Long("0");
	public Integer m_Integer = new Integer("0");
	public Float m_Float = new Float("0");
	public Double m_Double = new Double("0");
	public ChildPofValue m_child = new ChildPofValue();
	
	@Override
	public void readExternal(PofReader in) throws IOException {
		m_sId = in.readString(0);
		m_Date = in.readDate(1);
		m_Long = new Long(in.readLong(2));
		m_Integer = new Integer(in.readInt(3));
		m_Float = new Float(in.readFloat(4));
		m_Double = new Double(in.readDouble(5));
		m_child = (ChildPofValue) in.readObject(6);

		
	}

	@Override
	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, m_sId);
		out.writeDate(1, m_Date);
		out.writeLong(2,m_Long.longValue());
		out.writeInt(3,m_Integer.intValue());
		out.writeFloat(4,m_Float.floatValue());
		out.writeDouble(5,m_Double.doubleValue());
		out.writeObject(6, m_child);
		
	}
}
