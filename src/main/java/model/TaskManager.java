package model;

import java.util.*;

public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    public Task addTask(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    public boolean deleteTask(String taskId) {
        return tasks.remove(taskId) != null;
    }

    public boolean editTask(String taskId, String newTitle, String newDesc) {
        Task task = tasks.get(taskId);
        if (task == null)
            return false;
        if (newTitle.trim() != "")
            task.setTitle(newTitle);
        if (newDesc.trim() != "")
            task.setDescription(newDesc);
        return true;
    }

    public boolean changeTaskStatus(String taskId, Status newStatus) {
        Task task = tasks.get(taskId);
        if (task == null)
            return false;
        task.setStatus(newStatus);
        return true;
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
