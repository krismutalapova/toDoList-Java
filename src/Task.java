import java.util.Scanner;

public class Task {

    private String taskName;
    private String dueDate;
    private String project;
    private boolean isComplete;

    public Task(String taskName, String dueDate, String project) {

        this.taskName = taskName;
        this.dueDate = dueDate;
        this.project = project;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", taskName='" + taskName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", project='" + project + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}




