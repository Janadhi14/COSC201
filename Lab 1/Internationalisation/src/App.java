import java.util.*;
import java.util.prefs.Preferences;

public class App {

    // Hello world app, but with internationalisation
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(App.class);

        Locale.setDefault(new Locale(prefs.get("language", "en"), 
                prefs.get("country", "NZ")));

        ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle");

        System.out.println(bundle.getString("greeting"));
        
        // prefs.put("language", "fr");
        // prefs.put("language", "ar");
        // prefs.put("language", "jp");
        prefs.put("language", "fr");
        prefs.put("country", "NZ");
        

    }
}
