package cosc201.a2;

import java.util.*;

public class potionariumTestClass6 {
    public static double milli = 1000000;
    public static void main(String[] args) {
        Potionarium potionarium;
        Timer t = new Timer();
        int[] sizes = {1, 20000, 40000, 60000, 80000, 100000, 120000, 140000, 160000, 180000, 200000};

        int trials = 100;

        for (int size : sizes) {
            long totalElapsedTime = 0;
        
            for (int trial = 0; trial < trials; trial++) {
                // Create a new Potionarium for each trial
                potionarium = new Potionarium();
        
                // Populate the Potionarium with the current size of ingredients
                for (int i = 0; i < size; i++) {
                    Set<String> ingredients = new HashSet<>();
                    t.start();
                    ingredients.add("ingredient" + i);
                    t.stop();
                    totalElapsedTime += t.getTime();
                    potionarium.fillDrawer(i, ingredients);
                    
                }
        
                // Repeat the operation many times and measure the total time
                for (int i = 0; i < size; i++) {
                    // Record the start time
                    
        
                    // Run the removeIngredient method
                    potionarium.removeIngredient(i, "ingredient" + i);
        
                    // Record the end time
                    
        
                    // Accumulate the elapsed time
                    
                }
            }
        
            // Calculate and print the average elapsed time
            long averageElapsedTime = totalElapsedTime / (trials * size);
            System.out.println( size  + ", " + averageElapsedTime/milli);
        }
    }
}