package test;

import org.junit.jupiter.api.Test;

import main.Task;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

public class TaskTest {
	
	@Test 
	@DisplayName("Test Task Creation with Valid Inputs")
	//Test Task Creation
	void testTaskCreation() {
		Task task = new Task("001", "Test Task", "This is a test task.");
		assertEquals("001",task.getUniqueID());
		assertEquals("Test Task", task.getName());
		assertEquals("This is a test task.", task.getDescription());
	}
	@Test
    @DisplayName("Test Task Constructor with Null UniqueID")
    void testConstructorWithNullUniqueID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Valid Name", "Valid description.");
        });
    }

    @Test
    @DisplayName("Test Task Constructor with Null Name")
    void testConstructorWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("001", null, "Valid description.");
        });
    }

    @Test
    @DisplayName("Test Task Constructor with Null Description")
    void testConstructorWithNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("001", "Valid Name", null);
        });
    }
    
	//Test setters
	@Test
    @DisplayName("Test Set Name with Valid Input")
    void testSetNameWithValidInput() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test
    @DisplayName("Test Set Name with Empty String")
    void testSetNameWithEmptyString() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        task.setName("");
        assertEquals("", task.getName());
    }

    @Test
    @DisplayName("Test Set Name with Too Long String")
    void testSetNameWithTooLongString() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is too long for the program and is invalid.");
        });
    }

    @Test
    @DisplayName("Test Set Description with Valid Input")
    void testSetDescriptionWithValidInput() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        task.setDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }

    @Test
    @DisplayName("Test Set Description with Empty String")
    void testSetDescriptionWithEmptyString() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        task.setDescription("");
        assertEquals("", task.getDescription());
    }

    @Test
    @DisplayName("Test Set Description with Too Long String")
    void testSetDescriptionWithTooLongString() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is too long for the program because it exceeds the maximum allowed length of fifty characters.");
        });
    }
    
    @Test
    @DisplayName("Test Set Name with Null Value")
    void testSetNameWithNull() {
        Task task = new Task("001", "Initial Name", "Valid description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    @DisplayName("Test Set Description with Null Value")
    void testSetDescriptionWithNull() {
        Task task = new Task("001", "Valid Name", "Initial description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
    
    //Test getters
    @Test
    @DisplayName("Test Get UniqueID")
    void testGetUniqueID() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        assertEquals("001", task.getUniqueID());
    }

    @Test
    @DisplayName("Test Get Name")
    void testGetName() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        assertEquals("Valid Name", task.getName());
    }

    @Test
    @DisplayName("Test Get Description")
    void testGetDescription() {
        Task task = new Task("001", "Valid Name", "Valid description.");
        assertEquals("Valid description.", task.getDescription());
    }
}
    