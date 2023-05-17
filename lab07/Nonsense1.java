package lab07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Nonsense1 {

  static final char END_OF_WORD = '$';
  private static final Random R = new Random();
  static StringBuilder firstLetters = new StringBuilder();
  static HashMap<String, StringBuilder> followingLetters = new HashMap<>();

  static {
    try {
      Scanner in = new Scanner(new File("/Users/janadhi/Computer Science/COSC201/lab07/words.txt"));
      for(char c1 = 'a'; c1 <= 'z'; c1++) {
        for (char c2 = 'a'; c2 <= 'z'; c2++) { // need inner and outer loops this time becase we are going to populate using both pairs of char
          followingLetters.put("" + c1 + c2, new StringBuilder());
        }
      }
      while(in.hasNextLine()) {
        String word = in.nextLine();
        if(word.length() >= 2) { 
          firstLetters.append(word.substring(0, 2));
          updateFollowing(word);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
// updatefollwing method for pairs of char
  private static void updateFollowing(String word) {
    //loops from the first character to the third last character. 
    //This is because it's now considering pairs of characters instead of single characters.
    for(int i = 0; i < word.length() - 2; i++) {
      String key = word.substring(i, i + 2);
      char n = word.charAt(i + 2);
      followingLetters.get(key).append(n);
    }
    if(word.length() >= 2) {
      String lastPair = word.substring(word.length() - 2);
      followingLetters.get(lastPair).append(END_OF_WORD);
    }
  }
// new method for random word generating
  private static String randomWord() {
    StringBuilder result = new StringBuilder();
    // index variable to randomly select the starting point in the firstLetters
    int index = R.nextInt(firstLetters.length() / 2) * 2;
    String key = firstLetters.substring(index, index + 2);
    result.append(key);
    // While the word is not finished, pick a next letter and append it to the result
    char c;// create a char variable we can use within the do while loop for the next char to append 
      // The do-while loop continues until we append the end of word character ('$')
    do {
      StringBuilder afterKey = followingLetters.get(key); // need to get the corresponding 2 character combinaton
      c = afterKey.charAt(R.nextInt(afterKey.length()));
      result.append(c); // append c to the result 
      key = key.charAt(1) + String.valueOf(c);
    } while (c != END_OF_WORD);  // when we reach $ we will break out of the loop
//
    result.deleteCharAt(result.length() - 1); // Trims the end of word character from end.
    return result.toString(); // returning the string representaiton of the new randomword 
  }

  private static String randomString(int length) {
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < length; i++) {
      result.append((char) ('a' + R.nextInt(26)));
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println("Fully random 6 character strings");
    for(int i = 0; i < 10; i++) System.out.println(randomString(6));
    System.out.println();
    System.out.println("Random words");
    for(int i = 0; i < 10; i++) System.out.println(randomWord());
  }
}
