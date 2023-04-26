package cosc201.a1;
import cosc201.utilities.*;
import cosc201.unionfind.*;
import cosc201.unionfind.UnionFind;

import java.util.List;

public class A1Demo2 {
  public static final double milli = 1000000;

  public static void main(String[] args) {
    int[] n_values = {100, 500, 1000, 5000, 10000}; // Adjust these values according to your system's capabilities

    for (int n : n_values) {

      UnionFind u = new UF1(); 

      // Phase 1: Generating points
      // this is going to be linear 
      Timer t1 = new Timer();
      t1.start();
      Puddles p = new Puddles(n);
      double phase1Time = t1.stop() / milli;
      System.out.println(phase1Time); ;

      // Phase 2: creating the merge-ordering list
      t1.start();
      List<int[]> mergeOrder = generateMergeOrdering(p);
      double phase2Time = t1.stop() / milli;
      System.out.println(phase2Time);

      //Phase 3: Carrying out the union ops
      u.make(n);
      t1.start();
      int[] mergeResults = performUnionOperations(p, u, n);
      double phase3Time = t1.stop() / milli;
      System.out.println( phase3Time);

      System.out.println();
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
