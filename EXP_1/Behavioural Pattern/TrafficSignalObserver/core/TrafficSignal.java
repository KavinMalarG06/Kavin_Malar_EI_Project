package core;

import contracts.Observer;
import contracts.Subject;
import exceptions.ObserverException;
import utils.LoggerUtil;
import java.util.HashSet;
import java.util.Set;

public class TrafficSignal implements Subject {

    private final Set<Observer> observers = new HashSet<>();
    private TrafficSignalState currentState = TrafficSignalState.RED;

    @Override
    public void attach(Observer observer) {
        if (observer == null) throw new ObserverException("Observer cannot be null");
        if (!observers.add(observer)) {
            LoggerUtil.getLogger().warning("Observer already attached.");
        }
    }

    @Override
    public void detach(Observer observer) {
        if (!observers.remove(observer)) {
            LoggerUtil.getLogger().warning("Observer not found for removal.");
        }
    }

    @Override
    public void notifyObservers(TrafficSignalState state) {
        for (Observer observer : observers) {
            try {
                observer.update(state);
            } catch (Exception e) {
                LoggerUtil.getLogger().severe("Error notifying observer: " + e.getMessage());
            }
        }
    }

    public void changeSignal(TrafficSignalState newState) {
        if (newState == null) throw new IllegalArgumentException("State cannot be null");
        this.currentState = newState;
        LoggerUtil.getLogger().info("Signal changed to: " + newState);
        notifyObservers(newState);
    }

    public TrafficSignalState getCurrentState() {
        return currentState;
    }
}
