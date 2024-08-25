package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {

	@Test
    public void testTaskCreation() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertAll("task",
                () -> assertEquals("1234567890", task.getTaskID()),
                () -> assertEquals("Task Name", task.getName()),
                () -> assertEquals("Task Description", task.getDescription()));
    }

    @Test
    public void testTaskIDNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task Description"); // Tests for exception when Invalid NULL is entered
        });
        assertEquals("Invalid task ID", exception.getMessage());
    }

    @Test
    public void testNameNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Task Description");
        });
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    public void testDescriptionNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", null);
        });
        assertEquals("Invalid description", exception.getMessage());
    }
    
    @Test
    public void testTaskIDTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Task Description"); // 11 characters
        });
        assertEquals("Invalid task ID", exception.getMessage());
    }
    
    @Test
    public void testDescriptionTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", "This is a very long task description that exceeds fifty characters."); // more than 50 characters
        });
        assertEquals("Invalid description", exception.getMessage());
    }
}
