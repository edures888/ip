package duke.commands;

import duke.Parser;
import duke.TaskList;
import duke.DukeException;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public ListCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        if (!input.equals(COMMAND_WORD)) {
            throw new DukeException(Parser.INVALID_COMMAND_EXCEPTION_MESSAGE);
        }
        return tasks.toString();
    }
}