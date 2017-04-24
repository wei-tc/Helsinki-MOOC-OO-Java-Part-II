/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author W
 */
public class Vampire {

    private int x;
    private int y;
    private int length;
    private int height;
    private Random random = new Random();

    public Vampire(int length, int height) {
        this.length = length;
        this.height = height;
        this.x = random.nextInt(length);
        this.y = random.nextInt(height);

        initialPositionNotZero();
    }

    public void resetInitialPosition() {
        this.x = random.nextInt(length);
        this.y = random.nextInt(height);

        initialPositionNotZero();
    }

    public void initialPositionNotZero() {
        while (this.x == 0) {
            this.x = random.nextInt(length);
        }

        while (this.y == 0) {
            this.y = random.nextInt(height);
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move() {
        while (true) {
            int direction = random.nextInt(4);
            if (direction == 0) {
                if (this.y > 0) {
                    this.y--;
                    break;
                }
            } else if (direction == 1) {
                if (this.y < this.height - 1) {
                    this.y++;
                    break;
                }
            } else if (direction == 2) {
                if (this.x > 0) {
                    this.x--;
                    break;
                }
            } else if (direction == 3) {
                if (this.x < this.length - 1) {
                    this.x++;
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "v " + this.x + " " + this.y;
    }

    public String coordinates() {
        return this.x + "x" + this.y + "y";
    }
}
