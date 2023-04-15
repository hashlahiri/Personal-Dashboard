package com.personal.dashboard.utils.deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class SerializationUtilsCustom {

	public static <T> T deserialize(byte[] byteArray) {
		ObjectInputStream oip = null;
		try {
			oip = new DecompressibleInputStream(new ByteArrayInputStream(byteArray));

			@SuppressWarnings("unchecked")
			T result = (T) oip.readObject();
			return result;
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		} finally {
			if (oip != null) {
				try {
					oip.close();
				} catch (IOException e) {
					// eat it
				}
			}
		}
	}

}
