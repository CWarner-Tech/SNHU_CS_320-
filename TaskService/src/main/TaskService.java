package main;

import java.util.HashMap;
import java.util.Map;


public class TaskService {

	//Map to store tasks with their unique ID as keys
    private Map<String, Task> tasks = new HashMap<>();

    public boolean addTask(Task task) {
        if (tasks.containsKey(task.getUniqueID())) {
        	//If tasks already exists throw exception
            throw new IllegalArgumentException("Task ID already exists");
        }
     // Add the new task to the map and return true
        tasks.put(task.getUniqueID(), task);
        return true;
    }

    public boolean deleteTask(String uniqueID) {
        if (!tasks.containsKey(uniqueID)) {
        	// If no task with the given uniqueID exists, throw an exception
            throw new IllegalArgumentException("Task ID not found");
        }
        // Remove the task from the map and return true
        tasks.remove(uniqueID);
        return true;
    }

    public boolean updateTaskName(String uniqueID, String name) {
        Task task = tasks.get(uniqueID);
        if (task == null) {
        	// If no task with the given uniqueID exists, throw an exception
            throw new IllegalArgumentException("Task ID not found");
        }
        // Update the task's name and return true
        task.setName(name);
        return true;
    }
    
    public boolean updateTaskDescription(String uniqueID, String description) {
        Task task = tasks.get(uniqueID);
        if (task == null) {
        	// If no task with the given uniqueID exists, throw an exception
            throw new IllegalArgumentException("Task ID not found");
        }
        // Update the task's description and return true
        task.setDescription(description);
        return true;
    }

    public Task getTask(String uniqueID) {
    	// Return the task with the given uniqueID, or null if it does not exist
        return tasks.get(uniqueID);
    }
}