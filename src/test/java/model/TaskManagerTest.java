package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagerTest {
    private TaskManager manager;

    @BeforeEach
    public void setup() {
        manager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("T001", "write Junit", "practise junit test", Status.NEW);
        Task addedTask = manager.addTask(newTask);
        assertEquals(newTask, addedTask);
        assertEquals("write Junit", manager.getTask("T001").getTitle());
    }

    @Test
    public void testDeleteTask() {
        manager.addTask(new Task("T002", "delete task", "delete task validation", Status.DONE));
        assertTrue(manager.deleteTask("T002"));
        assertNull(manager.getTask("T002"));
    }

    @Test
    public void testEditTask() {
        Task task = new Task("T003", "New title", "new description updated with edit task", Status.NEW);
        manager.addTask(task);
        assertTrue(manager.editTask(task.getId(), "Updated title", "description updated with edit task"));
        assertEquals(task.getTitle(), "Updated title");
        assertEquals(task.getDescription(), "description updated with edit task");
    }

    @Test
    public void testChangeStatus() {
        Task task = new Task("T004", "New task for status change", "Set initial task status as New", Status.NEW);
        manager.addTask(task);
        assertTrue(manager.changeTaskStatus(task.getId(), Status.IN_PROGRESS), "Task status change is failing.");
        assertEquals(task.getStatus(), Status.IN_PROGRESS);
    }

    @Test
    public void testDeleteNonExistentTask() {
        assertFalse(manager.deleteTask("T001"));
    }

    @Test
    public void testEditNonExistentTask() {
        assertFalse(manager.editTask("T001", "No Task", "This task not present."));
    }

    @Test
    public void testChangeStatusNonExistentTask() {
        assertFalse(manager.changeTaskStatus("T002", Status.DONE));
    }
}
