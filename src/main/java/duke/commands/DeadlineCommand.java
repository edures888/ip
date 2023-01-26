package duke.commands;

import duke.DukeException;
import duke.Parser;
import duke.TaskList;
import duke.tasks.DeadlineTask;

public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";
    private static final String DEADLINE_PREFIX = "/by ";

    public DeadlineCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        String input = super.input;
        try {
            int prefixIndex = input.indexOf(DEADLINE_PREFIX);
            String taskName = input.substring(COMMAND_WORD.length(), prefixIndex - 1);
            String deadline = input.substring(prefixIndex + DEADLINE_PREFIX.length());
            String result = tasks.addTask(DeadlineTask.createTask(taskName, deadline));
            return result;
        } catch (IndexOutOfBoundsException exception) {
            throw new DukeException(Parser.INVALID_COMMAND_EXCEPTION_MESSAGE);
        }
    }
}