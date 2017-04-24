/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;

/**
 *
 * @author W
 */
public abstract class Figure {

    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Figure() {
    }
    
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public abstract void draw(Graphics graphics);
}
