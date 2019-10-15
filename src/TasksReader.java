import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TasksReader {

    private static final String FILE_PATH = "src/resources/";
    private static final String FILE_NAME = "task.csv";

    /**
     * Write a list of tasks into a file
     */
    public void writeIntoFile(ArrayList<Task> myTasks) {
        File folder = new File(FILE_PATH);
        if ( !folder.exists() ) {
            folder.mkdir();
        }
        File file = new File(FILE_PATH + FILE_NAME);
        try (PrintWriter pw = new PrintWriter(file)) {
            myTasks.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (IOException e) {
            System.out.println("Oops, något gick fel");
        }
    }

    /**
     * Convert a list of tasks into a CSV file
     *
     * @param task is a task to be converted in a CSV line
     * @return String
     */
    public String convertToCSV(Task task) {
        return escapeSpecialCharacters(task.getTaskName()) + "," +
                task.getDueDate() + "," +
                escapeSpecialCharacters(task.getProject()) + "," +
                task.isComplete();
    }

    /**
     *
     * @param data
     * @return
     */
    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if ( data.contains(",") || data.contains("\"") || data.contains("'") ) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public ArrayList<Task> getTasks() {
        // Create a Task from a CSV input line.
        Function<String, Task> createTask =
                csvLine -> {
                    // split on the comma only if that comma has zero or an even number of quotes ahead of it
                    String[] fields = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    if ( fields.length == 4 ) { // 4 is the number of fields in the task
                        try {
                            String taskName = fields[0]
                                    .replaceAll("^\"|\"$", "").replaceAll("\"\"", "\"");
                            ;
                            LocalDate dueDate = App.convertDate(fields[1]);
                            String project = fields[2]
                                    .replaceAll("^\"|\"$", "").replaceAll("\"\"", "\"");
                            ;
                            boolean isComplete = Boolean.parseBoolean(fields[3]);

                            return new Task(taskName, dueDate, project, isComplete);
                        } catch (Exception e) {
                            System.out.println("Task csvLine has a malformed integer");
                            return null;
                        }
                    } else {
                        System.out.println("Task csvLine has the wrong number of fields");
                        return null;
                    }
                };


        ArrayList<Task> tasks;
        try {
            tasks = Files.lines(Paths.get(FILE_PATH + FILE_NAME))
                    .map(createTask)
                    .filter(task -> task != null)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("Unable to open " + FILE_PATH + FILE_NAME);
            tasks = new ArrayList<>();
        }
        return tasks;
    }
}