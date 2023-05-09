package cosc201.a2;

import java.util.*;

public class potionariumTestClass6 {
    public static double milli = 1000000;
    public static void main(String[] args) {
        Potionarium potionarium;
        Timer t = new Timer();
        int[] sizes = { 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000};

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
        
                // Repeat the operation many times and measure the total time
                for (int i = 0; i < size; i++) {
                    // Record the start time
                    t.start();
        
                    // Run the removeIngredient method
                    potionarium.removeIngredient(i, "ingredient" + i);
        
                    // Record the end time
                    t.stop();
        
                    // Accumulate the elapsed time
                    totalElapsedTime += t.getTime();
                }
            }
        
            // Calculate and print the average elapsed time
            long averageElapsedTime = totalElapsedTime / (trials * size);
            System.out.println( size  + ", " + averageElapsedTime/milli);
        }
    }
}