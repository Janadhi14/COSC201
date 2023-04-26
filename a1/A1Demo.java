package cosc201.a1;
import cosc201.utilities.*;
import cosc201.unionfind.*;
import cosc201.unionfind.UnionFind;

/**
 * A simple demo to show how the Puddles class works. It just initialises a list
 * of 5 puddles (or n if given a command-line argument), prints their positions
 * (Point2D defaults to two decimal places) and then prints the list of pairs of
 * puddles in sorted order of distance.
 */
public class A1Demo {
  public static final double milli = 1000000;
  /**
   * Runs (versions of) the demo
   * 
   * @param args optional number of puddles
   */
  public static void main(String[] args) {
    int n = 1000; // trying with 1000 as the max,10000 is too much java heap space
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
    }
    for (int trial = 0; trial < 100; trial++) {
      exp1(n);
    }
    // Timer t1 = new Timer();
    // // running 100 trials
    // double avgTime = 0.0;
    // for(int trial = 0; trial < 100; trial++) {
    //   // timeer start
    //   t1.start();//start timer  
    //   exp1(n);
    //   // stop
    //   System.out.println (  " " + t1.stop()/milli);
    // }


    // here we need a timer and time the merge order list 
  }

  public static void demo1(int n) {
    Puddles p = new Puddles(n);
    for (int i = 0; i < n; i++) {
      System.out.println(i + " " + p.getPoint(i));
    }
    System.out.println();
    for (int[] pair : p.mergeOrder()) {
      System.out.print(pair[0] + " " + pair[1] + " ");
      Point2D p0 = p.getPoint(pair[0]);
      Point2D p1 = p.getPoint(pair[1]);
      System.out.println(String.format("%.4f", p0.distance(p1)));
    }
  }

  public static void demo2(int n) {
    Puddles p = new Puddles(n);
    for (int i = 0; i < n; i++) {
      System.out.println(i + " " + p.getPoint(i));
    }
    System.out.println();
    UnionFind u = new UF3();
    u.make(n);
    int groups = u.groups();
    for (int[] pair : p.mergeOrder()) {
      System.out.print(pair[0] + " " + pair[1] + " ");
      Point2D p0 = p.getPoint(pair[0]);
      Point2D p1 = p.getPoint(pair[1]);
      System.out.print(String.format("%.4f", p0.distance(p1)));
      u.union(pair[0], pair[1]);
      if (u.groups() < groups) {
        System.out.println(" E");
        groups--;
      } else {
        System.out.println(" S");
        
      }
    }
  }
/*/
  public static void exp1(int n) {
    Puddles p = new Puddles(n);
     // for loop which will print out the coordinates 
    // for (int i = 0; i < n; i++) {
    //   System.out.println(i + " " + p.getPoint(i));
    // }
    // System.out.println();
    //UnionFind u = new UF1(); // Using unionfind 1 
    //UnionFind u = new UF2()  // Using unionfind 2
    UnionFind u = new UF3();  // Using unionfind 3
    //UnionFind u = new UF4();  // Using unionfind 4
   // generating the points 
    u.make(n); 
    int e = 0; // essential merge 
    int s = 0; // superflous merge 
    int groups = n;
    // merge order method call 
    // here we can start a timer 
    
    for (int[] pair : p.mergeOrder()) {
      // System.out.print(pair[0] + " " + pair[1] + " ");
      Point2D p0 = p.getPoint(pair[0]);
      Point2D p1 = p.getPoint(pair[1]);
      //System.out.print(String.format("%.4f", p0.distance(p1)));
      // carrying out the union operations until there is ony one pool left 
      //System.out.println(t1.stop());
      u.union(pair[0], pair[1]);
      if (u.groups() < groups) {
         //System.out.println(" E");
        e++; groups--;
      } else {
        s++;
        // System.out.println(" S" + s); 
      }
      // if there is one group left then break
      if (u.groups() == 1) break;
    }
    //System.out.println();
    //System.out.println(n + " " + e + " " + s);
  }
  */
  public static void exp1(int n) {
    UnionFind u = new UF4();
    u.make(n);
    Timer timer = new Timer();
    
    // Phase 1: Generating the points
    timer.start();
    Puddles p = new Puddles(n);
    long phase1Time = timer.stop();
    
    // Phase 2: Generating the merge-ordering list
    timer.start();
    Iterable<int[]> mergeOrder = p.mergeOrder();
    long phase2Time = timer.stop();

    // Phase 3: Carrying out the union operations
    
    int e = 0;
    int s = 0;
    int groups = n;
    timer.start();
    for (int[] pair : mergeOrder) {
      Point2D p0 = p.getPoint(pair[0]);
      Point2D p1 = p.getPoint(pair[1]);
      u.union(pair[0], pair[1]);
      if (u.groups() < groups) {
        e++; groups--;
      } else {
        s++;
      }
      if (u.groups() == 1) break;
    }

    long phase3Time = timer.stop();

    System.out.println(phase1Time/milli + " " + phase2Time/milli + " " +  phase3Time/milli + " ");
   
    //System.out.println(n + " " + e + " " + s);
  }
  

}


