import manager.ScheduleManager;
import model.Task;
import model.TaskFactory;
import observer.ConflictObserver;
import utils.LoggerUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictObserver());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Astronaut Daily Schedule Organizer ===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter start time (HH:MM): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:MM): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = sc.nextLine();
                        Task newTask = TaskFactory.createTask(desc, start, end, priority);
                        manager.addTask(newTask);
                        break;
                    case 2:
                        System.out.print("Enter task description to remove: ");
                        manager.removeTask(sc.nextLine());
                        break;
                    case 3:
                        manager.viewTasks();
                        break;
                    case 4:
                        System.out.print("Enter task description to edit: ");
                        String oldDesc = sc.nextLine();
                        System.out.print("Enter new description: ");
                        String newDesc = sc.nextLine();
                        System.out.print("Enter new start time (HH:MM): ");
                        String newStart = sc.nextLine();
                        System.out.print("Enter new end time (HH:MM): ");
                        String newEnd = sc.nextLine();
                        System.out.print("Enter new priority: ");
                        String newPriority = sc.nextLine();
                        Task updatedTask = TaskFactory.createTask(newDesc, newStart, newEnd, newPriority);
                        manager.editTask(oldDesc, updatedTask);
                        break;
                    case 5:
                        System.out.print("Enter task description to mark completed: ");
                        manager.markCompleted(sc.nextLine());
                        break;
                    case 6:
                        System.out.print("Enter priority to view: ");
                        manager.viewTasksByPriority(sc.nextLine());
                        break;
                    case 7:
                        LoggerUtil.log("Shutting down Astronaut Daily Schedule Organizer.");
                        System.out.println("Exiting... Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
