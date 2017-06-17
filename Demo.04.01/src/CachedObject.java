import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.tangosol.util.ExternalizableHelper;

public class CachedObject implements com.tangosol.io.ExternalizableLite {

	private static final long serialVersionUID = 5900542657861773252L;

	private String originalToString;
	

	public CachedObject() {
		this.originalToString = super.toString();
	}
	
	
	public void readExternal(DataInput in) throws IOException {
		originalToString = ExternalizableHelper.readSafeUTF(in);
	}
	
	
	public void writeExternal(DataOutput out) throws IOException {
		ExternalizableHelper.writeSafeUTF(out, originalToString);
	}
	
	
	public String toString() {
		String superToString = super.toString();
		return originalToString.equals(superToString) ? " is a reference to the original object (" + superToString + ")" : 
														" is a reference to a copy (" + superToString + ") of the original object";
	}
}
