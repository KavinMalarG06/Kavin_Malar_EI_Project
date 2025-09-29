package utils;

import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("WeatherSimulation");

    public static Logger getLogger() {
        return logger;
    }
}
