/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author W
 */
public class ContainerHistory {

    private List<Double> containerHistory;

    public ContainerHistory() {
        this.containerHistory = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.containerHistory.add(situation);
    }

    public void reset() {
        this.containerHistory.clear();
    }

    @Override
    public String toString() {
        return this.containerHistory.toString();
    }

    public double maxValue() {
        if (this.containerHistory.size() > 0) {
            double maxValue = this.containerHistory.get(0);

            for (double value : this.containerHistory) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }

            return maxValue;
        }
        
        return 0;
    }

    public double minValue() {
        if (this.containerHistory.size() > 0) {
            double minValue = this.containerHistory.get(0);

            for (double value : this.containerHistory) {
                if (value < minValue) {
                    minValue = value;
                }
            }

            return minValue;
        }

        return 0;
    }

    public double average() {
        double total = 0;
        for (double value : this.containerHistory) {
            total += value;
        }

        return total / this.containerHistory.size();
    }

    public double greatestFluctuation() {
        if (this.containerHistory.size() > 1) {
            double greatestFluctuation = Math.abs(this.containerHistory.get(0) - this.containerHistory.get(1));

            for (int i = 0; i < this.containerHistory.size() - 1; i++) {
                double comparedFluctuation = Math.abs(this.containerHistory.get(i) - this.containerHistory.get(i + 1));
                if (comparedFluctuation > greatestFluctuation) {
                    greatestFluctuation = comparedFluctuation;
                }
            }

            return greatestFluctuation;
        }

        return 0;
    }
    
    public double variance() {
        if (this.containerHistory.size() > 1) {
            double variance = 0;
            
            for (double value : this.containerHistory) {
                variance += Math.pow(value - this.average(), 2);
            }
            
            return variance / (this.containerHistory.size() - 1) ;
        }
        
        return 0;
    }
}
