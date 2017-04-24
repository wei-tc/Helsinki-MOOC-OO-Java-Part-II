/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author W
 */
public class DrawingBoard extends JPanel implements Updatable {

    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (Piece piece : wormGame.getWorm().getPieces()) {
            graphics.setColor(Color.BLACK);
            graphics.fill3DRect(pieceLength * piece.getX(), pieceLength * piece.getY(), pieceLength, pieceLength, true);
        }

        graphics.setColor(Color.RED);
        graphics.fillOval(pieceLength * wormGame.getApple().getX(), pieceLength * wormGame.getApple().getY(), pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
