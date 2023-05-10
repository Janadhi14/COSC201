package cosc201.a2;

import java.util.*;

public class StandardSamTestClass {

    private static final Random RANDOM = new Random();
    public static int numIngredients = 1000000; //number of drawers doesn't matter
    public static int numIngredientsPerDrawer = 10000000; // number of drawers doesn't matter 
    public static int numTrials = 100; //doesnt matter 
    public static int numberofingredientsToCollect = 16000; // matters becasue this is the input 
    public static double milli = 1000000;


    public static void main(String[] args) {
        long totalDuration = 0;

        for (int trial = 0; trial < numTrials; trial++) {
            // Create a Potionarium object
            Potionarium potionarium = new Potionarium();
            Timer t  = new Timer();

            // Add 100 random ingredients to the Potionarium for testing
            for (int i = 0; i < numIngredients; i++) {
                Set<String> ingredientsList = new HashSet<>(Collections.singletonList(generateRandomIngredient()));
                potionarium.fillDrawer(RANDOM.nextInt(100000), ingredientsList);
            }

            // Create a list of 10 ingredients that are all present in the Potionarium (needs to be random though)
            List<String> ingredientsToCollect = new ArrayList<>(potionarium.getInventory());
            Collections.shuffle(ingredientsToCollect); // this is making it random
            ingredientsToCollect = ingredientsToCollect.subList(0, numberofingredientsToCollect);
            
            StandardSam standardSam = new StandardSam(potionarium);

            // Test the collectIngredients method with 10 ingredients that are all present
            t.start();
            String result1 = standardSam.collectIngredients(ingredientsToCollect);
            totalDuration += t.stop();
        }

        double averageDuration = (double) totalDuration / numTrials;
        System.out.println("Average time over " + numTrials + " trials: " + (averageDuration/milli));
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
