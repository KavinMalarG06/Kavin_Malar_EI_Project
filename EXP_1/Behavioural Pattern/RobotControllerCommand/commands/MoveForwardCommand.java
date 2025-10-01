package commands;

import receiver.Robot;
public class MoveForwardCommand implements Command {
    private Robot robot;

    public MoveForwardCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveForward();
    }

    @Override
    public void undo() {
        robot.moveBackward();
    }
}
