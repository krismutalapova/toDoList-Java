
import java.util.Scanner;
import java.time.LocalDate;


public class Task {

    private String taskName;
    private LocalDate dueDate; // the format for local date is (yyyy-MM-dd)
    private String project;
    private boolean isComplete;

    /**
     * used to create a task with the status set to not complete
     *
     * @param taskName The name of the task
     * @param dueDate  The date of the task
     * @param project  The project of the task
     */
    public Task(String taskName, LocalDate dueDate, String project) {

        this.taskName = taskName;
        this.dueDate = dueDate;
        this.project = project;
        isComplete = false;
    }

    /**
     * used to create a task with the variable status
     *
     * @param taskName   The name of the task
     * @param dueDate    The date of the task
     * @param project    The project of the task
     * @param isComplete The status of the task
     */
    public Task(String taskName, LocalDate dueDate, String project, boolean isComplete) {

        this.taskName = taskName;
        this.dueDate = dueDate;
        this.project = project;
        this.isComplete = isComplete;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject() {
        this.project = project;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String setStatus() {

        if ( isComplete ) {
            return "DONE";
        }
        return "PENDING";
    }

    @Override
    public String toString() {
        return '\'' + taskName + '\'' +
                ", the due date is '" + dueDate + '\'' +
                ", the project is '" + project + '\'' +
                ", status is " + setStatus();
    }

}
//
//
//





