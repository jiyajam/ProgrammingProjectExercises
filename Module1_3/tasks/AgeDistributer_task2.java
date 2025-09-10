public class AgeDistributer_task2 {
    public static void main(String[] args) {
        final int ITERATIONS = 1000;
        final int MAX_AGE = 35;


        int ageDistribution[][] = {
                {16, 20},   // 16% - ages 20
                {34, 21},   // 18% - ages 21
                {52, 22},   // 18% - ages 22
                {68, 23},   // 16% - ages 23
                {82, 24},   // 14% - ages 24
                {89, 25},   // 7% - ages 25
                {94, 26},   // 5% - ages 26
                {96, 28},   // 2% - ages 28
                {98, 30},   // 2% - ages 30
                {100, MAX_AGE} // 2% - ages 35
        };

        int generatedAges[] = new int[MAX_AGE + 1];

        // Generate ages according to distribution
        for (int i = 1; i <= ITERATIONS; i++) {
            // Generate random number 1-100
            int randomNum = (int)(Math.random() * 100) + 1;

            // Find corresponding age
            int j = 0;
            while (randomNum > ageDistribution[j][0]) {
                j++;
            }

            // Increment count for this age
            generatedAges[ageDistribution[j][1]]++;
        }

        // Display results
        System.out.println("Age  Count    Percentage");
        System.out.println("-------------------------");
        for (int age = 0; age <= MAX_AGE; age++) {
            if (generatedAges[age] != 0) {
                double percentage = ((double)generatedAges[age] / ITERATIONS) * 100;
                System.out.printf("%-4d %-8d %.2f%%\n", age, generatedAges[age], percentage);
            }
        }
    }
}

