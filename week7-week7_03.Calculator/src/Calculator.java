
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W
 */
public class Calculator {

    private int numberOfCommands;
    private Reader reader;

    public Calculator() {
        this.reader = new Reader();
        this.numberOfCommands = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }

    private void sum() {
        int[] values = input();
        int sum = values[0] + values[1];
        System.out.println("sum of the values " + sum);
    }

    private void difference() {
        int[] values = input();
        int difference = values[0] - values[1];
        System.out.println("difference of the values " + difference);
    }

    private void product() {
        int[] values = input();
        int product = values[0] * values[1];
        System.out.println("product of the values " + product);
    }

    private void statistics() {
        System.out.println("Calculations done " + numberOfCommands);
    }

    private int[] input() {
        numberOfCommands++;
        
        int[] values = new int[2];
        System.out.println("value1: ");
        values[0] = reader.readInteger();
        System.out.println("value2: ");
        values[1] = reader.readInteger();
        
        return values;
    }
}
