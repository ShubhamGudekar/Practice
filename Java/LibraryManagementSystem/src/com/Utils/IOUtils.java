package com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import static com.Utils.LibraryUtils.populateMap;
import com.main.Book;

public class IOUtils {

	public static void storeLibDetails(String fileName, Map<String, Book> libData) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(libData);
			System.out.println("Data Saved Successfully");
		}
	}

	public static Map<String, Book> readLibDetails(String fileName) throws IOException, ClassNotFoundException {

		File f = new File(fileName);
		if (f.isFile() && f.canRead()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
				@SuppressWarnings("unchecked")
				Map<String, Book> readData = (Map<String, Book>) in.readObject();
				System.out.println("Data Read Successfull");
				return readData;
			}
		}
		else
			System.out.println("File Not Found");
		return populateMap();

	}

}
