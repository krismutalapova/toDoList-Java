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

    /**
     * Get the name of the task
     * @return String task name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Set the name of the task
     * @param taskName String
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Get the due date of the task
     * @return Local date
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Set the due date for the task
     * @param dueDate
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get the project the task is in
     * @return String project
     */
    public String getProject() {
        return project;
    }

    /**
     * Set the project for the task
     * @param project
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Get the status of the task
     * @return
     */
    public boolean isComplete() {
        return isComplete;
    }

    /**
     * Set the status as complete
     * @param complete
     */
    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    /**
     * Turn status into Pending if isComplete is false, Done otherwise
     * @return
     */
    public String statusToString() {

        if ( isComplete ) {
            return Colours.ANSI_GREEN.toString() + "DONE" + Colours.ANSI_RESET.toString();
        }
        return Colours.ANSI_RED.toString() + "PENDING" + Colours.ANSI_RESET.toString();
    }

    /**
     * Turn task into string
     * @return
     */
    @Override
    public String toString() {
        return "Task: " + Colours.ANSI_BLUE.toString() + '\'' + taskName + '\'' + Colours.ANSI_RESET.toString() +
                ", due date: " + Colours.ANSI_BLUE.toString() + '\'' + dueDate + '\'' +
                Colours.ANSI_RESET.toString() + ", project: " + Colours.ANSI_BLUE.toString() + '\'' +
                project + '\'' + Colours.ANSI_RESET.toString() + ", status: " + statusToString();
    }
}






