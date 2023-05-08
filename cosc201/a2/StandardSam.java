package cosc201.a2;
import java.util.*;


public class StandardSam extends Potionmaster{

// constructor and using super becase we are in the subclass of potionMaster which already has potionarium in its constructor 
   public StandardSam(Potionarium potionarium){
      super(potionarium);
   }
   // need to override the method from potionMaster class
   // the List<String> ingredients is in a specific order 
@Override
public String collectIngredients(List<String> ingredients){
   /*Sam starts with a potion recipe: a list (without duplicates) of ingredients that are needed
to brew a potion so we need to implement this in java through*/
   List<String> ingredientsMissing = new ArrayList<>(); // create the list of missing ingredients 
   Set<String> ingredientsRemaining = new HashSet<>(ingredients); //need to make a ingredientsRemaning variable for wehn we are looking within the drawers 
   Map<Long, List<String>> usedDrawers = new HashMap<>();
   
   // need to verify that we are able to get these ingredients from the drawers 
   // for loop and check each ingredient is there
   for(String ingredient: ingredients){ 
      Set<Long> drawers = potionarium.getDrawers(ingredient); // going through and getting the ingredients 
      // need to check if the drawers are empty then we need to add to ingredients missing list 
      if(drawers.isEmpty()){ // if true that is going to mean that the ingredinet sint present 
         ingredientsMissing.add(ingredient);
      }
   }  
   // if there are missing ingredients we need to return the missing ingredients
if (!ingredientsMissing.isEmpty()) {
   String missingOrderList = String.join(", ", ingredientsMissing);
   return "Missing ingredients: " + missingOrderList; // early returns the missing ingredients order report without removing!!!
} else {


    

    // if we get down this far that means there are no missing ingredients 
    /*logic:  First Sam  verifies that it’s possible to get all the required ingredients from the cabinet.
    Then, while they have not collected all the necessary ingredients, they find the first item on the list that’s still needed. 
    They remove this item from the lowestnumbered drawer containing it. While doing so, they also remove any other items still needed that are present in that drawer. */
    while(!ingredientsRemaining.isEmpty()) {
        String firstIngredient = ingredientsRemaining.iterator().next();
        long minDrawer = Collections.min(potionarium.getDrawers(firstIngredient)); // gets the smallest drawer that contains the first ingredient that is needed 
        // need to create more variables fo ingredients 
        Set<String> ingredientsInDrawer = potionarium.getIngredients(minDrawer);
        List<String> ingredientsFound = new ArrayList<String>();
        //for loop to go through and add check if ingredient is there and add to ingredients  
        for(String ingredient : ingredientsInDrawer){
            if(ingredientsRemaining.contains(ingredient)){
                ingredientsFound.add(ingredient);
                ingredientsRemaining.remove(ingredient); // need to remove from the ingredient that are remaining in the lsit 
            }
        }
                // need to remove from the potionarium aswell
                for(String ingredient : ingredientsFound){
                  potionarium.removeIngredient(minDrawer,ingredient);
      
              }
      
            //need to keep track of drawers that we have gone through aswell!!
            usedDrawers.put(minDrawer,ingredientsFound);
            
            // we need to break out of this for loop once we have gotten all the ingredients 
            if(ingredientsRemaining.isEmpty()){
               break;
              }
          }
      
      
      
      
         // if all the ingredients are present then we need to build a string that will return the order report
         StringBuilder orderReport = new StringBuilder();
         for (Map.Entry<Long, List<String>> start : usedDrawers.entrySet()) { 
          String ingredientsInDrawer = String.join(", ", start.getValue());
          orderReport.append(start.getKey()).append(": ").append(ingredientsInDrawer).append('\n');
      }
         return orderReport.toString();


}
}
}



