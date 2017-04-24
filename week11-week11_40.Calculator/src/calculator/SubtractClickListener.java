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
public class SubtractClickListener implements ActionListener {

    private GraphicCalculatorLogic calculatorLogic;
    private GraphicCalculator calculatorUI;
    private JTextField input;
    private JTextField output;
    private JButton reset;

    public SubtractClickListener(GraphicCalculator calculatorUI) {
        this.calculatorUI = calculatorUI;
        this.calculatorLogic = this.calculatorUI.getCalculatorLogic();
        this.input = this.calculatorUI.getInput();
        this.output = this.calculatorUI.getOutput();
        this.reset = this.calculatorUI.getReset();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.calculatorUI.isInputInteger()) {
            this.calculatorLogic.subtract(this.calculatorUI.getInputValue());
            this.output.setText("" + this.calculatorLogic.getValue());
            this.input.setText("");
            if (this.calculatorUI.getOutputValue() == 0) {
                this.reset.setEnabled(false);
            } else {
                this.reset.setEnabled(true);
            }
        } else {
            this.input.setText("");
        }
    }
}
