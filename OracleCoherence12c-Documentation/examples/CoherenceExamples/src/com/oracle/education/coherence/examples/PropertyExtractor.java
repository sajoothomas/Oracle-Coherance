package com.oracle.education.coherence.examples;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;

import com.tangosol.util.ValueExtractor;

public class PropertyExtractor implements ValueExtractor, Serializable {

	private final String propertyName;
	private transient volatile Method readMethod;
	
	
	public PropertyExtractor(String propertyName) {
		super();
		this.propertyName = propertyName;
	}
	
	@Override
	public Object extract(Object object) {

		if (object == null ) return null;
		
		Class targetClass = object.getClass();
		
		try {
			if ( readMethod == null ||
				 readMethod.getDeclaringClass() != targetClass ) {
					 PropertyDescriptor pd = new PropertyDescriptor(propertyName,object.getClass());
					 readMethod = pd.getReadMethod();
				 }
			
			return (readMethod == null? null: readMethod.invoke(object));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}




	
}
