package manager;

import model.Task;
import observer.TaskObserver;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<TaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public boolean addTask(Task newTask) {
        for (Task existing : tasks) {
            if (overlaps(newTask, existing)) {
                notifyConflict(newTask, existing);
                LoggerUtil.log("Conflict detected: " + newTask.getDescription());
                return false;
            }
        }
        tasks.add(newTask);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        notifyUpdate("Task added successfully: " + newTask.getDescription());
        LoggerUtil.log("Task added: " + newTask.getDescription());
        return true;
    }

    public boolean removeTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                tasks.remove(task);
                notifyUpdate("Task removed: " + description);
                LoggerUtil.log("Task removed: " + description);
                return true;
            }
        }
        System.out.println("Error: Task not found.");
        return false;
    }

    public boolean editTask(String description, Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().equalsIgnoreCase(description)) {
                tasks.set(i, updatedTask);
                tasks.sort(Comparator.comparing(Task::getStartTime));
                notifyUpdate("Task updated: " + updatedTask.getDescription());
                LoggerUtil.log("Task updated: " + updatedTask.getDescription());
                return true;
            }
        }
        System.out.println("Error: Task not found.");
        return false;
    }

    public void markCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                notifyUpdate("Task marked as completed: " + description);
                LoggerUtil.log("Task completed: " + description);
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.forEach(System.out::println);
    }

    public void viewTasksByPriority(String priority) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) System.out.println("No tasks with priority: " + priority);
    }

    private boolean overlaps(Task t1, Task t2) {
        return t1.getStartTime().isBefore(t2.getEndTime()) && t1.getEndTime().isAfter(t2.getStartTime());
    }

    private void notifyConflict(Task newTask, Task existing) {
        for (TaskObserver observer : observers) {
            observer.notifyConflict(newTask, existing);
        }
    }

    private void notifyUpdate(String message) {
        for (TaskObserver observer : observers) {
            observer.notifyUpdate(message);
        }
    }
}
