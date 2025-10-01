package utils;

public class RetryHandler {
    public static <T> T executeWithRetry(Retryable<T> action, int maxRetries) throws Exception {
        Exception lastException = null;
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                return action.run();
            } 
            catch (Exception e) {
                lastException = e;
                LoggerUtil.getLogger().warning("Attempt " + attempt + " failed: " + e.getMessage());
                if (attempt == maxRetries) throw e;
            }
        }
        throw lastException;
    }
}
