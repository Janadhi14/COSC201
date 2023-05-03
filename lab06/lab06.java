package cosc201.lab06;

import java.util.HashSet; // Import the HashSet class
import java.util.Random;
import java.util.Set;

public class lab06 {
    public static void main(String[] args){
        
        char[] c = {'A', 'B', 'C', 'D', 'E'};
        int n = 3000;
        String randomString = generateString(c, n);
        //System.out.println("Generated String: " + randomString);

        Set<String> substrings = calculateDistinctSubstrings(randomString);
        System.out.println("Actual number of distinct substrings: " + substrings.size());

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




