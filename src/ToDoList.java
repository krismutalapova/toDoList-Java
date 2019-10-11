import java.util.ArrayList;
import java.util.Comparator;

public class ToDoList {
    private ArrayList<Task> myTasks;

    public ToDoList() {
        myTasks = new ArrayList<>();
    }

    public void addTaskToList(Task task) {
        myTasks.add(task);
    }

    /**
     * counts the number of tasks added to the list
     * @return long value
     */
    public long numberOfTasks(boolean isComplete){
        return myTasks.stream()
               .filter(task -> task.isComplete() == isComplete)
               .count();
    }

    /**
     * displays all the added tasks in the list
     */
    public void showListOfTasks() {
        myTasks.stream()
                .map(task -> task.toString())
                .forEach(string -> System.out.println(string));
    }

    /**
     * sorts the list of tasks by their due date
     */
    public void sortListByDate() {
        myTasks.stream()
                .sorted(Comparator.comparing(task -> task.getDueDate()))
                .map(task -> task.toString())
                .forEach(string -> System.out.println(string));
    }
}