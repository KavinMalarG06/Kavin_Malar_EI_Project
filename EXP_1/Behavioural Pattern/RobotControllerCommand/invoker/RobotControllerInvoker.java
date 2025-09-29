package invoker;

import commands.Command;
import utils.LoggerUtil;
import java.util.Stack;

public class RobotControllerInvoker {
    private Stack<Command> commandHistory = new Stack<>();

    public void executeCommand(Command command) {
        try {
            command.execute();
            commandHistory.push(command);
        } catch (Exception e) {
            LoggerUtil.logError("Command execution failed: " + e.getMessage());
        }
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
            LoggerUtil.log("Undo last command");
        } else {
            LoggerUtil.log("No commands to undo");
        }
    }
}
