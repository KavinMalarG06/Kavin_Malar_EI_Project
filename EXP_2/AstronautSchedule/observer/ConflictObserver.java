
package observer;

import model.Task;

public class ConflictObserver implements TaskObserver {
    @Override
    public void notifyConflict(Task newTask, Task existingTask) {
        System.out.println("Error: Task conflicts with existing task \"" + existingTask.getDescription() + "\".");
    }

    @Override
    public void notifyUpdate(String message) {
        System.out.println("Notification: " + message);
    }
}
