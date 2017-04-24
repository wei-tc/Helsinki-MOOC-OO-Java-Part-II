/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author W
 */
public class ResetClickListener implements ActionListener {

    private GraphicCalculatorLogic calculatorLogic;
    private GraphicCalculator calculatorUI;
    private JTextField input;
    private JTextField output;
    private JButton reset;

    public ResetClickListener(GraphicCalculator calculatorUI) {
        this.calculatorUI = calculatorUI;
        this.calculatorLogic = this.calculatorUI.getCalculatorLogic();
        this.input = this.calculatorUI.getInput();
        this.output = this.calculatorUI.getOutput();
        this.reset = this.calculatorUI.getReset();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorLogic.reset();
        this.output.setText("" + this.calculatorLogic.getValue());
        this.input.setText("");
        this.reset.setEnabled(false);
    }

}
