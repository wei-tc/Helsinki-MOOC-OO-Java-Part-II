package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Survey");
        this.frame.setPreferredSize(new Dimension(200, 300));
        
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(this.frame.getContentPane());
        
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(new JLabel("Are you?"));
        container.add(new JCheckBox("Yes!"));
        container.add(new JCheckBox("No!"));
        container.add(new JLabel("Why?"));
        
        JRadioButton option1 = new JRadioButton("No Reason.");
        JRadioButton option2 = new JRadioButton("Because it is fun!");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        
        container.add(option1);
        container.add(option2);
        container.add(new JButton("Done!"));
        
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
