package observers;

import contracts.Observer;
import core.TrafficSignalState;
import utils.LoggerUtil;

public class PedestrianObserver implements Observer {
    @Override
    public void update(TrafficSignalState state) {
        if (state == TrafficSignalState.RED) {
            LoggerUtil.getLogger().info("Pedestrians: Safe to cross now!");
        } 
        else {
            LoggerUtil.getLogger().info("Pedestrians: Do NOT cross, wait for RED.");
        }
    }
}
