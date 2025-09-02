import java.util.LinkedList;
import java.util.Scanner;

public class OrientationTask1_4 {

    public static void main(String[] args) {
        LinkedList<OrientationTask1_3.Customer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Queue Simulation: Type 'queue' to add a customer, 'dequeue' to serve a customer, 'exit' to quit.");

        while (running) {
            System.out.print("Action: ");
            String action = sc.nextLine().toLowerCase();

            switch (action) {
                case "queue":

                    OrientationTask1_3.Customer c = new OrientationTask1_3.Customer();
                    queue.addFirst(c); // add to front of queue
                    System.out.println("Customer " + c.getId() + " added to the queue.");
                    break;

                case "dequeue":
                    if (!queue.isEmpty()) {
                        OrientationTask1_3.Customer served = queue.removeLast();
                        served.setEndTime();
                        System.out.println("Customer " + served.getId() + " served. Time spent in queue: " + served.getTimeSpent() + " ns");
                    } else {
                        System.out.println("Queue is empty. No customer to serve.");
                    }
                    break;

                case "exit":
                    running = false;
                    System.out.println("Exiting simulation.");
                    break;

                default:
                    System.out.println("Invalid action. Type 'queue', 'dequeue', or 'exit'.");
            }
        }

        sc.close();
    }
}
