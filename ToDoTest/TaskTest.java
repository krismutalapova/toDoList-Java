import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TaskTest {
    String name = "coffee";
    LocalDate date = App.convertDate("2020-12-12");
    String project = "SHOPPING";
    String changeName = "Whatever";
    LocalDate changeDate = App.convertDate("2023-12-12");
    String changeProject = "ERRANDS";

    @Test
    void getNameTrue() {
        Task task = new Task(name, date, project);

        assertEquals(name, task.getTaskName());
    }

    @Test
    void getNameFalse() {
        Task task = new Task(name, date, project);

        assertNotEquals("Kristina", task.getTaskName());
    }

    @Test
    void setTaskNameTrue() {
        Task task = new Task(name, date, project);
        task.setTaskName(changeName);
        assertEquals(changeName, task.getTaskName());
    }

    @Test
    void setTaskNameFalse() {
        Task task = new Task(name, date, project);
        task.setTaskName(changeName);
        assertNotEquals(name, task.getTaskName());
    }

    @Test
    void getDueDateTrue() {
        Task task = new Task(name, date, project);
        assertEquals(date, task.getDueDate());
    }

    @Test
    void getDueDateFalse() {
        Task task = new Task(name, date, project);
        assertNotEquals(changeDate, task.getDueDate());
    }

    @Test
    void setDueDateTrue() {
        Task task = new Task(name, date, project);
        task.setDueDate(changeDate);
        assertEquals(changeDate, task.getDueDate());
    }

    @Test
    void setDueDateFalse() {
        Task task = new Task(name, date, project);
        task.setDueDate(changeDate);
        assertNotEquals(date, task.getDueDate());
    }
    @Test
    void getProjectTrue() {
        Task task = new Task(name, date, project);
        assertEquals(project, task.getProject());
    }

    @Test
    void getProjectFalse() {
        Task task = new Task(name, date, project);
        assertNotEquals(changeProject, task.getProject());
    }
    @Test
    void setProjectTrue() {
        Task task = new Task(name, date, project);
        task.setProject(changeProject);
        assertEquals(changeProject, task.getProject());
    }

    @Test
    void setProjectFalse() {
        Task task = new Task(name, date, project);
        task.setProject(changeProject);
        assertNotEquals(project, task.getProject());
    }

    @Test
    void isCompleteTrue() {
        Task task = new Task(name, date, project);
        assertEquals(false, task.isComplete());
    }

    @Test
    void isCompleteFalse() {
        Task task = new Task(name, date, project);
        assertNotEquals(true, task.isComplete());
    }

    @Test
    void setCompleteTrue() {
        Task task = new Task(name, date, project);
        task.setComplete(true);
        assertEquals(true, task.isComplete());
    }

    @Test
    void setCompleteFalse() {
        Task task = new Task(name, date, project);
        task.setComplete(true);
        assertNotEquals(false, task.isComplete());
    }

    @Test
    void statusToStringTrue() {
        Task task = new Task(name, date, project);
        task.setComplete(true);
        String done = Colours.ANSI_GREEN.toString() + "DONE" + Colours.ANSI_RESET.toString();
        assertEquals(done, task.statusToString());
    }

    @Test
    void statusToStringFalse() {
        Task task = new Task(name, date, project);
        assertNotEquals("DONE", task.statusToString());
    }
}