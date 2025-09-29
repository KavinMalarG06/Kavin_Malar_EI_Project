package commands;

import receiver.Robot;

public class PickPlaceCommand implements Command {
    private Robot robot;

    public PickPlaceCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.pickPlaceObject();
    }

    @Override
    public void undo() {
        // For simplicity, undoing pick/place just logs reversal action
        System.out.println("Undoing pick/place operation");
    }
}
