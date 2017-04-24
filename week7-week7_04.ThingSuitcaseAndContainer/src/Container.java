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
public class Container {
private ArrayList<Suitcase> container;
private int weightLimit;    
    
    public Container(int weightLimit) {
        this.container = new ArrayList<Suitcase>();
        this.weightLimit = weightLimit;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (totalWeight() + suitcase.totalWeight() <= this.weightLimit) {
            container.add(suitcase);
        }
    }
    
    public int totalWeight() { 
        int totalWeight = 0;
        for (Suitcase suitcase : container) {
            totalWeight += suitcase.totalWeight();
        }
        
        return totalWeight;
    }
    
    public void printThings() {
        for (Suitcase suitcase : container) {
            suitcase.printThings();
        }
    }
    
    @Override
    public String toString() {
        return this.container.size() + " suitcases (" + totalWeight() + " kg)";
    }
    
    
}
