
public class Clock {
    private static Clock instance = null;
    private double time;

    // Private constructor prevents external instantiation
    private Clock() {
        this.time = 0.0;
    }

    // Static method to get single instance
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    // Method to set time
    public void setTime(double newTime) {
        this.time = newTime;
    }

    // Method to get current time
    public double getTime() {
        return this.time;
    }

    // Method to advance time
    public void advanceTime(double increment) {
        this.time += increment;
    }
}

// Test program
class ClockTest {
    public static void main(String[] args) {
        // Get clock instance
        Clock clock = Clock.getInstance();

        System.out.println("Initial time: " + clock.getTime());

        // Set time
        clock.setTime(10.5);
        System.out.println("Time after setting: " + clock.getTime());

        // Advance time
        clock.advanceTime(5.0);
        System.out.println("Time after advancing: " + clock.getTime());

        // Test that it's truly singleton
        Clock clock2 = Clock.getInstance();
        System.out.println("Second reference time: " + clock2.getTime());
        System.out.println("Same instance? " + (clock == clock2));
    }
}
