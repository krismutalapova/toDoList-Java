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
    void numberOfTasksTrue() {
        ToDoList toDoList = new ToDoList();
        ArrayList<Task> myTasks = new ArrayList<>();
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);

        assertEquals(0, toDoList.numberOfTasks(true));
    }

    @Test
    void numberOfTasksFalse() {
        ToDoList toDoList = new ToDoList();
        ArrayList<Task> myTasks = new ArrayList<>();
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        task.setComplete(true);
        assertNotEquals(1, toDoList.numberOfTasks(true));
    }
//    @Test
//    void sortListByDate() {
//        ToDoList toDoList = new ToDoList();
//        ArrayList<String> expect = new ArrayList<>();
//        String date = "2020-12-12";
//        String date2 = "2021-12-13";
//        String date3 = "2022-10-11";
//        expect.add(date);
//        expect.add(date2);
//        expect.add(date3);
//        assertEquals(expect, toDoList.sortListByDate(expect));
//
//    }

    @Test
    void sortListByProject() {
    }


    @Test
    void getMyTasks() {
        ToDoList toDoList = new ToDoList();
        ArrayList<Task> myTasks = new ArrayList<>();
        assertEquals(myTasks, toDoList.getMyTasks() );
    }

    @Test
    void savedTasks() {
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
        ToDoList toDoList = new ToDoList();
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        assertEquals(task.toString(), myTasks.get(0).toString());
    }

    @Test
    void getTheTaskFromTheListFalse() {
        ToDoList toDoList = new ToDoList();
        Task task = new Task(name, date, project);
        Task task2 = new Task(name2, date2, project2);
        myTasks.add(task);
        myTasks.add(task2);
        assertNotEquals(task.toString(), myTasks.get(1).toString());
    }

    @Test
    void changeTaskName() {
    }

    @Test
    void changeTaskDate() {
    }

    @Test
    void changeProject() {
    }

    @Test
    void changeStatus() {
    }

    @Test
    void removeTask() {
    }
}