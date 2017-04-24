/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author W
 */
public class Barn {
    private BulkTank bulktank;
    private MilkingRobot milkingRobot;
    
    public Barn(BulkTank tank) {
        this.bulktank = tank;
        this.milkingRobot = new MilkingRobot();
    }
    
    public BulkTank getBulkTank() {
        return this.bulktank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        this.milkingRobot.setBulkTank(bulktank);
    }
    
    public void takeCareOf(Cow cow) {
        if (this.milkingRobot == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        
        this.milkingRobot.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        if (this.milkingRobot == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        
        for (Cow cow : cows) {
            this.milkingRobot.milk(cow);
        }
    }
    
    public String toString() {
        return this.bulktank.toString();
    }
}
