package cosc201.a2;

import java.util.Set;
import java.util.HashSet;

public class potionariumTestClass5 {
  
  public static void main(String[] args) {
    // Create a new Potionarium
    Potionarium potionarium = new Potionarium();
    
    // Create a set of drawers
    long[] drawers = {1, 2, 3, 4, 5};
    
    // Test with different numbers of ingredients
    int[] numbersOfIngredients = {10, 100, 1000, 10000, 1000000};
    
    for (int n : numbersOfIngredients) {
      // Create a set of ingredients
      Set<String> ingredients = new HashSet<>();
      for (int i = 0; i < n; i++) {
        ingredients.add("Ingredient" + i);
      }
      
      // Test adding ingredients to each drawer
      for (long drawer : drawers) {
        // Get start time
        long startTime = System.currentTimeMillis();
        
        // Add ingredients
        for (String ingredient : ingredients) {
          potionarium.addIngredient(drawer, ingredient);
        }
        
        // Get end time
        long endTime = System.currentTimeMillis();
        
        // Calculate and print elapsed time
        long elapsedTime = endTime - startTime;
        System.out.println("Time to add " + n + " ingredients to drawer " + drawer + ": " + elapsedTime + " ms");
      }
    }
  }
}
