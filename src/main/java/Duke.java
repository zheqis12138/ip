import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;
import java.util.Arrays;

public class Duke {

    public static final String BYE = "bye";

    public static void main(String[] args) {
        printWelcomeMessage();
        Task[] taskLists = new Task[100];


        String userInput = getUserInput();

        while(!userInput.equals("bye")){
            String[] userInputSplit = userInput.split(" ");
            String[] inputArrayWithoutType;
            String inputWithoutType;
            String description;
            switch(userInputSplit[0]){
            case "list":
                printTaskList(taskLists, Task.numOfTasks);
                break;

            case "mark":
                int markDoneIndex = Integer.parseInt(userInputSplit[1]) - 1;
                taskLists[markDoneIndex].setIsDone(true);
                printSetDoneMessage(taskLists[markDoneIndex]);
                break;

            case "todo":
                try{
                    addTodo(taskLists, userInputSplit);
                }
                catch(EmptyDescriptionException e){
                    System.out.println(e);
                }

                break;

            case "event":
                addEvent(taskLists, userInputSplit);
                break;

            case "deadline":
                addDeadline(taskLists, userInputSplit);
                break;



            case "unmark":
                int markNotDoneIndex = Integer.parseInt(userInputSplit[1]) - 1;
                taskLists[markNotDoneIndex].setIsDone(false);
                printSetNotDoneMessage(taskLists[markNotDoneIndex]);
                break;

            default:
                printDontKnowMessage();
            }
            userInput = getUserInput();
        }

        printByeMessage();
    }

    private static void addTodo(Task[] taskLists, String[] userInputSplit) throws EmptyDescriptionException {
        if (userInputSplit.length < 2){
            throw new EmptyDescriptionException();
        }
        String[] inputArrayWithoutType = Arrays.copyOfRange(userInputSplit,1, userInputSplit.length);
        String description = String.join(" ", inputArrayWithoutType);
        ToDo newToDo = new ToDo(description);
        taskLists[Task.numOfTasks] = newToDo;
        Task.numOfTasks ++;
        printEchoInput(newToDo);
    }

    private static void addEvent(Task[] taskLists, String[] userInputSplit) {
        String[] inputArrayWithoutType = Arrays.copyOfRange(userInputSplit,1, userInputSplit.length);
        String inputWithoutType = String.join(" ", inputArrayWithoutType);
        String description = inputWithoutType.split(" /at ")[0];
        String time = inputWithoutType.split(" /at ")[1];
        Event newEvent = new Event(description, time);
        taskLists[Task.numOfTasks] = newEvent;
        Task.numOfTasks ++;
        printEchoInput(newEvent);
    }

    private static void addDeadline(Task[] taskLists, String[] userInputSplit) {
        String[] inputArrayWithoutType = Arrays.copyOfRange(userInputSplit,1, userInputSplit.length);
        String inputWithoutType = String.join(" ", inputArrayWithoutType);
        String description = inputWithoutType.split(" /by ")[0];
        String deadline = inputWithoutType.split(" /by ")[1];
        Deadline newDeadline = new Deadline(description, deadline);
        taskLists[Task.numOfTasks] = newDeadline;
        Task.numOfTasks ++;
        printEchoInput(newDeadline);
    }

    private static void printDontKnowMessage(){
        String dontKnowMessage = "    ____________________________________________________________\n"
                        + "     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                        + "    ____________________________________________________________";
        System.out.println(dontKnowMessage);
    }

    public static String getUserInput(){
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        return line;
    }

    public static void printEchoInput(Task task){
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this task:");
        System.out.println(String.format("       %s", task.toString()));
        System.out.println(String.format("     Now you have %d tasks in the list.", Task.numOfTasks));
        System.out.println("    ____________________________________________________________");
    }

    public static void printWelcomeMessage() {
        String welcomeMessage =
                "    ____________________________________________________________\n"
                + "     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + "    ____________________________________________________________";
        System.out.println(welcomeMessage);
    }

    public static void printByeMessage() {
        String byeMessage =
                "    ____________________________________________________________\n"
                + "     Bye. Hope to see you again soon!\n"
                + "    ____________________________________________________________";
        System.out.println(byeMessage);
    }

    // replace count
    public static void printTaskList(Task[] taskLists, int count){
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i=0; i<count; i++){
            Task currTask = taskLists[i];

            int index = i + 1;
            System.out.println("     " + index + "." + currTask.toString());
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void printSetDoneMessage(Task task){
        System.out.println("    ____________________________________________________________");
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("       " + task.toString());
        System.out.println("    ____________________________________________________________");
    }

    public static void printSetNotDoneMessage(Task task){
        System.out.println("    ____________________________________________________________");
        System.out.println("     OK, I've marked this task as not done yet:");
        System.out.println("       " + task.toString());
        System.out.println("    ____________________________________________________________");
    }


}
