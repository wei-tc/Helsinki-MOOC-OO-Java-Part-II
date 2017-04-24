/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author W
 */
public class Box implements Thing {
    
    private List<Thing> box;
    private int maximumCapacity;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.box = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() > this.maximumCapacity) { 
            return false;
        }
        
        this.box.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int boxVolume = 0;
        for (Thing thing : this.box) {
            boxVolume += thing.getVolume();
        }
        return boxVolume;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
