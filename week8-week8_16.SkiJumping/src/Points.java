
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author W
 */
public class Points {

    private int length;
    private List<Integer> votes;
    private Random random;

    public Points() {
        this.random = new Random();
        this.length = random.nextInt(61) + 60;
        this.votes = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            this.votes.add(this.random.nextInt(11) + 10);
        }
    }

    public int getLength() {
        return this.length;
    }

    public String printVotes() {
        String votes = "[";
        for (int i = 0; i < 4; i++) {
            votes += this.votes.get(i) + ", ";
        }
        votes += this.votes.get(4) + "]";
        return votes;
    }

    public int getValidVotes() {
        Collections.sort(this.votes);
        int totalValidVotes = 0;
        for (int i = 1; i < 4; i++) {
            totalValidVotes += this.votes.get(i);
        }
        return totalValidVotes;
    }

    public int getPoints() {
        return this.length + this.getValidVotes();
    }

    @Override
    public String toString() {
        String results = "    length: " + this.length + "\n" + "    judge votes: " + this.printVotes();
        return results;
    }
}
