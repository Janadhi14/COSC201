package cosc201.a1;

// A simple demo to show how the Puddles class works. It just initialises a list
// of 5 puddles (or n if given a command-line argument), prints their positions
// (Point2D defaults to two decimal places) and then prints the list of pairs of
// puddles in sorted order of distance.

public class A1Demo {

  public static void main(String[] args) {
    int n = 5;
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
    }
    Puddles p = new Puddles(n);
    for(int i = 0; i < n; i++) {
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
  
}
