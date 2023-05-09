package cosc201.a2;

import java.util.*; 

public class potionariumTestClass3 {
    public static double milli = 1000000;
    public static void main(String[] args) {
        Potionarium potionarium;
        Timer t = new Timer();
        int[] sizes = {0, 20000, 40000, 60000, 80000, 100000, 120000, 140000, 160000, 180000, 200000};

        int trials = 100;

        for (int size : sizes) {
            long totalElapsedTime = 0;

            for (int trial = 0; trial < trials; trial++) {
                potionarium = new Potionarium();

                // Populate a single drawer with a varying number of ingredients
                Set<String> ingredients = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    ingredients.add("ingredient" + i);
                }
                potionarium.fillDrawer(1, ingredients);  // always filling drawer number 1

                t.start();

                // Run the getIngredients method for the filled drawer
                Set<String> ingredientsInDrawer = potionarium.getIngredients(1);

                t.stop();

                totalElapsedTime += t.getTime();
            }

            long averageElapsedTime = totalElapsedTime / trials;
            System.out.println(averageElapsedTime / milli);
        }
    }
}
