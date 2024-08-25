package main;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskID(), task);
    }

    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        tasks.remove(taskID);
    }

    public void updateTask(String taskID, String name, String description) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        if (name != null && name.length() <= 20) {
            task.setName(name);
        }
        if (description != null && description.length() <= 50) {
            task.setDescription(description);
        }
    }

    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
