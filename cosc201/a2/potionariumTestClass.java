package cosc201.a2;


import java.util.*;

public class potionariumTestClass {

    private static final Random RANDOM = new Random();
    public static int numTrials = 100;
    public static final double milli = 1000000;
    public static final int numDrawers = 1000;

    // variables that will be changed 
    public static int numIngredientsToFind = 2000;
    public static int numIngredients = 1000000;
    public static int numIngredientsPerDrawer = 100;


    public static void main(String[] args) {
        // Create a Potionarium object
        Potionarium potionarium = new Potionarium();

        // Populate the Potionarium with random ingredients
        populatePotionarium(potionarium, numIngredients, numIngredientsPerDrawer);

        // Perform trials and record time to get inventory
        long totalDuration = 0;
        Timer t  = new Timer();
        for (int i = 0; i < numTrials; i++) {
            t.start();
            potionarium.getInventory();
            t.stop();
            totalDuration += t.getTime();
        }
        // Create a list of 10 ingredients that are all present in the Potionarium (needs to be random though)
        List<String> ingredientsToCollect = new ArrayList<>(potionarium.getInventory());
        Collections.shuffle(ingredientsToCollect); // this is making it random
        ingredientsToCollect = ingredientsToCollect.subList(0, 10);
        System.out.println("Ingredients to Collect:");
        System.out.println(ingredientsToCollect);
        
        // Calculate and print average time
        long averageDuration = totalDuration / numTrials;
        System.out.println((averageDuration/milli));

        
    }
// method for generaitng random ingredients 
    private static String generateRandomIngredient() {
        int length = 5 + RANDOM.nextInt(6);
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + RANDOM.nextInt(26));
            sb.append(c);
        }

        return sb.toString();
    }

    private static void populatePotionarium(Potionarium potionarium, int numIngredients, int numIngredientsPerDrawer) {
        for (int i = 0; i < numIngredients; i++) {
            Set<String> ingredientsList = new HashSet<>();
            for (int j = 0; j < numIngredientsPerDrawer; j++) {
                ingredientsList.add(generateRandomIngredient());
            }
            potionarium.fillDrawer(RANDOM.nextInt(numDrawers), ingredientsList);
        }
    }
}
