package com.imranmadbar.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerializationMainCls {

	public static void main(String args[]) {

		try {
			// Creating stream to read the object
			ObjectInputStream fileInputStrm = new ObjectInputStream(
					new FileInputStream("src\\main\\resources\\SerialStudentInfo.txt"));

			Student studentObj = (Student) fileInputStrm.readObject();
			// printing the data of the serialized object
			System.out.println(studentObj.id + " " + studentObj.name);
			// closing the stream
			fileInputStrm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
