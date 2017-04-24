/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author W
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        for (int x = 0; x < super.getWidth(); x++) {
            for (int y = 0; y < super.getHeight(); y++) {
                if (new Random().nextDouble() < probabilityForEachCell) {
                    turnToLiving(x, y);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (insideTheBoard(x, y) && super.getBoard()[x][y] == true) {
            return true;
        }

        return false;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (insideTheBoard(x, y)) {
            super.getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (insideTheBoard(x, y)) {
            super.getBoard()[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int numberOfLivingNeighbours = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isAlive(i, j)) {
                    numberOfLivingNeighbours++;
                }
            }
        }

        if (isAlive(x, y)) {
            numberOfLivingNeighbours--; //take 1 to account for original cell if alive
        }

        return numberOfLivingNeighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3) {
            turnToDead(x, y);
        } else if (livingNeighbours == 3) {
            turnToLiving(x, y);
        }
    }
    
    public boolean insideTheBoard(int x, int y) {
        if (x < 0 || y < 0 || x >= super.getWidth() || y >= super.getHeight()) { 
            return false;
        }
        
        return true;
    }
}
