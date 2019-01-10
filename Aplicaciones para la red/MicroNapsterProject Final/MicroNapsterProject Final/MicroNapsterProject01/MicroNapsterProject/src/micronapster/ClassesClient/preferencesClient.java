package micronapster.ClassesClient;

import java.util.prefs.Preferences;

public class preferencesClient {
    
    private Preferences preferences, myPreferences;
    private static final String KEY_PTH = "path";
    
    public preferencesClient(){
        preferences = Preferences.userRoot().node(this.getClass().getName());
    }
  
    public void setPath(String KEY_USR, String path){
        System.out.println("USER: " + KEY_USR + " PATH: " + path);
        preferences.put(KEY_USR, path);
    }
    
    public String getPath(String KEY_USR){
        System.out.println("USER: "  + KEY_USR + " PATH: " + preferences.get(KEY_PTH, ""));
        return preferences.get(KEY_USR, "");
    }
}
