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
    private final Map<Long, Set <String>> ingredientsInDrawers; // A map that maps the ingredients in different drawers  
    private final Map<Long, Set <String>> drawersForIngredients; // A map that maps the drawers for the ingredients 

  /**
   * Creates a new empty potionarium.
   */
  public Potionarium() {
    //when we create an instance of potionarium we need to create both of these 2 hashmaps
    ingredientsInDrawers =new HashMap<>(); 
    drawersforIngredients = new HashMap<>();
  };

  /**
   * Determines the inventory of the potionarium.
   * 
   * @return The set of ingredients in the potionarium.
   */
  public Set<String> getInventory() {
    // needs to return the all the avalible ingredients 
    // we can use the .keyset() of the ingredients map and then put it in the hashset to do this if we put the 
    return new HashSet<>(ingredientsInDrawers.keyset());
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
    return null;
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
    return false;
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
    return false;
  }

  /**
   * Removes an ingredient from a drawer.
   * 
   * @param drawer     The number of the drawer to be removed from.
   * @param ingredient The ingredient to be removed.
   * @return True if the ingredient was removed, false if it was not present.
   */
  public boolean removeIngredient(long drawer, String ingredient) {
    return false;
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
    return false;
  }

}
