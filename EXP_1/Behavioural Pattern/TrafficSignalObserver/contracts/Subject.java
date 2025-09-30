package contracts;

import core.TrafficSignalState;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(TrafficSignalState state);
}
