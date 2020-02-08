package duke.ui;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the Ui that deals with interactions with user.
 */
public class Ui {

    protected Scanner sc;

    /**
     * Constructs a Ui with Scanner being initialised.
     */
    public Ui() {
        sc = new Scanner(System.in);
    }


    /**
     * Returns a welcome message.
     *
     * @return The welcome message.
     */
    public static String showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        return "Hello from\n" + logo + "Hello! I'm Duke\nWhat can I do for you?";
    }

    /**
     * Returns the exit message.
     *
     * @return The exit message.
     */
    public String showExit() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Returns the error message.
     *
     * @param msg The error message to be shown to user.
     * @return The error message.
     */
    public String showError(String msg) {
        return msg;
    }

    /**
     * Returns the error message if failure to load tasks from storage.
     *
     * @return The error message if failure to load tasks from storage.
     */
    public String showLoadingError() {
        return "OOPS!!! Fail to load data";
    }

    /**
     * Reads the user input command.
     *
     * @return The user input command.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints a horizontal dotted line.
     */
    public void showLine() {
        System.out.println("    ----------------------------------------------------------");
    }

    /**
     * Returns the messages to be shown to user for add command with specified details.
     *
     * @param details The details including the task and size of list.
     * @return The messages to be shown to user for add command.
     */
    public String showAddMessages(String[] details) {
        String output = "Got it. I've added this task:\n";
        output += details[0] + "\n";
        output += "Now you have " + details[1] + " tasks in the list.";
        return output;
    }

    /**
     * Returns the messages to be shown to user for delete command with specified details.
     *
     * @param details The details including the task and size of list.
     * @return The messages to be shown to user for delete command.
     */
    public String showDeleteMessages(String[] details) {
        String output = "Noted. I've removed this task:\n";
        output += details[0] + "\n";
        output += "Now you have " + details[1] + " tasks in the list.";
        return output;
    }

    /**
     * Returns the messages to be shown to user for done command with specified details.
     *
     * @param details The details including the task.
     * @return The messages to be shown to user for done command.
     */
    public String showDoneMessages(String details) {
        String output = "Nice! I've marked this task as done:\n";
        output += details;
        return output;
    }

    /**
     * Returns the message that shows the list of tasks.
     *
     * @param tasks The list of tasks.
     * @return The message that shows the list of tasks.
     */
    public String showList(ArrayList<Task> tasks) {
        String output = "Here are the tasks in your list:\n";
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            output += (i + 1) + ". " + tasks.get(i).toString() + "\n";
        }
        return output;
    }

    /**
     * Returns the message that shows the list of matching tasks.
     *
     * @param tasks The list of matching tasks.
     * @return The message that shows the list of matching tasks.
     */
    public String showMatchingList(ArrayList<Task> tasks) {
        String output = "Here are the matching tasks in your list:\n";
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            output += (i + 1) + ". " + tasks.get(i).toString() + "\n";
        }
        return output;
    }
}