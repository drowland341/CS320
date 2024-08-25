package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Task;
import main.TaskService;

class TaskServiceTest {

	private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1234567890"));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("1234567890");
        assertNull(taskService.getTask("1234567890"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.updateTask("1234567890", "Updated Name", "Updated Description");
        Task updatedTask = taskService.getTask("1234567890");
        assertAll("updatedTask",
                () -> assertEquals("Updated Name", updatedTask.getName()),
                () -> assertEquals("Updated Description", updatedTask.getDescription()));
    }
}
