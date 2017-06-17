
import com.tangosol.io.ExternalizableLite;
import com.tangosol.util.ExternalizableHelper;

import java.io.DataInput;
import java.io.IOException;
import java.io.DataOutput;


/**
 * Example child data object using Coherence ExternalizableLite Serialization
 * 
 */
@SuppressWarnings("serial")
public class ChildELValue implements ExternalizableLite {
	public ChildELValue() {	}

	public String getId() {
		return m_sId;
	}

	public void setId(String sId) {
		m_sId = sId;
	}

	public String getField() {
		return m_sField;
	}

	public void setField(String sField) {
		m_sField = sField;
	}

	public void readExternal(DataInput in) throws IOException {
		m_sId = ExternalizableHelper.readSafeUTF(in);
		m_sField = ExternalizableHelper.readSafeUTF(in);
	}

	public void writeExternal(DataOutput out) throws IOException {
		ExternalizableHelper.writeSafeUTF(out, m_sId);
		ExternalizableHelper.writeSafeUTF(out, m_sField);
	}

	public String m_sId = new String(new char[20]);
	public String m_sField = new String(new char[40]);
}
