package a2;

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
  // need to have private fields!!! cause y, it should not
/*be possible for any outside program making use of the public methods of the class
to make any changes to the contents of the potion cabinet, except those specified by
the methods*/
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
    // need to return a set of drawer numbers containing a given ingredient.
    // using a getOrDefault method in Map to get the value associated ot the ingredient, and the default value being a new Hashset 
    // we are doing this so that we can still return a value even if the ingredient is not in the drawers
    return new HashSet<Long>(ingredientsInDrawers.getOrDefault(ingredient, new HashSet<>()));
  }

  /**
   * Determines the ingredients that are in a drawer. 
   * 
   * @param drawer The drawer to be searched for.
   * @return The set of ingredients that are in the drawer.
   */
  public Set<String> getIngredients(long drawer) {
    // similar to the get Drawers just for inredients instead
    return new HashSet<>(drawersForIngredients.getOrDefault(drawer, new HashSet<>()));
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
    // we need to add the ingrediernt to the specified drawer going to need a couple of if statements to verify 
    Set<String> drawerIngredients = drawersForIngredients.get(drawer);
    
    // if statement to chekc if the ingredients in teh drawer is null then we need to create a new hashmap with nothing in it so doesnt retunr null 
    if(drawerIngredients == null){
      drawerIngredients = new HashSet<>();
      drawersForIngredients.put(drawer, drawerIngredients);
    }
    // now check if the 
    if(!drawerIngredients.add(ingredient)){
      // if we try to add an ingredient to the drawer and it is alreadt present then we are going to return false 
      return false;
    }
    // now if it is not either of thoses cases we need to put if it is absent and then alsl add to drawer 
    ingredientsInDrawers.putIfAbsent(ingredient, new HashSet<>());
    ingredientsInDrawers.get(ingredient).add(drawer); // adding to the drawer the ingredient 
    
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
    // need to remove a set of Ingredients so will need to use a for loop aswell to go through the ingredinets that are in the set 
    Set<String> drawerIngredients = drawersForIngredients.get(drawer);
    if (drawerIngredients == null||!drawerIngredients.containsAll(ingredients)) { // need to use contains all cause we are dealing with set of String ingredients (not just one )
    // returns false if there is nothing or if the ingredient is not in the drawer or if the drawer has been

      return false;
    }
    // now we need to go through and for every ingredient in the set of ingredients we need to remove from both maps 
    for(String ingredient : ingredients) {
      drawerIngredients.remove(ingredient);
      ingredientsInDrawers.get(ingredient).remove(drawer);
    }
    
    return true;
  }

}