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
public class Plane {
    private String planeId;
    private int planeCapacity;

    public Plane(String id, int capacity) {
        this.planeId = id;
        this.planeCapacity = capacity;
    }

    public String getId() {
        return this.planeId;
    }

    @Override
    public String toString() {
        return this.planeId + " (" + this.planeCapacity + " ppl)";
    }   
}
