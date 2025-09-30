package observers;

import contracts.Observer;
import core.TrafficSignalState;
import utils.LoggerUtil;

public class TrafficPoliceObserver implements Observer {
    @Override
    public void update(TrafficSignalState state) {
        LoggerUtil.getLogger().info("Traffic Police notified: Signal is " + state);
    }
}
