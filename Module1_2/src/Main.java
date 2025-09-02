public class Main {
    public static void main(String[] args) {

        EventList eventList = new EventList();


        eventList.addEvent(new Event(10, EventType.ARRIVAL));
        eventList.addEvent(new Event(5, EventType.EXIT));
        eventList.addEvent(new Event(15, EventType.ARRIVAL));

        Event nextEvent = eventList.getNextEvent();
        System.out.println("Next event to process:");
        System.out.println(nextEvent);


        eventList.printAllEventsInOrder();
    }
}
