
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
public class Suitcase {

    private ArrayList<Thing> things;
    private int weightLimit;

    public Suitcase(int weightLimit) {
        this.things = new ArrayList<Thing>();
        this.weightLimit = weightLimit;
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Thing thing : things) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }

    public void addThing(Thing thing) {
        if (totalWeight() + thing.getWeight() <= this.weightLimit) {
            this.things.add(thing);
        }
    }

    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public Thing heaviestThing() {
        if (this.things.size() > 0) {
            Thing heaviestThing = this.things.get(0);
            for (Thing thing : things) {
                if (thing.getWeight() > heaviestThing.getWeight()) {
                    heaviestThing = thing;
                }
            }
            return heaviestThing;
        }
        return null;
    }

    @Override
    public String toString() {
        if (this.things.size() == 0) {
            return "empty (0 kg)";
        } else if (this.things.size() == 1) {
            return this.things.size() + " thing (" + totalWeight() + " kg)";
        }

        return this.things.size() + " things (" + totalWeight() + " kg)";
    }
}
