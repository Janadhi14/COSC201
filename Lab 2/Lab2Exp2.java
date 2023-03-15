package cosc201.lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayLists;
import cosc201.unionfind.UF1;
import cosc201.unionfind.UnionFind;
import java.util.*;

/**
 * Lab 2, Experiment 2
 * 
 * Write a shell that can read union-find instructions and execute them.
 * This allows you to compare the behaviour of the various UF algorithms.
 * 
 * @author Michael Albert
 */
public class Lab2Exp2 {

  static Scanner in;
  static UnionFind uf = new UF1();

  public static void main(String[] args) {
    try{
      in = new Scanner(new File(args[0]));
    } catch (FileNotFoundException e) {
      System.out.println(e);
      System.exit(1);
    }

    String line = in.nextLine();
    int n = Integer.parseInt(line);
    uf.make(n);
    while (in.hasNextLine()) {
      process(in.nextLine());
    }


  }

  // Skeleton code below - the first block is complete, fill in the remainder similarly.
  private static void process(String line) {
    String[] tokens = line.split("\\s");
    String command = tokens[0];

    if (command.equals("Union")) {
      System.out.println(line);
      uf.union(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
      return;
    }

    if (command.equals("Find")) {
      // will need to call the find method and pass in the values 
      System.out.print("Find " + tokens[1] + " " + tokens[2]);
      System.out.print(": " + uf.find(Integer.parseInt(tokens[1])));
      // this will call the find method on the array 
      return;
      
    }
    // all method
    
    if (command.equals("All")) {
      // this will print out all teh values that are in teh group 0
      System.out.print("All: " + tokens[1] );
      for(int i: uf.reps){
        if(uf.reps[i] == Integer.parseInt(tokens[1])){
          // printing out the position
          System.out.print(i + " ");
        }
      }
      return;
    }

 // a method which will print out the numbers 
/* (Stretch goal) Echo the input, followed by a sequence of lines containing each of the sets exactly once (and each in increasing order). Ideally,
the set containing 0 should be printed first, then the set containing the smallest element not in 0’s set, and so on */
    
if (command.equals("Summary")) {
  ArrayList<Integer> seen = new ArrayList<>();
  // Now we have to go through a for loop through the reps array
  for (int i = 0; i < uf.reps.length; i++) {
      int r = uf.find(i);
      if (!seen.contains(r)) { // this will check that the item is not already in there
          // We want to add r to seen ArrayList
          seen.add(r);
      }
  }
  // Created new ArrayList, that is sorted
  Collections.sort(seen);
  // Created new array that is going to be the sorted array
  Integer[] sortedSeenArray = seen.toArray(new Integer[0]);

  // Now we are going to use the values in the arraylist to call all on
  System.out.println("Summary: ");
  for (int i = 0; i < sortedSeenArray.length; i++) {
    // If the seen sorted array at the given position then we are going to go through a for loop which will print out the values that are in that group
    // Printing out the position
    System.out.println(uf.find(sortedSeenArray[i]) + " ");
    }
  }
  return;
}

  }




// expected output 
/*If the input file is:
5
Union 2 3
Union 1 4
Find 1
Union 4 0
All 0
Find 4
Summary

Then the output could be (some might depend on the exact choice of algorithm or
implementation in union-find):

Size 5
Union 2 3
Union 1 4
Find 1: 4
Union 4 0
All 0: 0 1 4
Find 4: 0
Summary
0 1 4
2 3 
*/

