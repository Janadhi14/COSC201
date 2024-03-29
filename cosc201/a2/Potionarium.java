package cosc201.a2;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * A potionarium is a collection of drawers, each of which contains a set of
 * ingredients. 
 * 
 * For Assignment 2, you will implement this class. See the full assignment
 * for further details.
 * 
 * Your code will be marked for correctness (60%) and efficiency (40%).
 * 
 * You may not change the method signatures, but you may add additional methods and/or data
 * fields.
 * 
 */
public class Potionarium {
  // need create 2 Maps that are going to be used for mapping ingredients and drawers both ways around 
  // need to have private fields!!! cause , it should not
/*be possible for any outside program making use of the public methods of the class
to make any changes to the contents of the potion cabinet, except those specified by
the methods*/ 
// should use sets insted of array when implementing because the Arrays are not as effecttiv ebecause we dont want dumplicateds within any given drawer!
    private final Map<String, Set <Long>> ingredientsInDrawers; // A map that maps the ingredients in different drawers  
    private final Map<Long, Set <String>> drawersForIngredients; // A map that maps the drawers for the ingredients 

  /**
   * Creates a new empty potionarium.
   */
  public Potionarium() {
    //when we create an instance of potionarium we need to create both of these 2 hashmaps
    ingredientsInDrawers =new HashMap<>(); 
    drawersForIngredients = new HashMap<>();
  };

  /**
   * Determines the inventory of the potionarium.
   * 
   * @return The set of ingredients in the potionarium.
   */
  public Set<String> getInventory() {
    // needs to return the all the avalible ingredients 
    // we can use the .keyset() of the ingredients map and then put it in the hashset to do this if we put the 
    return new HashSet<>(ingredientsInDrawers.keySet());
  }


  /** 
   * Determines the drawers that contain an ingredient.
   * 
   * @param ingredient The ingredient to be searched for.
   * @return The set of drawers that contain the ingredient.
   */
  public Set<Long> getDrawers(String ingredient) {
    // need to return the drawer numbers containing the ingredient.
    // using a getOrDefault method in Map to get the value associated ot the ingredient, and the default value being a new Hashset 
    return new HashSet<Long>(ingredientsInDrawers.getOrDefault(ingredient, new HashSet<>())); // need to create a new hasshset or selse we would break encapsulation ?
  }

  /**
   * Determines the ingredients that are in a drawer. 
   * 
   * @param drawer The drawer to be searched for.
   * @return The set of ingredients that are in the drawer.
   */
  public Set<String> getIngredients(long drawer) {
    // similar to the get Drawers just for inredients instead
    return new HashSet<>(drawersForIngredients.getOrDefault(drawer, new HashSet<>())); // should create a new hashset because we dont want to modify the existing structure 
  }

  /**
   * Fills the given drawer with the set of ingredients given, provided that it was
   * empty. If the drawer was not empty, it is not changed.
   * 
   * @param drawer The number of the drawer to be filled
   * @param ingredients The set of ingredients to be added
   * @return True if the drawer was filled, false if it was not empty
   */
  public boolean fillDrawer(long drawer, Set<String> ingredients) {
    // bit more tricky first 
    //we must check if the drawer is not filled and make an early return of false 
    if (drawersForIngredients.containsKey(drawer)){
      return false; 
    }
    // now we need to put ingredients in the specified drawer  
    drawersForIngredients.put(drawer, new HashSet<>(ingredients));
    
    // need to go through and add every ingredient to the ingredinets in teh drawers, if absent we need to add and we also need to get and then add to the drawer 
    for(String ingredient : ingredients){
      ingredientsInDrawers.putIfAbsent(ingredient, new HashSet<>()); // empty HashSet if i
      // need to now get teh ingredinet and then add it to the drawer 
      ingredientsInDrawers.get(ingredient).add(drawer);
    }
    // other condition if the ingredient is in the drawer then we return true 
    return true;

  }

  /**
   * Adds an ingredient to a drawer. If the ingredient is already present, it is
   * not added again. 
   * 
   * @param drawer     The number of the drawer to be added to.
   * @param ingredient The ingredient to be added.
   * @return True if the ingredient was added, false if it was already present.
   */
  public boolean addIngredient(long drawer, String ingredient) {
    // check if the drawer exists
    if (!drawersForIngredients.containsKey(drawer)) {
      return false; // checks if the drawer is present 
    }
    // if the ingredient is present it is not added again and we return false 
    if (drawersForIngredients.get(drawer).contains(ingredient)) {
      return false;
    }
    //if we get this far we are going to add to the drawer the ingredient 
    drawersForIngredients.get(drawer).add(ingredient);
    // we also need to update this on the other Map
    ingredientsInDrawers.putIfAbsent(ingredient, new HashSet<>());
    ingredientsInDrawers.get(ingredient).add(drawer);
    // returns true if the ingredient is added
    return true;
  }



  /**
   * Removes an ingredient from a drawer.
   * 
   * @param drawer     The number of the drawer to be removed from.
   * @param ingredient The ingredient to be removed.
   * @return True if the ingredient was removed, false if it was not present.
   */
  public boolean removeIngredient(long drawer, String ingredient) {
    // needs to return faslse if the ingredient wasnt present in tehspecified drawer 
   // need to check if the drawer is present in the hashmap and then check if the ingredient is present and if 
   // one of these are false we need to return false so it should be !drawersForIngredients.get..... or !drawersForIngredients
    if(!drawersForIngredients.get(drawer).contains(ingredient)||!drawersForIngredients.containsKey(drawer)){
    return false;
   }
   // now we know that the ingredient must be present in teh stated drawer so we can remove the ingredients with get methods 
   drawersForIngredients.get(drawer).remove(ingredient);
    // now we need to update the ingredientsInDrawers if the ingredient was removed and then return true 
   ingredientsInDrawers.get(ingredient).remove(drawer);

    return true;
  }


  /**
   * Removes a set of ingredients from a drawer. If one or more are
   * missing, then none should be removed.
   * 
   * @param drawer     The number of the drawer to be removed from.
   * @param ingredients The set of ingredients to be removed.
   * @return True if all ingredients were removed, false if one or more were missing.
   */
  public boolean removeIngredients(long drawer, Set<String> ingredients) {
    Set<String> ingInDrawer = drawersForIngredients.get(drawer);
    // checks if the drawer doesnt exist and returns false 
    if (ingInDrawer == null) {
        return false;
    }
    
    // need to iterate through the Set of ingredients and check if it is in the drawer
    for (String ingredient : ingredients) {
        if (!ingInDrawer.contains(ingredient)) {
            return false;
        }
    }
    // another for loop to remove 
    // now for all the ingredients that are present, we can remove them
    for (String ingredient : ingredients) {
        ingInDrawer.remove(ingredient);
        ingredientsInDrawers.get(ingredient).remove(drawer);
    }
    // retunrs true aswell
    return true;
}


}
