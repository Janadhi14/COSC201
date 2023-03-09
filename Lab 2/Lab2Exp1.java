
/**
 * Lab 2, Experiment 1
 * 
 * a. Look at the times required to compute fibRec(n) for various values of n.
 *    How do these times behave? How large a value of n can you (realistically)
 *    apply this method to?
 *  we are seeign an exponential increase in times taken and caps out at about n = 50 where we are getting a long time for the program to run 
 * 
 * b. Do the other implementations produce the same sequence of values? Aside
 *    from "running the code and checking" are you confident of this (based
 *     on reading the code)?
 * 
 * fibA seems to work okay as we are creating a new variable c which is the sum of a and b and then resetting the a and b to b and c respectivley 
 *
 * 
 * fibB works also well for larger values 
 * 
 * c. How large a value of n can you apply the other methods to in a
 *    reasonable length of time? What's the limiting condition? 
 * 
 * the limiting condition is the memory for fibA 
 * fibA can work for very large values but the method breaks down once we reach teh upper byte size for long n = 100000000
 * fibB where n =100000000 but any higher it will break beacsue this is the max space and we run out of memory 
 * fibC where n =  
 * fibC(a,b,c) where n  = 
 * d. Which of the other methods is "best"?
 * 
 * 
 * 
 * @author Michael Albert
 */
public class Lab2Exp1 {
  static final double milli = 1000000;
  public static void main(String[] args) {
    // Add your code for doing experiments here.
    int x = 100000000;
    Timer t = new Timer();
    
    System.out.println("The current fibonacci value " + fibB(x));
    t.start();
    //fibRec(x);
    //fibA(x);
    fibB(x);
    //fibC(x);
    //fibD(x);
    System.out.println("The time taken is "+ t.stop()/milli);


  }
   
// method fibRec will retunr the fibonacci for that number
  static long fibRec(int n) {
    if (n <= 1) return 1;
    return fibRec(n-1) + fibRec(n-2);
  }
 // method for fibA  
  static long fibA(int n) {
    long a = 1;
    long b = 1;
    // creating 2 variables that will be initilised to 1 and 1 origionally 
    //then we are going to go through a forloop
    for(int i = 0; i < n; i++) {
      long c = a + b;
      a = b;
      b = c;
    }
    // setting a equal to b and then be equal to c 
    return a;
  }
// method for fibB  
  static long fibB(int n) {
    long[] result = new long[n+1];
    result[0] = 1;
    result[1] = 1;
    for(int k = 2; k <= n; k++) {
      result[k] = result[k-1] + result[k-2];
    }
    return result[n];
  }
  
  static long fibC(int n) {
    return fibC(1, 1, n);
  }

  // method for fibC with overlaoding
  static long fibC(int a, int b, int n) {
    if (n == 0) return a;
    return fibC(b, a+b, n-1);
  }
  
}
