package cosc201.demo;

/**
 * Code developed in the first COSC201 tutorial towards the problems:
 * 
 * (A) Input is a positive integer n. Output is to be an interleaved
 * sequence of the form 1, n, 2, n-1, 3, ..., n, 1 with one item per line.
 * 
 * And the modified version, (B), where we want to stop the output just before
 * we would repeata value.
 * 
 * Note that this (and other example-labelled code) is explicitly not
 * production-ready. Indeed it may contain bugs - it's the ideas that
 * we discussed as it was written that are more important.
 */
public class Tut1Example {

  // Note many variations of "doIt" below (labelled appropriately for the problem)
  public static void main(String[] args) {

    int n = Integer.parseInt(args[0]);
    doItB5(n); // Change here for other versions of the problem
    System.out.println("That was fun");

  }

  public static void doItA1(int n) {
    // Count up from 1 to n and down from n to 1 in lines
    int hi = n;
    for (int i = 1; i <= n; i++) {
      System.out.println(i);
      System.out.println(hi--);
    }
  }

  public static void doItA2(int n) {
    // Count up from 1 to n and down from n to 1 in lines
    for (int i = 1; i <= n; i++) {
      System.out.println(i);
      System.out.println(n + 1 - i); // Need to do the math to make sure this is right
    }
  }

  // This version has a bug
  public static void doItB1(int n) {
    for (int i = 1; i <= n; i++) {
      System.out.println(i);
      System.out.println(n--);
    }
  }

  // This version is correct, but I worry that it's hard to understand.
  public static void doItB2(int n) {
    for (int i = 1; i <= n; i++) {
      System.out.println(i);
      if (i < n) {
        System.out.println(n);
      }
      n--;
    }
  }

  public static void doItB3(int n) {
    int low = 1;
    int high = n;
    while (low < high) {
      System.out.println(low);
      System.out.println(high);
      low++;
      high--;
    }
    if (low == high) {
      System.out.println(low);
    }
  }

  // The last version suggests a two-parameter view of the problem: count up from
  // low and down
  // from high in parallel until they meet.

  public static void doItB4(int n) {
    doItBBounds(1, n);
  }

  public static void doItBBounds(int low, int high) {
    while (low < high) {
      System.out.println(low);
      System.out.println(high);
      low++;
      high--;
    }
    if (low == high) {
      System.out.println(low);
    }
  }

  // One we didn't consider - more arithmetic based

  public static void doItB5(int n) {
    for (int i = 1; i <= n / 2; i++) {
      System.out.println(i);
      System.out.println(n + 1 - i);
    }
    if (n % 2 != 0) {
      System.out.println(1 + n / 2);
    }
  }

  // A challenge: do it recursively.

}
