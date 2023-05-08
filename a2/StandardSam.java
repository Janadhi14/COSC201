package a2;
import java.util.*;


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

      // should kep track of ingredients that are being taken from drawers 
      // need to keep order of ingredients that are being removed, cant use HashSet() 
      // can use Array or arraylist but arraylist should be better becase the ingredient list is dynamic ?
      usedDrawers.putIfAbsent(minDrawer, new ArrayList<>());
      usedDrawers.get(drawer).add(ingredient);

      }
   }

// if there are missing ingredients we need to return the missing ingredients 
   if(!ingredientsMissing.isEmpty()) {
    String missingOrderList = ", " + ingredientsMissing;
    return "Missing ingredients: " + ingredientsMissing; // early returns the missing ingredients 

   }

   // if all the ingredients are present then we need to build a string that will return the order report
   StringBuilder orderReport = new StringBuilder();
   for(){

   }

   return orderReport;

}
}



