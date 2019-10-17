import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ToDoList {
    private ArrayList<Task> myTasks = new ArrayList<>();

    public void addTaskToList(Task task) {
        myTasks.add(task);
    }

    /**
     * Count the number of tasks added to the list
     *
     * @return long value
     */
    public long numberOfTasks(boolean isComplete) {
        return myTasks.stream()
                .filter(task -> task.isComplete() == isComplete)
                .count();
    }

    /**
     * Display all the added tasks in the list
     */
    private void showListOfTasks() {
        myTasks.stream()
                .map(Task::toString)
                .forEach(System.out::println);
    }

    /**
     * Sort the list of tasks by their due date
     */
    public void sortListByDate() {
        myTasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .map(Task::toString)
                .forEach(System.out::println);
    }

    /**
     * Sort the list of tasks by the project
     */
    public void sortListByProject() {
        myTasks.stream()
                .sorted(Comparator.comparing(Task::getProject))
                .map(Task::toString)
                .forEach(System.out::println);
    }

    /**
     * Choose an option from a menu for task list: 1 - unsorted, 2 - sorted by date 3 - sorted by project, 4 - exit
     */
    protected void listOfTasksMenu() {
        App app = new App();
        while (true) {
            tasksMenu();
            switch (app.nextStep()) {
                case "1":
                    showListOfTasks();
                    return;
                case "2":
                    sortListByDate();
                    return;
                case "3":
                    sortListByProject();
                    return;
                case "4":
                    return;
                default:
                    System.out.println(Colours.ANSI_RED.toString() + "Sorry invalid option :( " +
                            Colours.ANSI_RESET.toString());
                    break;
            }
        }
    }

    /**
     * Print a menu to sort the list of tasks by date or by project
     */
    private void tasksMenu() {
        System.out.println(Colours.ANSI_BLUE.toString() + "*************************" + Colours.ANSI_RESET.toString());
        String[] list = {"Show all tasks", "Sort tasks by date", "Sort tasks by project", "Return to menu"};
        for (int i = 0; i < list.length; i++) {
            System.out.println("(" + (i + 1) + ") " + list[i]);
        }
        System.out.println(Colours.ANSI_BLUE.toString() + "Press 1, 2, 3 or 4" + Colours.ANSI_RESET.toString());
        System.out.println(Colours.ANSI_BLUE.toString() + "*************************\n"
                + Colours.ANSI_RESET.toString());
    }

    /**
     * Show the unsorted list of tasks
     * @return an ArrayList of tasks
     */
    public ArrayList<Task> getMyTasks() {
        return myTasks;
    }

    /**
     * Save the tasks in a to-do-list
     * @param tasks
     */
    public void savedTasks(ArrayList<Task> tasks) {
        myTasks.addAll(tasks);
    }

    /**
     * Show the list of tasks with their index for future manipulation
     */
    public void printTasksWithIndex() {
        for (Task task : myTasks) {
            System.out.println((myTasks.indexOf(task) + 1) + " " + task.toString());
        }
    }

    /**
     * Measure the size of the to-do-list
     * @return int the size of the to-do-list
     */
    public int sizeOfTheList() {
        return myTasks.size();
    }

    /**
     * Display a task chosen by the user for future manipulations
     * @param index of the chosen task
     * @return String task
     */
    public String getTheTaskFromTheList(int index) {
        return myTasks.get(index).toString();
    }

    /**
     * Change the name of the chosen task
     *
     * @param index of the chosen task
     * @param name of the task
     */
    public void changeTaskName(int index, String name) {
        myTasks.get(index).setTaskName(name);
    }

    /**
     * Change the date of the chosen task
     * @param index of the chosen task
     * @param date by which the task needs to be completed
     */
    public void changeTaskDate(int index, LocalDate date) {
        myTasks.get(index).setDueDate(date);
    }

    /**
     * Change the project of the chosen task
     * @param index of the chosen task
     * @param project the task is in
     */
    public void changeProject(int index, String project) {
        myTasks.get(index).setProject(project);
    }

    /**
     * Change the status of the task
     * @param index of the chosen task
     * @param isComplete set status as done
     */
    public void changeStatus(int index, boolean isComplete) {
        myTasks.get(index).setComplete(isComplete);
    }

    /**
     * Remove the task from the list
     * @param index of the chosen task
     */
    public void removeTask(int index) {
        myTasks.remove(index);
    }
}