package cosc201.lab06;

import java.util.HashSet; // Import the HashSet class
import java.util.Random;
import java.util.Set;

public class lab06pt1 {
    public static void main(String[] args){
        char[] c = {'A', 'B', 'C', 'D', 'E'};
        int n = 10;
        String randomString = generateString(c, n);
        System.out.println(randomString);
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
    }




