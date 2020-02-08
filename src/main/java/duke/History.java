package duke;

import duke.task.Task;

import java.util.Stack;

/**
 * Keeps track of the history of task lists.
 */
public class History {

    private Stack<String> historyCommand;
    private Stack<Task> historyTask;

    /**
     * Constructs a History with the history being initialised.
     */
    public History() {
        historyCommand = new Stack<>();
        historyTask = new Stack<>();
    }

    /**
     * Updates the history of commands and tasks related to the commands.
     *
     * @param cmdDetails The command and its details.
     * @param task The task related to the commands.
     */
    public void updateHistory(String cmdDetails, Task task) {
        historyCommand.push(cmdDetails);
        historyTask.push(task);
    }

    /**
     * Remove the history of commands and tasks related to the commands.
     * It also undo the commands and updates the TaskList accordingly.
     *
     * @param taskList The TaskList to be updated.
     * @throws DukeException If there is no more history to undo further.
     */
    public void removeHistory(TaskList taskList) throws DukeException {
        if (historyCommand.empty() && historyTask.empty()) {
            throw new DukeException("OOPS!!! Can't undo further.");
        }
        String[] cmdAndDetails = historyCommand.pop().split(" ");
        String command = cmdAndDetails[0];
        Task task = historyTask.pop();
        if (command.equals("add")) {
            int size = taskList.getSize();
            taskList.removeTask(size - 1);
        } else if (command.equals("del")) {
            assert cmdAndDetails.length == 2 : "missing info for del";
            String idx = cmdAndDetails[1];
            int index = Integer.parseInt(idx);
            taskList.getTasks().add(index, task);
        } else if (command.equals("mark")) {
            task.markAsUndone();
        }
    }

}
