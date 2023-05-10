package cosc201.a2;

import java.util.*;

public class TestNovelNic {
    public static void main(String[] args) {
        // Create a Potionarium
        Potionarium potionarium = new Potionarium();

        // Add some drawers and ingredients to the Potionarium
        potionarium.fillDrawer(0L, new HashSet<>(Arrays.asList("eon", "she", "tof")));
        potionarium.fillDrawer(13L, new HashSet<>(Arrays.asList("abc")));
        potionarium.fillDrawer(42L, new HashSet<>(Arrays.asList("eon", "foa")));

        // Create a NovelNic
        NovelNic novelNic = new NovelNic(potionarium);

        // Define some ingredients
        List<String> ingredients1 = Arrays.asList("eon", "xxx", "abc", "xyz");
        List<String> ingredients2 = Arrays.asList("eon", "abc", "foa");

        // Test the collectIngredients method
        System.out.println("Test with ingredients: " + ingredients1);
        String result1 = novelNic.collectIngredients(ingredients1);
        System.out.println("Result: " + result1);
        System.out.println();

        System.out.println("Test with ingredients: " + ingredients2);
        String result2 = novelNic.collectIngredients(ingredients2);
        System.out.println("Result: " + result2);
    }
}
