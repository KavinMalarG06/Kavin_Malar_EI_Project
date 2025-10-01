
import simulation.CloudSimulator;
import simulation.UserInputHandler;
import exceptions.SimulationException;
import utils.LoggerUtil;

public class MainApp {
    public static void main(String[] args) {
        CloudSimulator simulator = new CloudSimulator();
        UserInputHandler inputHandler = new UserInputHandler();
        boolean running = true;

        while (running) {
            try {
                String choice = inputHandler.getUserChoice();

                switch (choice) {
                    case "1" -> simulator.addCloud("CUMULUS");
                    case "2" -> simulator.addCloud("CIRRUS");
                    case "3" -> simulator.addCloud("STRATUS");
                    case "4" -> {
                        LoggerUtil.getLogger().info("Exiting simulation.");
                        running = false;
                    }
                    default -> LoggerUtil.getLogger().warning("Invalid menu option selected.");
                }

            } catch (SimulationException e) {
                LoggerUtil.getLogger().severe("Simulation error: " + e.getMessage());
            } catch (Exception e) {
                LoggerUtil.getLogger().severe("Unexpected error: " + e.getMessage());
            }
        }
    }
}
