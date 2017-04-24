/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author W
 */
public class BulkTank {
    private double capacity;
    private double volume = 0;
    
    public BulkTank() {
        this(2000);
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getVolume() {
        return this.volume;
    }
    
    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount) {
        if (this.volume + amount > this.capacity) {
            this.volume = this.capacity;
            return;
        }
        
        this.volume += amount;
    }
    
    public double getFromTank(double amount) {
        if (this.volume - amount < 0) {
            double amountTaken = this.volume;
            this.volume = 0;
            return amountTaken;
        } 
        
        this.volume -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
