package br.fpu.tcc.hotelaria.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import biz.source_code.base64Coder.Base64Coder;

public class ObjectUtils {

	public static String serializeToString(Serializable obj) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.close();
		return new String(Base64Coder.encode(baos.toByteArray()));
	}

	public static Object deserializeFromString(String str) throws IOException,
			ClassNotFoundException {

		byte[] data = Base64Coder.decode(str);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
				data));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}
