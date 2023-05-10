package cosc201.a2;
import java.util.*;


public class NovelNic extends Potionmaster {
    // constructor using the super cause it is a subclass of potionmaster 
   public NovelNic(Potionarium potionarium) {
       super(potionarium);
   }

   @Override
   public String collectIngredients(List<String> ingredients) {
    // going to use a TreeSet for the ingredients instead of a Set beacsue it has sorted order because we want to order the
    // drawers based on how many ingredients that it has of the ones we need 
       Map<String, TreeSet<Long>> sortedDrawersWithIngredients = new HashMap<>(); 
       // now we should go thorugh for every ingredient and add it to the Sorted drawers

       for (String ingredient : ingredients) {
           Set<Long> drawers = potionarium.getDrawers(ingredient); // need to get the drawers with the specified ingredient 
           sortedDrawersWithIngredients.put(ingredient, new TreeSet<>(drawers)); // adding the sorted drawers 
       }
       // need to now go through the ingredients and then check if they are missing 
       Map<Long, List<String>> collectedIngredientsAndDrawers = new TreeMap<>(); // using another TreeMap because we need to store collected ingredients 
       for (String ingredient : ingredients) {
           TreeSet<Long> drawers = sortedDrawersWithIngredients.get(ingredient);
           if (drawers.isEmpty()) { // once the drawers are empty we can return the missing ingredients 
               return "Missing ingredients: " + ingredient; // building the missing ingredients order report  as we go adn retuning once the drawer is empty
           }    
           //now that we are this far that means we dont have any missing ingredients 
           Long drawer = drawers.pollFirst();
           collectedIngredientsAndDrawers.putIfAbsent(drawer, new ArrayList<>()); // adding into the Treemap if the ingredient isnt already in there (there could be repeat ingredients from the lsit )
           // need to now get the specific drawer and then add the ingredient  
           collectedIngredientsAndDrawers.get(drawer).add(ingredient);
           potionarium.removeIngredient(drawer, ingredient); // we also need to remove from potionaruium 
       }
       // using a string  bilder to add create the order report 
       StringBuilder orderSlip = new StringBuilder();
       for (Map.Entry<Long, List<String>> item : collectedIngredientsAndDrawers.entrySet()) { // for loop to interate rhough every enry in the map
           orderSlip.append(item.getKey())
            .append(": ") // need the ":" before the ingredient 
            .append(String.join(", ", item.getValue()))
            .append("\n"); // goes to the next line
       }
       return orderSlip.toString().trim(); // returns with the toString method but need trim aswell to remove extra white spaces 
   }
}
