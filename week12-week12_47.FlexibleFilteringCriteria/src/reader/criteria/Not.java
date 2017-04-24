/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author W
 */
public class Not implements Criterion {

    private Criterion criterion;

    public Not(Criterion criterion) {
        this.criterion = criterion;
    }

    @Override
    public boolean complies(String line) {
        return !criterion.complies(line);
    }
}
