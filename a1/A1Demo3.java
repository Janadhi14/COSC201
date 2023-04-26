package cosc201.a1;
import cosc201.utilities.*;
import cosc201.unionfind.*;
import cosc201.unionfind.UnionFind;

public class A1Demo3 {
  public static final double milli = 1000000;

  public static void main(String[] args) {
    int n = 500;
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
    }
    
    double avgPhase1Time = 0.0;
    double avgPhase2Time = 0.0;
    double avgPhase3Time = 0.0;

    for (int trial = 0; trial < 10; trial++) {
      double[] phaseTimes = exp1(n);
      avgPhase1Time += phaseTimes[0];
      avgPhase2Time += phaseTimes[1];
      avgPhase3Time += phaseTimes[2];
    }

    avgPhase1Time /= 10;
    avgPhase2Time /= 10;
    avgPhase3Time /= 10;

    System.out.println( + avgPhase1Time );
    System.out.println( + avgPhase2Time);
    System.out.println( + avgPhase3Time);
  }

  // Other demo methods...

  public static double[] exp1(int n) {
    UnionFind u = new UF1();
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
    System.out.println(e + " " +s);

    PoolAnalyser analyser = new PoolAnalyser(u, p);
    double superfluousRatio = analyser.superfluousRatio();
    int lastEssentialMerge = analyser.lastEssentialMerge();// this method is right 
    //int countSuperflousRatio = analyser.countSuperfluousMerges();

   // System.out.println(superfluousRatio);
    //System.out.println(lastEssentialMerge);
    //System.out.println(countSuperflousRatio);


    double[] phaseTimes = new double[3];
    phaseTimes[0] = phase1Time / milli;
    phaseTimes[1] = phase2Time / milli;
    phaseTimes[2] = phase3Time / milli;
   
    return phaseTimes;
  }
  
  // Other methods...

}
