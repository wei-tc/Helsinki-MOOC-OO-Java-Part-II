/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author W
 */
public class CompoundFigure extends Figure {

    private ArrayList<Figure> figures; 

    public CompoundFigure() {
        this.figures = new ArrayList<Figure>();
    }

    public void add(Figure f) {
        figures.add(f);
    }
    
    @Override
    public void draw(Graphics graphics) {
        for (Figure figure : figures) {
            figure.draw(graphics);
        }
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Figure figure : figures) {
            figure.move(dx, dy);
        }
    }
}
