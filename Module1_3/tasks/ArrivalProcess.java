import java.util.Random;

public class ArrivalProcess {
    private EventType eventType;
    private Random randomGenerator;
    private double lambda; // Rate parameter for exponential distribution

    // Constructor
    public ArrivalProcess(EventType eventType, double lambda) {
        this.eventType = eventType;
        this.lambda = lambda;
        this.randomGenerator = new Random();
    }

    // Method to generate next arrival time (exponential distribution)
    private double generateNextArrivalInterval() {
        return -Math.log(1 - randomGenerator.nextDouble()) / lambda;
    }

    // Method to add new arrival event to event list
    public void generateNextEvent(EventList eventList) {
        Clock clock = Clock.getInstance();
        double currentTime = clock.getTime();
        double arrivalInterval = generateNextArrivalInterval();
        double arrivalTime = currentTime + arrivalInterval;

        Event newEvent = new Event(eventType, arrivalTime);
        eventList.add(newEvent);

        // Update clock to new event time
        clock.setTime(arrivalTime);
    }
}

// Test program
class ArrivalProcessTest {
    public static void main(String[] args) {
        // Create clock
        Clock clock = Clock.getInstance();
        clock.setTime(0.0);

        // Create event list
        EventList eventList = new EventList();

        // Create arrival process (lambda = 0.1 means average 10 time units between arrivals)
        ArrivalProcess arrivalProcess = new ArrivalProcess(EventType.ARRIVAL, 0.1);

        // Generate 10 arrival events
        System.out.println("Generating 10 arrival events:");
        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextEvent(eventList);
            System.out.println("Event " + (i+1) + " scheduled at time: " + clock.getTime());
        }

        System.out.println("\nFinal clock time: " + clock.getTime());
        System.out.println("Total events in list: " + eventList.size());
    }
}
