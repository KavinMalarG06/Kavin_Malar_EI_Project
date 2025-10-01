package utils;
import java.util.logging.*;

public class LoggingUtils {
    private static final Logger logger = Logger.getLogger("VehicleFactoryLogger");

    static {
        try {
            LogManager.getLogManager().reset();
            ConsoleHandler ch = new ConsoleHandler();
            ch.setLevel(Level.ALL);
            logger.addHandler(ch);
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void error(String msg, Exception ex) {
        logger.log(Level.SEVERE, msg, ex);
    }

    public static void warning(String msg) {
        logger.warning(msg);
    }
}