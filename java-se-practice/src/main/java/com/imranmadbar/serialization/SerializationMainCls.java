package com.imranmadbar.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationMainCls {

	public static void main(String[] args) {

		System.out.println("Welcome to java Serialization");

		try {

			// Creating the object
			Student studentObj = new Student(1001, "MD IMRAN HOSSAIN");

			// Creating stream and writing the object
			FileOutputStream stdfileOutStr = new FileOutputStream("src\\main\\resources\\SerialStudentInfo.txt");
			ObjectOutputStream out = new ObjectOutputStream(stdfileOutStr);

			out.writeObject(studentObj);
			out.flush();
			// closing the stream
			out.close();
			
			System.out.println("Obj written success done");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
