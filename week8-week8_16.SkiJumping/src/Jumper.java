
import java.util.Map;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author W
 */
public class Jumper implements Comparable<Jumper> {

    private Map<Integer, Points> points;
    private String name;

    public Jumper(String name) {
        this.name = name;
        this.points = new HashMap<Integer, Points>();
    }

    public void jump(int round) {
        this.points.put(round, new Points());
    }

    public String getName() {
        return this.name;
    }

    public Points getPoints(int round) {
        return this.points.get(round);
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Points points : this.points.values()) {
            totalPoints += points.getPoints();
        }
        return totalPoints;
    }

    public String printJumperResults() {
        return this.name + " (" + this.getTotalPoints() + " points)";
    }

    public String printLengths() {
        String printLengths = "";
        for (Points points : this.points.values()) {
            printLengths += " " + points.getLength() + " m,";
        }
        printLengths = printLengths.substring(0, printLengths.length() - 1);
        return printLengths;
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.getTotalPoints() - jumper.getTotalPoints();
    }

    @Override
    public String toString() {
        String results = "           " + this.printJumperResults() + "\n            jump lengths:" + this.printLengths();
        return results;
    }
}
