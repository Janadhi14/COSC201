package a2;
import java.util.*;
import a2.Potionmaster;
import java.util.Collections;

public class StandardSam extends Potionmaster{
// constructor and using super becase we are in the subclass of potionMaster which already has potionarium in its constructor 
   public StandardSam(Potionarium potionarium){
      super(potionarium);
   }
   // need to override the method from potionMaster class
@Override
public String collectIngredients(List<String> ingredients){
   /*Sam starts with a potion recipe: a list (without duplicates) of ingredients that are needed
to brew a potion so we need to implement this in java through*/
   List<String> ingredientsMissing = new ArrayList<>();
   Map<Long, List<String>> usedDrawers = new HashMap<>();
   // need to verify that we are able to get these ingredients from the drawers 
   // for loop and check each ingredient is there
   for(String ingredient: ingredients){ 
      Set<Long> drawers = potionarium.getDrawers(ingredient); // going through and getting the ingredients 
      // need to also check if the drawers are empty 
      if(drawers.isEmpty()){ // if true that is going to eman that the ingredinet sint present 
         ingredientsMissing.add(ingredient);

         
      }else { // else its not missing and we need to add to the }
      // need to use collections import to get the ingredients from teh lowest number drawer 
      long minDrawer = Collections.min(drawers); 
      potionarium.removeIngredient(minDrawer, ingredient); // collects the ingredient from the minDrawer

   }
   
}
   

}
}



