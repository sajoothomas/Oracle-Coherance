
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

import java.io.IOException;

/**
 * Example child data object using Coherence ExternalizableLite Serialization
 * 
 */
public class ChildPofValue implements PortableObject {
	public ChildPofValue() {	}

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


	public String m_sId = new String(new char[20]);
	public String m_sField = new String(new char[40]);
	@Override
	public void readExternal(PofReader in) throws IOException {
		// TODO Auto-generated method stub
		m_sId = in.readString(0);
		m_sField = in.readString(1);
		
	}

	@Override
	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, m_sId);
		out.writeString(1,m_sField);
	}
}
