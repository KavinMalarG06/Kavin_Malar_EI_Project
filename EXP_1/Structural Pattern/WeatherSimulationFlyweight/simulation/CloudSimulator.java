package simulation;

import cloud.Cloud;
import cloud.CloudFactory;
import cloud.CloudType;
import exceptions.SimulationException;
// import utils.LoggerUtil;
import utils.RetryHandler;

import java.util.Random;

public class CloudSimulator {
    private final Random random = new Random();

    public void addCloud(String typeInput) throws SimulationException {
        try {
            CloudType type = CloudType.valueOf(typeInput.toUpperCase());
            Cloud cloud = CloudFactory.getCloud(type);

            int x = random.nextInt(1000);
            int y = random.nextInt(500);

            RetryHandler.executeWithRetry(() -> {
                cloud.render(x, y);
                return null;
            }, 3);

        } catch (IllegalArgumentException e) {
            throw new SimulationException("Invalid cloud type entered: " + typeInput, e);
        } catch (Exception e) {
            throw new SimulationException("Rendering failed after retries", e);
        }
    }
}
