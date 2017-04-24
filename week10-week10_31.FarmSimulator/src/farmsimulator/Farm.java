/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author W
 */
public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return this.owner;
    }
    
    public void addCow(Cow cow) {
        this.cows.add(cow);
    }
    
    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }
    
    @Override
    public void liveHour() {
        for (Cow cow : this.cows) {
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        String toString = "Farm owner: " + this.owner + "\n" 
                + "Barn bulk tank: " + this.barn.getBulkTank() + "\n";
        if (this.cows.isEmpty()) {
            toString += "No cows.";
        } else {
            toString += "Animals:\n";
            for (Cow cow : this.cows) {
                toString += "        " + cow;
            }
        }
        
        return toString;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.barn.installMilkingRobot(milkingRobot);
    }
}
