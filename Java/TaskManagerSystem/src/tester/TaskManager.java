package tester;

import static com.utils.TaskUtils.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.core.Task;
import com.core.TaskStatus;
import static com.utils.IoUtils.*;

public class TaskManager {

	public static void main(String[] args) throws IOException {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome to TaskManager");
			boolean exitFlag = false;
			HashMap<Integer, Task> taskManagerData = readData();
			String taskName = null;
			String taskDesc = null;
			Task tempTask = null;

			while (!exitFlag) {
				try {
					System.out.println("Enter\n1.Add new Task\n2.Delete a Task");
					System.out.println("3.Update Task Status");
					System.out.println("4.Display Pending Task");
					System.out.println("5.Display all Task for Today");
					System.out.println("6.Display all task sorted by date");
					System.out.print("Your Choice : ");
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.print("Enter Task Name : ");
						taskName = sc.nextLine();
						System.out.print("Enter Task Description : ");
						taskDesc = sc.nextLine();
						tempTask = new Task(taskName, taskDesc);
						taskManagerData.putIfAbsent(tempTask.getTaskId(), tempTask);
						System.out.println("Task Added Successfully");
						break;

					case 2:
						System.out.print("Enter Taskid : ");
						tempTask = findTaskById(taskManagerData, sc.nextInt());
						if (tempTask != null) {
							// tempTask=taskManagerData.remove(taskId);
							tempTask.setActive(false);
							System.out.println("Task Deleted Successfully");
							System.out.println(tempTask);
						} else
							System.out.println("Invalid Task Id \nTask Not Found");
						break;

					case 3:
						System.out.print("Enter Taskid : ");
						tempTask = findTaskById(taskManagerData, sc.nextInt());
						if (tempTask != null) {
							System.out.println("Current Status : " + tempTask.getStatus());
							System.out.print("Enter new Status : ");
							tempTask.setStatus(validStatus(sc.next()));
							System.out.println(tempTask);
						} else
							System.out.println("Invalid Task Id \nTask Not Found");
						break;

					case 4:
						System.out.println("Pending Task ");
						taskManagerData.values().stream().filter(task -> task.getStatus() == TaskStatus.PENDING)
								.forEach(System.out::println);
						break;

					case 5:
						System.out.println("Todays Pending Task");
						taskManagerData.values().stream().filter(task -> task.getTaskDate().isEqual(LocalDate.now()))
								.forEach(System.out::println);
						break;

					case 6:
						taskManagerData.values().stream()
								.sorted((t1, t2) -> t1.getTaskDate().compareTo(t2.getTaskDate()))
								.forEach(System.out::println);
						break;

					case 0:
						System.out.println("Tata Bye Bye");
						exitFlag = true;

						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					writeData(taskManagerData);
				}
			}
		}
	}
}
