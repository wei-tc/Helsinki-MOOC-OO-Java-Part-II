/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author W
 */
public class GraphicCalculatorLogic {

    private int value;

    public GraphicCalculatorLogic() {
        this.value = 0;
    }
    
    public void add(int input) {
        this.value += input;
    }

    public void subtract(int input) {
        this.value -= input;
    }

    public void reset() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }
}
