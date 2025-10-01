package contracts;
import core.TrafficSignalState;

public interface Observer {
    void update(TrafficSignalState state);
}
