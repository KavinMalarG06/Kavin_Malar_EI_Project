package utils;

@FunctionalInterface
public interface Retryable<T> {
    T run() throws Exception;
}
