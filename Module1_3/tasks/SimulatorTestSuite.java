// Assuming you have these supporting classes:
enum EventType {
    ARRIVAL, DEPARTURE
}

class Customer {
    private static int nextId = 1;
    private int id;
    private double arrivalTime;

    public Customer() {
        this.id = nextId++;
        this.arrivalTime = Clock.getInstance().getTime();
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public int getId() {
        return id;
    }
}

class Event {
    private EventType type;
    private double time;

    public Event(EventType type, double time) {
        this.type = type;
        this.time = time;
    }

    public EventType getType() { return type; }
    public double getTime() { return time; }
}

class ServicePoint {
    private java.util.Queue<Customer> queue;

    public ServicePoint() {
        this.queue = new java.util.LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    public Customer removeCustomer() {
        return queue.poll();
    }

    public boolean hasCustomers() {
        return !queue.isEmpty();
    }

    public int getQueueLength() {
        return queue.size();
    }
}

class EventList {
    private java.util.List<Event> events;

    public EventList() {
        this.events = new java.util.ArrayList<>();
    }

    public void add(Event event) {
        events.add(event);
    }

    public Event remove() {
        if (!events.isEmpty()) {
            return events.remove(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public int size() {
        return events.size();
    }
}

// Main test program
public class SimulatorTestSuite {
    public static void main(String[] args) {
        System.out.println("=== Simulator Test Suite ===\n");

        // Initialize components
        Clock clock = Clock.getInstance();
        clock.setTime(0.0);

        EventList eventList = new EventList();
        ServicePoint servicePoint = new ServicePoint();
        ArrivalProcess arrivalProcess = new ArrivalProcess(EventType.ARRIVAL, 0.2);

        // Step 1: Generate 10 arrival events
        System.out.println("1. Generating 10 arrival events:");
        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextEvent(eventList);
        }
        System.out.println("Final event generation time: " + clock.getTime());

        // Step 2: Process all events (create customers)
        System.out.println("\n2. Processing events and creating customers:");
        while (!eventList.isEmpty()) {
            Event event = eventList.remove();
            Customer customer = new Customer();
            servicePoint.addCustomer(customer);
            System.out.println("Customer " + customer.getId() +
                    " arrived at time " + customer.getArrivalTime());
        }

        // Step 3: Advance clock by 5 time units
        clock.advanceTime(5.0);
        System.out.println("\n3. Clock advanced by 5 units to: " + clock.getTime());

        // Step 4: Process customers and calculate system times
        System.out.println("\n4. Processing customers and calculating system times:");
        System.out.println("Customer ID | Arrival Time | Departure Time | System Time");
        System.out.println("--------------------------------------------------------");

        while (servicePoint.hasCustomers()) {
            Customer customer = servicePoint.removeCustomer();
            double departureTime = clock.getTime();
            double systemTime = departureTime - customer.getArrivalTime();

            System.out.printf("%10d | %12.2f | %14.2f | %11.2f\n",
                    customer.getId(),
                    customer.getArrivalTime(),
                    departureTime,
                    systemTime);
        }

        System.out.println("\nTest completed successfully!");
    }
}
