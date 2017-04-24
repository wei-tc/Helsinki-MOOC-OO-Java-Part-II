/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author W
 */
public class Cow implements Milkable, Alive {
    private String name;
    private int capacity;
    private double amount;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = NAMES[new Random().nextInt(NAMES.length)];
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
        this.amount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public double milk() {
        double milk = this.amount;
        this.amount = 0;
        return milk;
    }

    @Override
    public void liveHour() {
        this.amount += 0.7 + new Random().nextInt() * 1.3;
        if (this.amount > this.capacity) {
            this.amount = this.capacity;
        }
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" + this.capacity;
    }
}
