package cosc201.a2;

//import utilities.Timer;
import java.util.*;

public class potionariumTestClass {

    private static final Random RANDOM = new Random();
    public static int numIngredients = 10;
    public static int numIngredientsPerDrawer = 100; // number of drawers doesnt matter 
    public static int numTrials = 100;
    public static int numIngredientsToFind = 100;


    public static void main(String[] args) {
        // Create a Potionarium object
        Potionarium potionarium = new Potionarium();
        
        Timer t  = new Timer();

        // Add 100 random ingredients to the Potionarium for testing
        for (int i = 0; i < numIngredients; i++) {
            Set<String> ingredientsList = new HashSet<>(Collections.singletonList(generateRandomIngredient()));
            potionarium.fillDrawer(RANDOM.nextInt(1000), ingredientsList);
        }

        System.out.println("Cabinet Inventory:");
        System.out.println(potionarium.getInventory());

        // Create a list of 10 ingredients that are all present in the Potionarium (needs to be random though)
        List<String> ingredientsToCollect = new ArrayList<>(potionarium.getInventory());
        Collections.shuffle(ingredientsToCollect); // this is making it random
        ingredientsToCollect = ingredientsToCollect.subList(0, 10);
        System.out.println("Ingredients to Collect:");
        System.out.println(ingredientsToCollect);
        
        StandardSam standardSam = new StandardSam(potionarium);

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
