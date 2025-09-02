import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class EventList {
    private PriorityQueue<Event> queue;

    public EventList() {
        queue = new PriorityQueue<>();
    }


    public void addEvent(Event event) {
        queue.add(event);
    }

    public Event getNextEvent() {
        return queue.poll();
    }


    public boolean isEmpty() {
        return queue.isEmpty();
    }


    public void printAllEventsInOrder() {
        // Copy the queue to a list and sort it
        List<Event> copy = new ArrayList<>(queue);
        copy.sort(null); // sort by compareTo()

        System.out.println("All remaining events in time order:");
        for (Event event : copy) {
            System.out.println(event);
        }
    }
}
