package cosc201.a2;

import java.util.*; 

public class potionariumTestClass1{
    public static double milli = 1000000;
    public static void main(String[] args) {
        // Create an instance of the Potionarium class
        Potionarium potionarium;
        Timer t = new Timer();
        // Create different sizes for testing
        int[] sizes = {0, 20000, 40000, 60000, 80000, 100000, 120000, 140000, 160000, 180000, 200000};
        int trials = 100;

        for (int size : sizes) {
            long totalElapsedTime = 0;

            for (int trial = 0; trial < trials; trial++) {
                // Create a new Potionarium for each trial
                potionarium = new Potionarium();

                // Populate the Potionarium with the current size of ingredients
                for (int i = 0; i < size; i++) {
                    Set<String> ingredients = new HashSet<>();
                    ingredients.add("ingredient" + i);
                    potionarium.fillDrawer(i, ingredients);
                }

                // Record the start time
                t.start();

                // Run the getInventory method
                Set<String> inventory = potionarium.getInventory();

                // Record the end time
                t.stop();

                // Accumulate the elapsed time
                totalElapsedTime += t.getTime();
            }

            // Calculate and print the average elapsed time
            long averageElapsedTime = totalElapsedTime / trials;
            System.out.println( averageElapsedTime/milli);
        }
    }
}
