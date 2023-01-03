package com.utils;

import static com.utils.TaskUtils.validStatus;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.core.Task;

public class IoUtils {

	public static HashMap<Integer, Task> populateMap() {
		HashMap<Integer, Task> data = new HashMap<Integer, Task>();
		Task temp = new Task("abc", "abc");
		temp.setTaskDate(LocalDate.parse("2022-10-12"));
		temp.setTaskId(50);
		data.put(temp.getTaskId(), temp);
		temp = new Task("qwe", "qwe");
		temp.setTaskDate(LocalDate.parse("2022-10-18"));
		temp.setTaskId(59);
		data.put(temp.getTaskId(), temp);
		temp = new Task("mki", "mki");
		temp.setTaskDate(LocalDate.parse("2022-09-18"));
		temp.setTaskId(91);
		data.put(temp.getTaskId(), temp);
		temp = new Task("poiu", "poiu");
		temp.setTaskDate(LocalDate.parse("2022-11-12"));
		temp.setTaskId(67);
		data.put(temp.getTaskId(), temp);
		temp = new Task("shub", "shub");
		temp.setTaskDate(LocalDate.parse("2022-11-18"));
		temp.setTaskId(95);
		data.put(temp.getTaskId(), temp);
		return data;
	}

	public static void writeData(HashMap<Integer, Task> taskData) throws IOException {
		File f = new File("TaskManagerData");
		try (PrintWriter p = new PrintWriter(new FileWriter(f));) {
			taskData.values().stream().forEach(t -> p.println(t.writeToFile()));

		}
	}

	public static HashMap<Integer, Task> readData() throws IOException {
		File f = new File("TaskManagerData");
		HashMap<Integer, Task> data = new HashMap<Integer, Task>();
		if (f.canRead() && f.exists()) {
			
			try (Scanner sc = new Scanner(new FileReader(f))) {
				while (sc.hasNextLine()) {
					String temp = sc.nextLine();
					String[] abc = temp.split(",");
					data.put(Integer.valueOf(abc[0]), new Task(Integer.valueOf(abc[0]), abc[1], abc[2],
							LocalDate.parse(abc[3]), validStatus(abc[4]), Boolean.valueOf(abc[5])));
				}
			}
		}
		return data;
	}
}
