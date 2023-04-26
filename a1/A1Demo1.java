package cosc201.a1;
import cosc201.utilities.*;
import cosc201.unionfind.*;
import cosc201.unionfind.UnionFind;

import java.util.List;

public class A1Demo1 {
  public static final double milli = 1000000;
  public static final int trials = 100;

  public static void main(String[] args) {
    int[] n_values = {50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000,1100, 1200, 1300, 1400, 1500000};

    System.out.println("n\tAvg Phase 1 (ms)\tAvg Phase 2 (ms)\tAvg Phase 3 (ms)");

    for (int n : n_values) {
      double totalPhase1Time = 0.0;
      double totalPhase2Time = 0.0;
      double totalPhase3Time = 0.0;

      for (int trial = 0; trial < trials; trial++) {
        // Phase 1: Generating the points
        Timer t1 = new Timer();
        t1.start();
        Puddles p = new Puddles(n);
        totalPhase1Time += t1.stop() / milli;

        // // Phase 2: Generating the merge-ordering list
        // t1.start();
        // List<int[]> mergeOrder = generateMergeOrdering(p);
        // totalPhase2Time += t1.stop() / milli;

        // // Phase 3: Carrying out the union operations
        // UnionFind u = new UF4();
        // u.make(n);
        // t1.start();
        // int[] mergeResults = performUnionOperations(p, u, n);
        // totalPhase3Time += t1.stop() / milli;
      }

      double avgPhase1Time = totalPhase1Time / trials;
      double avgPhase2Time = totalPhase2Time / trials;
      double avgPhase3Time = totalPhase3Time / trials;

      System.out.println(n + "\t" + avgPhase1Time + "\t" + avgPhase2Time + "\t" + avgPhase3Time);
    }
  }

  public static List<int[]> generateMergeOrdering(Puddles p) {
    return p.mergeOrder();
  }

  public static int[] performUnionOperations(Puddles p, UnionFind u, int n) {
    int e = 0; // essential merge
    int s = 0; // superfluous merge
    int groups = n;

    for (int[] pair : p.mergeOrder()) {
      Point2D p0 = p.getPoint(pair[0]);
      Point2D p1 = p.getPoint(pair[1]);
      u.union(pair[0], pair[1]);
      if (u.groups() < groups) {
        e++;
        groups--;
      } else {
        s++;
      }
      if (u.groups() == 1) break;
    }

    return new int[] {e, s};
  }
}
