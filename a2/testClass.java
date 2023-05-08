package a2;

impory
import java.util.*;

public class testClass{

    public static void main(String[] args){
        // need to call potioinarium
        Potionarium j = new Potionarium();
        
        Set<String> ingredientsList = new HashSet<>(Arrays.asList("ingredient1", "ingredient2", "ingredient3"));
        System.out.println("Fill drawer 1: " + j.addIngredient(1, "a")); // Expected output: true
        System.out.println("Fill drawer 2: " + j.addIngredient(2, "b")); // Expected output: true
        System.out.println("Fill drawer 3: " + j.addIngredient(3, "c")); // Expected output: true
        System.out.println("Fill drawer 4: " + j.fillDrawer(4, ingredientsList)); // Expected output: true
        //System.out.println(potionarium.removeIngredient(1, "a")); // Expected output: false beacsue it is not in teh map
        System.out.println("jjjjjj drawers: " + j.getInventory()); 
        
       
    }
    }
