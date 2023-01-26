package duke.commands;

import duke.Parser;
import duke.TaskList;
import duke.DukeException;

public class UnmarkCommand extends Command {
    public static final String COMMAND_FORMAT = "unmark";

    public UnmarkCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        String input = super.input;
        try {
            String[] tokens = input.split(" ");
            int taskIndex = Integer.parseInt(tokens[1]);
            String result = tasks.unmarkTask(taskIndex);
            return result;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
            throw new DukeException(Parser.INVALID_COMMAND_EXCEPTION_MESSAGE);
        }
    }
}