import commands.*;
import invoker.RobotControllerInvoker;
import receiver.Robot;
import utils.InputValidator;
import utils.LoggerUtil;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.log("Robot Controller Started");
        
        Robot robot = new Robot();
        RobotControllerInvoker controller = new RobotControllerInvoker();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Robot Controller Menu ===");
            System.out.println("1. Move Forward");
            System.out.println("2. Move Backward");
            System.out.println("3. Turn Left");
            System.out.println("4. Turn Right");
            System.out.println("5. Pick/Place Object");
            System.out.println("6. Undo Last Command");
            System.out.println("7. Exit");

            int choice = InputValidator.getValidatedInt("Enter choice: ", 1, 7);

            switch (choice) {
                case 1 -> controller.executeCommand(new MoveForwardCommand(robot));
                case 2 -> controller.executeCommand(new MoveBackwardCommand(robot));
                case 3 -> controller.executeCommand(new TurnLeftCommand(robot));
                case 4 -> controller.executeCommand(new TurnRightCommand(robot));
                case 5 -> controller.executeCommand(new PickPlaceCommand(robot));
                case 6 -> controller.undoLastCommand();
                case 7 -> {
                    running = false;
                    LoggerUtil.log("Exiting Robot Controller");
                }
            }
        }
    }
}
