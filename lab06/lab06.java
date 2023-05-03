package cosc201.lab06;

import java.util.HashSet; // Import the HashSet class
import java.util.Random;
import java.util.Set;

public class lab06 {
    public static void main(String[] args){
        
        char[] c = {'A'   };
        int n = 600;
        int trials = 100;
        int totalDistinctSubstrings = 0;

        for (int i = 0; i < trials; i++) {
            String randomString = generateString(c, n);
            Set<String> substrings = calculateDistinctSubstrings(randomString);
            totalDistinctSubstrings += substrings.size();
        }

        double averageDistinctSubstrings = (double) totalDistinctSubstrings / trials;

        System.out.println("Average number of distinct substrings over " + trials + " trials: " + averageDistinctSubstrings);

        int theoreticalMax = 1 + n*(n + 1)/2;
        System.out.println("Theoretical maximum number of distinct substrings: " + theoreticalMax);
    }

    static String generateString(char[] c, int n) {
        StringBuilder sb = new StringBuilder(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(c.length);
            sb.append(c[index]);
        }
        return sb.toString();
    }

    static Set<String> calculateDistinctSubstrings(String s) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings;
    }

}