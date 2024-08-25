package main;

public class Task {
    private final String taskID;
    private String name;
    private String description;

    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID"); // Throws exception if TaskID is more than 10 characters
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name"); // Throws exception when name is longer than 20 characters
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");// Throws exception when description is more than 50 characters
        }
        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name"); // Throws exception when name entered is more than 20 characters
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description"); // Throws exception when description is more than 50
        }
        this.description = description;
    }
}
