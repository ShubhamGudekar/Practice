package com.utils;

import java.util.HashMap;

import com.core.Task;
import com.core.TaskStatus;

public class TaskUtils {

	public static Task findTaskById(HashMap<Integer, Task> tMData, int taskId) {
		if (tMData.containsKey(taskId))
			return tMData.get(taskId);
		return null;
	}
	
	public static TaskStatus validStatus(String taskStatus) {
		return TaskStatus.valueOf(taskStatus.toUpperCase());
	}

}
