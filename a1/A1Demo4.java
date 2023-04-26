package cosc201.a1;
import cosc201.utilities.*;
import cosc201.unionfind.*;
import cosc201.unionfind.UnionFind;

public class A1Demo4 {
  public static final double milli = 1000000;

  public static void main(String[] args) {
    int n = 500;
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
    }
    
    double avgTimer = 0.0;
    // superflous ratio
    double avgSuperfluousRatio = 0.0;
    


    for (int trial = 0; trial < 10; trial++) {
      double[] phaseTimes = exp1(n);
      avgTimer += phaseTimes[0];
      avgSuperfluousRatio +=phaseTimes[1];
    }

    avgTimer /= 10;
    avgSuperfluousRatio /=10;

    System.out.println( avgTimer );
    System.out.println(avgSuperfluousRatio );
  }

  // Other demo methods...

  public static double[] exp1(int n) {
    UnionFind u = new UF4();
    u.make(n);
    Timer timer = new Timer();
    

    // Phase 1: Generating the points
    timer.start();
    Puddles p = new Puddles(n);
    
    
    // Phase 2: Generating the merge-ordering list
    
    Iterable<int[]> mergeOrder = p.mergeOrder();
    

    // Phase 3: Carrying out the union operations
    
    int e = 0;
    int s = 0;
    int groups = n;
 
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

    long avgTimer = timer.stop();
    
    PoolAnalyser analyser = new PoolAnalyser(u, p);
    double superfluousRatio = analyser.superfluousRatio();

    double[] phaseTimes = new double[3];
    phaseTimes[0] = avgTimer / milli;
    phaseTimes[1] = superfluousRatio;
  
   
    return phaseTimes;
  }
  
  // Other methods...

}
