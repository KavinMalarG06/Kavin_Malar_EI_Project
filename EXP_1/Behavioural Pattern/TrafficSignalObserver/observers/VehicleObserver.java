package observers;

import contracts.Observer;
import core.TrafficSignalState;
import utils.LoggerUtil;

public class VehicleObserver implements Observer {
    @Override
    public void update(TrafficSignalState state) {
        switch (state) {
            case GREEN -> LoggerUtil.getLogger().info("Vehicles: Move now!");
            case RED -> LoggerUtil.getLogger().info("Vehicles: Stop immediately!");
            case YELLOW -> LoggerUtil.getLogger().info("Vehicles: Prepare to stop!");
        }
    }
}
