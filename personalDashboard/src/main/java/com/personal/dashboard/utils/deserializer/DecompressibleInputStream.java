package com.personal.dashboard.utils.deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DecompressibleInputStream extends ObjectInputStream {

	private static final Logger LOG = LoggerFactory.getLogger(DecompressibleInputStream.class);

	public DecompressibleInputStream(InputStream in) throws IOException {
		super(in);
	}

	protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
		ObjectStreamClass resultClassDescriptor = super.readClassDescriptor(); // initially streams descriptor
		Class localClass; // the class in the local JVM that this descriptor represents.
		try {
			localClass = Class.forName(resultClassDescriptor.getName());
		} catch (ClassNotFoundException e) {
			LOG.error("No local class for ");
			return resultClassDescriptor;
		}
		ObjectStreamClass localClassDescriptor = ObjectStreamClass.lookup(localClass);
		if (localClassDescriptor != null) { // only if class implements serializable
			final long localSUID = localClassDescriptor.getSerialVersionUID();
			final long streamSUID = resultClassDescriptor.getSerialVersionUID();
			if (streamSUID != localSUID) { // check for serialVersionUID mismatch.
				final StringBuffer s = new StringBuffer("Overriding serialized class version mismatch: ");
				s.append("local serialVersionUID = ").append(localSUID);
				s.append(" stream serialVersionUID = ").append(streamSUID);
				Exception e = new InvalidClassException(s.toString());
				LOG.error("Potentially Fatal Deserialization Operation. Details: {}", e.getMessage());
				resultClassDescriptor = localClassDescriptor;
			}
		}
		return resultClassDescriptor;
	}
}