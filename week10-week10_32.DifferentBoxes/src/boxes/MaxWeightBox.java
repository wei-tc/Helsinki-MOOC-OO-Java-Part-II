/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author W
 */
public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> box;
    
    public MaxWeightBox(int MaxWeight) {
        this.maxWeight = MaxWeight;
        this.box = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        int totalWeight = 0;
        for (Thing thingInBox : this.box) {
            totalWeight += thingInBox.getWeight();
        }
        if (totalWeight + thing.getWeight() <= this.maxWeight) {
            this.box.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return box.contains(thing);
    }
}
