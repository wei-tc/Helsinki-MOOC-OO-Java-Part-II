import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W
 */
public class Changer {
private ArrayList<Change> changeArray;
    
    public Changer() {
        changeArray = new ArrayList<Change>();
    }
    
    public void addChange(Change change) {
        changeArray.add(change); 
    }
    
    public String change(String characterString) {
        String changedString = characterString;
        for (Change change : changeArray) {
            changedString = change.change(changedString);
        }
        return changedString;
    }
    
    
}
