package cosc201.a2;

import java.util.*;

public class StandardSamTestClass {

    public static void main(String[] args) {

        // Create a Potionarium object
        Potionarium Cabinet = new Potionarium();

        // Add some ingredients to the Potionarium for testing
        Set<String> ingredientsList1 = new HashSet<>(Arrays.asList("ingredient1", "ingredient5", "ingredient3"));
        Set<String> ingredientsList2 = new HashSet<>(Arrays.asList("ingredient2", "fasdfas", "ingredient3"));

        Cabinet.fillDrawer(1, ingredientsList1);
        Cabinet.fillDrawer(2, ingredientsList2);


        System.out.println(Cabinet.getInventory());
        System.out.println(Cabinet.getDrawers("ingredient3")); // should return with [1,2] !!! works!!!1

        //Create a StandardSam obj
         StandardSam standardSam = new StandardSam(Cabinet);

    //     Testing with ingredients list 
        List<String> ingredientsList3 = Arrays.asList("ingredient1", "ingredient3", "ingredient2", "ingfrasdfedient3");
        String result1 = standardSam.collectIngredients(ingredientsList3);
        System.out.println("Case 1: All ingredients are available\n" + result1);

     }
}
