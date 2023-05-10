package cosc201.a2;

import java.util.*;

public class NovelNickTestClass {
    public static void main(String[] args) {
        // Create a Potionarium
        Potionarium potionarium = new Potionarium();

        // Add some drawers and ingredients to the Potionarium
        potionarium.addDrawer(1, Arrays.asList("Ingredient1", "Ingredient2"));
        potionarium.addDrawer(2, Arrays.asList("Ingredient3", "Ingredient4"));

        // Create a StandardSam
        NovelNic novelNic = new NovelNic(potionarium);

        // Define some ingredients
        List<String> ingredients = Arrays.asList("Ingredient1", "Ingredient2", "Ingredient3", "Ingredient4");

        // Call collectIngredients
        String result = NovelNic.collectIngredients(ingredients);

        // Print the result
        System.out.println(result);

        // Test with some missing ingredients
        ingredients = Arrays.asList("Ingredient1", "Ingredient5", "Ingredient6");
        result = standardSam.collectIngredients(ingredients);
        System.out.println(result);
    }
}
