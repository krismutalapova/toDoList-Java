import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    ArrayList<Task> myTasks = new ArrayList<>();
    String name = "coffee";
    LocalDate date = App.convertDate("2020-12-12");
    String project = "SHOPPING";
    String name2 = "bananas";
    LocalDate date2 = App.convertDate("2021-12-12");
    String project2 = "SHOPPING";

    @Test
    void addTaskToList() {
    ToDoList toDoList = new ToDoList();
    ArrayList<Task> myTasks = new ArrayList<>();
    assertEquals(myTasks, toDoList.getMyTasks() );
    }

    @Test
    void numberOfCompleteTasksTrue() {
        ToDoList toDoList = new ToDoList();
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        toDoList.addTaskToList(task);
        toDoList.addTaskToList(task2);

        assertEquals(2, toDoList.numberOfTasks(false));
    }

    @Test
    void numberOfTasksCompleteFalse() {
        ToDoList toDoList = new ToDoList();
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        toDoList.addTaskToList(task);
        toDoList.addTaskToList(task2);
        task.setComplete(true);
        assertNotEquals(2, toDoList.numberOfTasks(false));
    }


    @Test
    void getMyTasks() {
        ToDoList toDoList = new ToDoList();
        ArrayList<Task> myTasks = new ArrayList<>();
        assertEquals(myTasks, toDoList.getMyTasks() );
    }

    @Test
    void saveTasksToListTrue() {
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        assertTrue(myTasks.size() == 2);
    }


    @Test
    void sizeOfTheListTrue() {
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        assertEquals(2, myTasks.size());
    }

    @Test
    void sizeOfTheListFalse() {
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        assertNotEquals(3, myTasks.size());
    }
    @Test
    void getTheTaskFromTheListTrue() {
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        assertEquals(task.toString(), myTasks.get(0).toString());
    }

    @Test
    void getTheTaskFromTheListFalse() {
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        assertNotEquals(task.toString(), myTasks.get(1).toString());
    }

    @Test
    void changeTaskNameTrue() {
        Task task = new Task(name, date, project);
        task.setTaskName(name2);
        assertEquals(name2, task.getTaskName());
    }

    @Test
    void changeTaskDateTrue() {
        Task task = new Task(name, date, project);
        task.setDueDate(date2);
        assertEquals(date2, task.getDueDate());
    }

    @Test
    void changeProjectTrue() {
        Task task = new Task(name, date, project);
        task.setProject(project2);
        assertEquals(project2, task.getProject());
    }

    @Test
    void changeStatusTrue() {
        Task task = new Task(name, date, project, false);
        task.setComplete(true);
        assertEquals(true, task.isComplete());
    }


    @Test
    void removeTaskTrue() {
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        myTasks.remove(task);
        assertEquals(task2, myTasks.get(0));
        assertTrue(myTasks.size() == 1);
    }
}