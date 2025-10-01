package commands;

import receiver.Robot;
public class MoveBackwardCommand implements Command {
    private Robot robot;

    public MoveBackwardCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveBackward();
    }

    @Override
    public void undo() {
        robot.moveForward();
    }
}
