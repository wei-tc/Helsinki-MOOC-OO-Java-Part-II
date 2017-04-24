package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;
import java.util.Random;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
        this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));

        while (worm.runsInto(apple)) {
            this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
        }
        
        addActionListener(this);
        setInitialDelay(2000);
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }

        worm.move();

        if (worm.runsInto(apple)) {
            worm.grow();
            while (worm.runsInto(apple)) {
                this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
            }
        } else if (worm.runsIntoItself()) {
            continues = false;
        } else if (worm.wormHead().getX() == this.width || worm.wormHead().getX() < 0) {
            continues = false;
        } else if (worm.wormHead().getY() == this.height || worm.wormHead().getY() < 0) {
            continues = false;
        }

        updatable.update();
        setDelay(1000 / worm.getLength());

    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Apple getApple() {
        return apple;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Worm getWorm() {
        return worm;
    }

}
