
import java.util.Random;

/**
 * Lab 1, Experiment 1
 * 
 * a. What is the (typical) ratio between the time taken for sum(1000) 
 *    and sum(100)? Does that make sense? What \textit{should} the ratio be?
 * // the sum for 1000 takes over 6 times as much but it should be 10 beacuse the for loop is a O(n) function
 * // if we multiply by 10 we should see a proportional change in the time taken for sum1000
 * b. How large do you need to make $n$ before the ratio between the time 
 *    taken for sum(10*n) and sum(n) approaches what it should be? When you
 *    reach that point, how much total time (roughly) is being used?
 *  	 
 * 
 * c. What does this say about the design of wall-clock experiments to test 
 *    efficiency?
 * 
 * @author Michael Albert
 */
public class Lab1Exp1 {
  static final double milli = 1000000;
  static final Random R = new Random();
  
  public static void main(String[] args) {
    // Add some code here that evaluates and times sum(n) and sum(10*n) for 
    // (various) n so that you can answer the questions above.
    Timer t1  = new Timer();

    t1.start();
    sum(100); // this should return the time it takes to add 100 numbers together so n = 100
    t1.stop();
   
    // creating a new timer for the sum1000
    Timer t2 =  new Timer(); 
    
    t2.start();
    sum(3000);
    t2.stop();

    double t2timer  = t2.getTime();  
    double t1timer = t1.getTime();
    System.out.println((t2timer/t1timer));

    //timedSum(100.1);
  }
  
  // method that returns the n random double values using a simple for loop
  static double sum(int n) {
    double result = 0; 
    for(int i = 0; i < n; i++) result += R.nextDouble();
    return result;
  }
  
  static double timedSum(int n) {
    // It might be easier to wrap together the timing control and the sum
    // and just return the time taken. Up to you!
    return 0.0; // Just so that this compiles
  }
  
}
