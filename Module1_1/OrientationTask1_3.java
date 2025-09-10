public class OrientationTask1_3 {

    static class Customer {
        private static int nextId = 1;
        private int id;
        private long startTime;
        private long endTime;


        public Customer() {
            this.id = nextId++;
            this.startTime = System.nanoTime();
        }


        public void setEndTime() {
            this.endTime = System.nanoTime();
        }


        public long getTimeSpent() {
            return endTime - startTime;
        }

        public int getId() {
            return id;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Customer customer1 = new Customer();
        Thread.sleep(1000);
        customer1.setEndTime();

        Customer customer2 = new Customer();
        Thread.sleep(1500);
        customer2.setEndTime();


        System.out.println("Customer " + customer1.getId() + " spent " + customer1.getTimeSpent() + " ns");
        System.out.println("Customer " + customer2.getId() + " spent " + customer2.getTimeSpent() + " ns");
    }
}
