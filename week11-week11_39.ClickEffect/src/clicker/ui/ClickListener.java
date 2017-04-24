/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import clicker.applicationlogic.Calculator;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author W
 */
public class ClickListener implements ActionListener {
    private Calculator calculator;
    private JLabel count;
    
    public ClickListener(Calculator calculator, JLabel JLabel) {
        this.calculator = calculator;
        this.count = JLabel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculator.increase();
        this.count.setText("" + this.calculator.giveValue());
    }
}
