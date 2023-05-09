package cosc201.a2;

import java.util.*; 

public class potionariumTestClass5b {
    public static double milli = 1000000;
    public static void main(String[] args) {
        Potionarium potionarium;
        Timer t = new Timer();
        //int[] sizes = 20000, 40000, 60000, 80000, 100000, 120000, 140000, 160000, 180000, 200000};
        int [] sizes = {4000};
        int trials = 100; // Set number of trials. 

        for (int size : sizes) {
            long totalElapsedTime = 0;

            for (int trial = 0; trial < trials; trial++) {
                potionarium = new Potionarium();
                long totalTrialTime = 0;
                
                // Run the addIngredient method for each ingredient
                for (int i = 0; i < size; i++) {
                    t.start();
                    potionarium.addIngredient(i, "ingredient" + i);
                    ; // Time for each addition is accumulated for a trial
                    t.stop();
                    System.out.println(t.getTime());
                }
                
                totalElapsedTime += totalTrialTime; // Total time for a trial is accumulated for all trials
            }

            //  double averageElapsedTime = (double) totalElapsedTime / trials; // Average time for all trials
            //  System.out.println("Average time for size " + size + ": " + averageElapsedTime / milli + " ms");
        }
    }
}
