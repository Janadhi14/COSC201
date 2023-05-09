package cosc201.a2;

import java.util.*; 

public class potionariumTestClass2 {
    public static double milli = 1000000;
    public static void main(String[] args) {
        Potionarium potionarium;
        Timer t = new Timer();
        int[] sizes = {0, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000};

        int trials = 100;

        for (int size : sizes) {
            long totalElapsedTime = 0;

            for (int trial = 0; trial < trials; trial++) {
                potionarium = new Potionarium();
                String ingredient = "ingredient";

                // Add the same ingredient to multiple drawers
                for (long i = 0; i < size; i++) {
                    Set<String> ingredients = new HashSet<>();
                    ingredients.add(ingredient);
                    potionarium.fillDrawer(i, ingredients);
                }

                t.start();

                // Run the getDrawers method for the ingredient
                Set<Long> drawers = potionarium.getDrawers(ingredient);

                t.stop();

                totalElapsedTime += t.getTime();
            }

            long averageElapsedTime = totalElapsedTime / trials;
            System.out.println(averageElapsedTime / milli);
        }
    }
}
