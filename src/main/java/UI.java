import duke.Task;

public class UI {
    public static void printDontKnowMessage(){
        String dontKnowMessage = "    ____________________________________________________________\n"
                + "     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                + "    ____________________________________________________________";
        System.out.println(dontKnowMessage);
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
