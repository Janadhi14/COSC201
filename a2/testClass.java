package cosc201.a2;

import java.util.*;

public class testClass{

    public static void main(String[] args){
        // need to call potioinarium
        Potionarium potionarium = new Potionarium();
        
        Set<String> ingredients1 = new HashSet<>(Arrays.asList("ingredient1", "ingredient2", "ingredient3"));
        System.out.println("Fill drawer 1: " + potionarium.fillDrawer(1, ingredients1)); // Expected output: true
        
    }
}