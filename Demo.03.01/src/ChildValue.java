
import java.io.Serializable;

/**
 * Example child data object using Java serialization
 * 
 */
@SuppressWarnings("serial")
public class ChildValue implements Serializable {
	public ChildValue() { }

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
}
