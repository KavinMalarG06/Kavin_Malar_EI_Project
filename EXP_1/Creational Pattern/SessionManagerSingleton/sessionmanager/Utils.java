package sessionmanager;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Utils {
    private static final String LOG_FILE = "logs/app.log";

    public static void logInfo(String message) {
        log("INFO", message);
    }

    public static void logWarning(String message) {
        log("WARNING", message);
    }

    public static String readLine(String prompt, Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null");
        }

        System.out.print(prompt);
        String line = null;

        try {
            line = scanner.nextLine();
        } catch (Exception e) {
            logWarning("Error reading input: " + e.getMessage());
            return ""; 
        }

        if (line == null) {
            return "";
        }
        return line.trim();
    }


    private static void log(String level, String message) {
        String logMessage = String.format("[%s] %s: %s", LocalDateTime.now(), level, message);
        System.out.println(logMessage);

        try {
            File logFile = new File(LOG_FILE);
            File logDir = logFile.getParentFile();

            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            try (PrintWriter out = new PrintWriter(new FileWriter(logFile, true))) {
                out.println(logMessage);
            }
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
