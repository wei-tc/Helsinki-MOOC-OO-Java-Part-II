import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W
 */
public class PromissoryNote {
    private HashMap<String, Double> promissoryNote;
    
    
    public PromissoryNote() {
        this.promissoryNote = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value) {
        this.promissoryNote.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        if (this.promissoryNote.containsKey(whose)) {
            return this.promissoryNote.get(whose);
        }
        
        return 0;
    }
    
    
}
