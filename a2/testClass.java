package a2;


import java.util.*;

public class testClass{

    public static void main(String[] args){
        // need to call potioinarium
        Potionarium j = new Potionarium();
        
        Set<String> ingredients1 = new HashSet<>(Arrays.asList("ingredient1", "ingredient2", "ingredient3"));
        System.out.println("Fill drawer 1: " + j.addIngredient(1, "jasdjfjsad")); // Expected output: true
        System.out.println("Fill drawer 1: " + j.addIngredient(1, "jasdjfjsad")); // Expected output: false becase it is already in the potion cabinet 

        System.out.println("jjjjjj drawer 1: " + j.getInventory());
        
    }
}