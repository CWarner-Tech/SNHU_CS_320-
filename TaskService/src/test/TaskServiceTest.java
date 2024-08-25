package test;

import main.TaskService;
import main.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("001", "Task 1", "Description 1");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("001"));
    }

    @Test
    public void testAddTaskDuplicate() {
        Task task1 = new Task("001", "Task 1", "Description 1");
        Task task2 = new Task("001", "Task 2", "Description 2");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("002", "Task 2", "Description 2");
        taskService.addTask(task);
        taskService.deleteTask("002");
        assertNull(taskService.getTask("002"));
    }

    @Test
    public void testDeleteTaskNonExistenceId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("999");
        });
    }

    @Test
    public void testUpdateTaskName() {
        Task task = new Task("003", "Task 3", "Description 3");
        taskService.addTask(task);
        taskService.updateTaskName("003", "Updated Task 3");
        assertEquals("Updated Task 3", taskService.getTask("003").getName());
    }

    @Test
    public void testUpdateTaskNameNonExistentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("999", "New Name");
        });
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("004", "Task 4", "Description 4");
        taskService.addTask(task);
        taskService.updateTaskDescription("004", "Updated Description 4");
        assertEquals("Updated Description 4", taskService.getTask("004").getDescription());
    }

    @Test
    public void testUpdateTaskDescriptionNonExistentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("999", "New Description");
        });
    }
}
