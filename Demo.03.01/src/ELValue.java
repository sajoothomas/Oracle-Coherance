
import com.tangosol.io.ExternalizableLite;
import com.tangosol.util.ExternalizableHelper;

import java.io.DataInput;
import java.io.IOException;
import java.io.DataOutput;

import java.sql.Date;

/**
 * Example data object using Coherence ExternalizableLite Serialization
 * 
 */
@SuppressWarnings("serial")
public class ELValue implements ExternalizableLite {
	public ELValue() {	}

	public String getId() {
		return m_sId;
	}

	public void setId(String sString) {
		m_sId = sString;
	}

	public Date getDate() {
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

	public ChildELValue getChild() {
		return m_child;
	}

	public void setChild(ChildELValue child) {
		m_child = child;
	}

	public void readExternal(DataInput in) throws IOException {
		m_sId = ExternalizableHelper.readSafeUTF(in);
		m_Date = ExternalizableHelper.readDate(in);
		m_Long = new Long(in.readLong());
		m_Integer = new Integer(in.readInt());
		m_Float = new Float(in.readFloat());
		m_Double = new Double(in.readDouble());
		m_child = (ChildELValue) ExternalizableHelper.readObject(in);
	}

	public void writeExternal(DataOutput out) throws IOException {
		ExternalizableHelper.writeSafeUTF(out, m_sId);
		ExternalizableHelper.writeDate(out, m_Date);
		out.writeLong(m_Long.longValue());
		out.writeInt(m_Integer.intValue());
		out.writeFloat(m_Float.floatValue());
		out.writeDouble(m_Double.doubleValue());
		ExternalizableHelper.writeObject(out, m_child);
	}

	public String m_sId = new String(new char[20]);
	public Date m_Date = new Date(System.currentTimeMillis());
	public Long m_Long = new Long("0");
	public Integer m_Integer = new Integer("0");
	public Float m_Float = new Float("0");
	public Double m_Double = new Double("0");
	public ChildELValue m_child = new ChildELValue();
}
