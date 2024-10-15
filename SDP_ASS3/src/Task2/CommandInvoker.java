package Task2;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private List<Command> history = new ArrayList<>();

    public void executeCommand(Command command) {
        history.add(command);
        command.execute();
    }
}
