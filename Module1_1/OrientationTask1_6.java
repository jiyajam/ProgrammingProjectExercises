import java.util.LinkedList;

public class OrientationTask1_6 {

    static class Customer {
        private static int lastId = 0;
        private int id;
        private long startTime;
        private long endTime;

        public Customer() {
            lastId++;
            this.id = lastId;
            this.startTime = System.nanoTime();
        }

        public int getId() {
            return id;
        }

        public void setEndTime() {
            this.endTime = System.nanoTime();
        }

        public long getServiceTime() {
            return endTime - startTime;
        }
    }


    static class ServicePoint {
        private LinkedList<Customer> queue = new LinkedList<>();
        private long totalServiceTime = 0;

        public void addToQueueue(Customer c) {
            queue.addFirst(c);
        }

        public Customer removeFromQueueue() {
            return queue.removeLast();
        }

        public void serve() {
            while (!queue.isEmpty()) {
                Customer c = removeFromQueueue();


                int serviceTime = (int)(Math.random() * 2000) + 1000;
                try {
                    Thread.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                c.setEndTime();
                totalServiceTime += serviceTime;

                long responseTime = (c.getServiceTime() / 1_000_000) + serviceTime;
                System.out.println("Customer " + c.getId() + " served. Response time: " + responseTime + " ms, Service time: " + serviceTime + " ms");
            }


            int totalCustomers = Customer.lastId;
            double averageServiceTime = totalServiceTime / (double) totalCustomers;
            System.out.println("Average service time: " + averageServiceTime + " ms");
        }
    }


    static class CustomerGenerator {
        public void generateCustomers(int number, ServicePoint sp) {
            for (int i = 0; i < number; i++) {
                sp.addToQueueue(new Customer());
            }
        }
    }


    public static void main(String[] args) {
        ServicePoint sp = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator();

        generator.generateCustomers(5, sp);
        sp.serve();
    }
}
