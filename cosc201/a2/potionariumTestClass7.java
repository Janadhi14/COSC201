package cosc201.a2;

import java.util.*;

public class potionariumTestClass7 {
    public static double milli = 1000000;
    public static void main(String[] args) {
        Potionarium potionarium;
        Timer t = new Timer();
        int[] sizes = {2000};

        int trials = 100;

        for (int size : sizes) {
            long totalElapsedTime = 0;
        
            for (int trial = 0; trial < trials; trial++) {
                // Create a new Potionarium for each trial
                potionarium = new Potionarium();
        
                // Populate the Potionarium with the current size of ingredients
                for (int i = 0; i < size; i++) {
                    Set<String> ingredients = new HashSet<>();
                    for (int j = 0; j < size; j++) {
                        ingredients.add("ingredient" + j);
                    }
                    potionarium.fillDrawer(i, ingredients);
                }
        
                // Repeat the operation many times and measure the total time
                for (int i = 0; i < size; i++) {
                    Set<String> ingredientsToRemove = new HashSet<>();
                    for (int j = 0; j < size; j++) {
                        ingredientsToRemove.add("ingredient" + j);
                    }
        
                    // Record the start time
                    t.start();
        
                    // Run the removeIngredients method
                    boolean result = potionarium.removeIngredients(i, ingredientsToRemove);
        
                    // Record the end time
                    t.stop();
        
                    // Accumulate the elapsed time
                    totalElapsedTime += t.getTime();
                }
            }
        
            // Calculate and print the average elapsed time
            long averageElapsedTime = totalElapsedTime / (trials * size);
            System.out.println( size + ", " +averageElapsedTime/milli);
        }
    }
}
