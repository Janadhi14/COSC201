package cosc201.a2;

import utilities.Timer;
import java.util.*;

public class testClass {

    private static final Random RANDOM = new Random();
    public static int numIngredients = 100;

    public static void main(String[] args) {
        Timer t = new Timer(); // creating a timer 
        // Create a Potionarium object
        Potionarium Cabinet = new Potionarium();
        
        // Add 100 random ingredients to the Potionarium for testing
        for (int i = 0; i < numIngredients; i++) {
            Set<String> ingredientsList = new HashSet<>(Collections.singletonList(generateRandomIngredient()));
            Cabinet.fillDrawer(RANDOM.nextInt(1000), ingredientsList);
        }

        System.out.println("Cabinet Inventory:");
        System.out.println(Cabinet.getInventory());

        // Create a list of 10 ingredients that are all present in the Potionarium
        List<String> ingredientsToCollect = new ArrayList<>(Cabinet.getInventory());
        Collections.shuffle(ingredientsToCollect);
        ingredientsToCollect = ingredientsToCollect.subList(0, 10);

        System.out.println("Ingredients to Collect:");
        System.out.println(ingredientsToCollect);

        // Create a StandardSam object
        StandardSam standardSam = new StandardSam(Cabinet);

        // Test the collectIngredients method with 10 ingredients that are all present
        String result1 = standardSam.collectIngredients(ingredientsToCollect);
        System.out.println("Case 1: All ingredients are available\n" + result1);
    }

    private static String generateRandomIngredient() {
        int length = 5 + RANDOM.nextInt(6);
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + RANDOM.nextInt(26));
            sb.append(c);
        }

        return sb.toString();
    }
}
