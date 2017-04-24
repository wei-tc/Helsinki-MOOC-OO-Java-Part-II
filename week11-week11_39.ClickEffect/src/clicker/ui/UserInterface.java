package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import clicker.ui.ClickListener;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        
        JButton click = new JButton("Click!");
        JLabel count = new JLabel("" + this.calculator.giveValue());
        click.addActionListener(new ClickListener(this.calculator, count));
        
        container.add(count);
        container.add(click, BorderLayout.SOUTH);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
