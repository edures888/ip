package duke.commands;

import duke.DukeException;
import duke.Parser;
import duke.TaskList;
import duke.tasks.TodoTask;

public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";

    public TodoCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        // Prepare arguments for Todo task
        String input = getInput();
        String taskName = input.substring(COMMAND_WORD.length());
        if (taskName.isEmpty()) {
            throw new DukeException(Parser.INVALID_COMMAND_EXCEPTION_MESSAGE);
        }

        String result = tasks.addTask(new TodoTask(taskName));
        return result;
    }
}
