/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author W
 */
public class Dungeon {

    private Random random = new Random();
    private Scanner reader = new Scanner(System.in);
    private List<Vampire> vampires;
    private int height;
    private int length;
    private int movesRemaining;
    private boolean vampiresMove;
    private Player player;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = new ArrayList<Vampire>();
        this.movesRemaining = moves;
        this.vampiresMove = vampiresMove;
        this.player = new Player(this.length, this.height);

        for (int i = 0; i < vampires; i++) {
            this.vampires.add(new Vampire(this.length, this.height));
        }
    }

    public void run() {
        while (this.movesRemaining > 0) {
            this.printCoordinates();

            while (this.checkOverlap()) {
                this.resetInitialPositions();
            }

            this.printGrid();
            this.playerAndVampiresMove();

            if (vampires.size() == 0) {
                System.out.println("YOU WIN");
                break;
            }

            this.movesRemaining--;
        }

        if (vampires.size() != 0) {
            System.out.println("YOU LOSE");
        }
    }

    public void printCoordinates() {
        System.out.println(this.movesRemaining + "\n\n" + this.player);
        for (Vampire vampire : this.vampires) {
            System.out.println(vampire);
        }
        System.out.println("");
    }

    public void playerAndVampiresMove() {
        char[] command = reader.nextLine().toLowerCase().toCharArray();
        for (int i = 0; i < command.length; i++) {
            this.player.command(command[i]);
            if (this.vampiresMove) {
                this.vampiresMove();
            }

            this.playerKillVampire();
        }
    }

    public void vampiresMove() {
        List<Vampire> backupVampireList = new ArrayList<Vampire>(this.vampires);

        while (true) {
            for (Vampire vampire : this.vampires) {
                vampire.move();
            }

            if (this.checkOverlap()) {
                this.vampires = backupVampireList;
            }

            break;
        }
    }

    public void playerKillVampire() {
        for (int j = 0; j < this.vampires.size(); j++) {
            if (this.player.coordinates().equals(this.vampires.get(j).coordinates())) {
                this.vampires.remove(j);
            }
        }
    }

    public void printGrid() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.height; x++) {
                xCoordinateLoop:
                while (true) {
                    if (this.player.coordinates().equals(x + "x" + y + "y")) {
                        System.out.print("@");
                        break;
                    }

                    for (int i = 0; i < this.vampires.size(); i++) {
                        if (this.vampires.get(i).coordinates().equals(x + "x" + y + "y")) {
                            System.out.print("v");
                            break xCoordinateLoop;
                        }
                    }

                    System.out.print(".");
                    break;
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void resetInitialPositions() {
        for (Vampire vampire : this.vampires) {
            vampire.resetInitialPosition();
        }
    }

    public boolean checkOverlap() {
        for (int i = 0; i < this.vampires.size() - 1; i++) {
            for (int j = i + 1; j < this.vampires.size(); j++) {
                if (this.vampires.get(i).coordinates().equals(this.vampires.get(j).coordinates())) {
                    return true;
                }
            }
        }

        return false;
    }
}
