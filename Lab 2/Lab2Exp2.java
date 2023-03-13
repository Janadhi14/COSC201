package cosc201.lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
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
      System.out.println();
      uf.find(Integer.parseInt(token[1]));
      // this will call the find method on the array 
      return;
    
    }
    // all method
    
    if (command.equals("All")) {
      // this will return all the different groups that are there 
      // need to take in the integer value and print  out all the values within the the group
      // need to go through the reps array and check if 
      System.out.print("All: " + token[1] );
      for(int x: uf.reps){
        if(uf.reps[x] == Integer.parseInt(token[1])){
          // printing out the position
          System.out.print(x + " ");
        }
   // else nothing       
      }
      return;
      
    }
    // a method which will print out the numbers 
    /* (Stretch goal) Echo the input, followed by a sequence of lines containing each of the sets exactly once (and each in increasing order). Ideally,
the set containing 0 should be printed first, then the set containing the smallest element not in 0’s set, and so on */
    if (command.equals("Summary")) {
      /*Summary:
Initialise an empty arraylist "seen"
(for the representatives that have been seen)
for i from 0 to n-1:
Let r = find(i)
if r is not in seen:
Add r to seen
Print All(i)*/
//create an arraylist of integers called seen which will only contain the representatives 
ArrayList<Integer> seen  = new ArrayList<>();

      // now we have to go through a for loop through the reps array 
      for(int i = 0; i < uf.reps.length-1; i++){
        int r = find(i);
        if(!seen.contains(r)){ // this will check that the item is in there
          // we want to add r to seen arraylist
          seen.add(r);
        }
        // now we want to print out the values 
        // we want to for loop through and print the smallest number  
        
        

      }
      // now we wnat to go through and print the indexs of the representatives from smallest to largest 
      
      for(int nums: Collections.sort(seen)){
        System.out.println((nums));
      };
      return;
    }
  }

}
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

