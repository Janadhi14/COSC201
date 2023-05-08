package cosc201.a2;
import java.util.*;


public class NovelNic extends Potionmaster{

// constructor and using super becase we are in the subclass of potionMaster which already has potionarium in its constructor 
   public NovelNic (Potionarium potionarium){
      super(potionarium);
   }
   // need to override the method from potionMaster class
   // the List<String> ingredients is in a specific order 
@Override
public String collectIngredients(List<String> ingredients){
    // needs to be more efficient than standard sams methodlology 
    // important to take into account thter is no order that the ingredients have to be added in 
    // first we should try do this in a single forloop

    return orderReport;
}
}




