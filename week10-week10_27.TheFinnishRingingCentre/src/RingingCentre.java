/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author W
 */
public class RingingCentre {

    private Map<Bird, List<String>> ringingCentre;

    public RingingCentre() {
        this.ringingCentre = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!this.ringingCentre.containsKey(bird)) {
            this.ringingCentre.put(bird, new ArrayList<String>());
        }

        this.ringingCentre.get(bird).add(place);
    }

    public void observations(Bird bird) {
        System.out.print(bird + " observations: ");
        if (!this.ringingCentre.containsKey(bird)) {
            System.out.println("0");
        } else {
            System.out.println(this.ringingCentre.get(bird).size());
            for (String location : this.ringingCentre.get(bird)) {
                System.out.println(location);
            }
        }
    }
}
