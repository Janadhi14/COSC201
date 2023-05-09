package cosc201.a2;

import java.util.*; 

public class potionariumTestClass4 {
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

                Set<String> ingredients = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    ingredients.add("ingredient" + i);
                }

                t.start();

                // Run the fillDrawer method
                boolean filled = potionarium.fillDrawer(1, ingredients);

                t.stop();

                totalElapsedTime += t.getTime();
            }

            long averageElapsedTime = totalElapsedTime / trials;
            System.out.println(averageElapsedTime / milli);
        }
    }
}
