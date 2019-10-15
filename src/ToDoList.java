import java.util.ArrayList;
import java.util.Comparator;

public class ToDoList {
    private ArrayList<Task> myTasks = new ArrayList<>();


    public void addTaskToList(Task task) {
        myTasks.add(task);
    }

    /**
     * counts the number of tasks added to the list
     *
     * @return long value
     */
    public long numberOfTasks(boolean isComplete) {
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
                .forEach(System.out::println);
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

    /**
     * sorts the list of tasks by the project
     */
    public void sortListByProject(){
        myTasks.stream()
                .sorted(Comparator.comparing(Task::getProject))
                .map(Task::toString)
                .forEach(System.out::println);

    }

    protected void listOfTasksMenu() {
        boolean backToMenu = false;
        App app = new App();
        while (!backToMenu) {

            tasksMenu();
            switch (app.nextStep()){
                case "1":
                    showListOfTasks();
                    break;
                case "2":
                    sortListByDate();
                    break;
                case "3":
                    sortListByProject();
                    break;
                case "4":
                    backToMenu = true;
                    app.printOptions();
                    break;
                default:
                    System.out.println("Sorry invalid option :( ");
                    break;
            }
            app.printReturnMenu();
        }
    }
    private void tasksMenu(){
        System.out.println("*************************");
        System.out.println("(1) Show all tasks");
        System.out.println("(2) Sort tasks by date");
        System.out.println("(3) Sort tasks by project");
        System.out.println("(4) Return to menu");
        System.out.println("Press 1, 2, 3 or 4");
        System.out.println("*************************\n");
    }
    public ArrayList<Task> getMyTasks (){
        return myTasks;
    }

    public void savedTasks (ArrayList<Task> tasks) {
       myTasks.addAll(tasks);
    }

    public void printTasksToEdit () {

    }
}