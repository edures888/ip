package duke.commands;

import duke.DukeException;
import duke.TaskList;

public abstract class Command {
    private String input;
    public Command(String input) {
        this.input = input;
    }
    public abstract String execute(TaskList tasks) throws DukeException;

    public String getInput() {
        return input;
    }
}
