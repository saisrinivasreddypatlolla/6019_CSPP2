import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                System.out.println(todo);
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            case "get-next-n":
                int n = Integer.parseInt(tokens[2]);
                Task[] tasks = todo.getNextTask(tokens[1], n);
                System.out.println(Arrays.deepToString(tasks));
                break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        if (title.length() == 0) {
            throw new Exception("Title not provided");
        }
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        if (timeToComplete < 0) {
            throw new Exception("Invalid timeToComplete " + timeToComplete);
        }
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        if (!(status.equals("todo") || status.equals("done"))) {
            throw new Exception("Invalid status " + status);
        }
        return new Task(
                   title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
/**.
 * Class for task.
 */
class Task {
    /**.
     * { var_description }
     */
    String title;
    /**.
     * { var_description }
     */
    String assignedTo;
    /**.
     * { var_description }
     */
    int timeToComplete;
    /**.
     * { var_description }
     */
    boolean important;
    /**.
     * { var_description }
     */
    boolean urgent;
    /**.
     * { var_description }
     */
    String status;
    /**.
     * Constructs the object.
     */
    Task() {

    }
    /**.
     * Constructs the object.
     *
     * @param      title1           The title 1
     * @param      assignedTo1      The assigned to 1
     * @param      timeToComplete1  The time to complete 1
     * @param      important1       The important 1
     * @param      urgent1          The urgent 1
     * @param      status1          The status 1
     */
    Task(String title1, String assignedTo1, int timeToComplete1, boolean important1, boolean urgent1, String status1) {
        this.title = title1;
        this.assignedTo = assignedTo1;
        this.timeToComplete = timeToComplete1;
        this.important = important1;
        this.urgent = urgent1;
        this.status = status1;
    }
    /**.
     * Gets the title.
     *
     * @return     The title.
     */
    public String getTitle() {
        // System.out.println(title);
        return this. title;
    }
    /**.
     * Gets the assigned to.
     *
     * @return     The assigned to.
     */
    public String getAssignedTo() {
        // System.out.println(assignedTo);

        return this.assignedTo;
    }
    public int getTimeToComplete() {
        // System.out.println(timeToComplete);

        return this.timeToComplete;
    }
    public String getImportant() {
        // System.out.println(urgent);

        if (important == true) {
            return "Important";
        }
        return "Not Important";
    }
    public String getUrgent() {
        // System.out.println(important);

        if (urgent == true) {
            return "Urgent";
        }
        return "Not Urgent";
    }
    public String getStatus() {
        // System.out.println(status);
        return this.status;
    }
    @Override
    public String toString() {
        String s = "";
        s += getTitle() + ", " + getAssignedTo() + ", " + getTimeToComplete()
             + ", " + getImportant() + ", " + getUrgent() + ", " + getStatus();
        return s;
    }

}
class Todoist {
    Task[] obj;
    int size;
    int flag = 0, flag1 = 0;
    Task[] tasks;
    Todoist() {
        obj = new Task[10];
        size = 0;
    }
    public void addTask(Task t)throws Exception {
        if (size == obj.length) {
            resize();
        }
        obj[size++] = t;
    }
    private void resize() {
        obj = Arrays.copyOf(obj, 2 * obj.length);
    }
    public Task getNextTask(String s) {
        for (int i = 0; i < size; i++) {
            if (s.equals(obj[i].getAssignedTo())) {
                if (obj[i].getStatus().equals("todo")) {
                    if (obj[i].getImportant().equals("Important") && (
                                obj[i].getUrgent().equals("Not Urgent"))) {
                        return obj[i];
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (s.equals(obj[i].getAssignedTo())) {
                if (obj[i].getStatus().equals("todo")) {
                    if (obj[i].getImportant().equals("Important") && (
                                obj[i].getUrgent().equals("Urgent"))) {
                        return obj[i];
                    }
                }
            }
        }

        return null;

    }
    public Task[] getNextTask(String s, int n) {
        Task x = new Task();
        int count = 0, k = 0;
        tasks = new Task[3];
        for (int i = 0; i < n; i++) {
            for (int j = k; j < size; j++) {
                if (s.equals(obj[j].getAssignedTo())) {
                    if (obj[j].getStatus().equals("todo")) {
                        System.out.println((s.equals(obj[j].getAssignedTo())) + " " + s + " " + obj[j]);

                        if (obj[j].getImportant().equals("Important") && (
                                    obj[j].getUrgent().equals("Not Urgent"))) {
                            x = obj[j];
                            flag = 1;
                            k = j + 1;

                        }
                    }
                }
            }
            for (int j = k; j < size; j++) {
                if (s.equals(obj[j].getAssignedTo())) {
                    System.out.println((s.equals(obj[j].getAssignedTo())) + " " + s);
                    if (obj[j].getStatus().equals("todo")) {
                        if (obj[j].getImportant().equals("Important") && (
                                    obj[j].getUrgent().equals("Urgent"))) {
                            x = obj[j];
                            flag = 1;
                            k = j + 1;
                        }
                    }
                }
            }
            // for (int k = 0; k < tasks.length; k++) {
            //     if (!(x.equals(tasks[i]))) {
            //         flag1 = 1;
            //     }
            // }
            if (flag == 1) {
                tasks[i] = x;
                count++;
            } else {
                tasks[i] = null;

                System.out.println(Arrays.toString(tasks));
            }


        }
        return tasks;
    }
    public int totalTime4Completion() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (obj[i].getStatus().equals("todo")) {
                sum += obj[i].getTimeToComplete();
            }
        }
        return sum;
    }
    @Override
    public String toString() {
        String str = "";
        int i;
        for (i = 0; i < size - 1; i++) {
            str += obj[i].getTitle() + ", " + obj[i].getAssignedTo() + ", " + obj[i].getTimeToComplete()
                   + ", " + obj[i].getImportant() + ", " + obj[i].getUrgent() + ", " + obj[i].getStatus() + "\n";
        }
        str += obj[i].getTitle() + ", " + obj[i].getAssignedTo() + ", " + obj[i].getTimeToComplete()
               + ", " + obj[i].getImportant() + ", " + obj[i].getUrgent() + ", " + obj[i].getStatus();
        return str;
    }


}