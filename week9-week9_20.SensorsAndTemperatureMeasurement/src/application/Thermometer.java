/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;
/**
 *
 * @author W
 */
public class Thermometer implements Sensor {
    private boolean power;
    private Random random;

    public Thermometer() {
        this.power = false;
        this.random = new Random();
    }
    
    @Override
    public boolean isOn() {
        if (this.power == false) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void on() {
        this.power = true;
    }

    @Override
    public void off() {
        this.power = false;
    }

    @Override
    public int measure() {
        if (this.power = true) { 
            return this.random.nextInt(61) - 30;
        } else { 
            throw new IllegalArgumentException();
        }
    }
}
