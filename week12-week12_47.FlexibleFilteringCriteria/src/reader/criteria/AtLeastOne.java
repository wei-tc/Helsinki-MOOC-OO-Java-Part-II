/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author W
 */
public class AtLeastOne implements Criterion {

    private Criterion[] criteria;
    
    public AtLeastOne(Criterion... criterion) {
        this.criteria = criterion;
    }
    
    @Override
    public boolean complies(String line) {
        for (Criterion criterion : criteria) {
            if (criterion.complies(line)) {
                return true;
            }
        }
        
        return false;
    }
}
