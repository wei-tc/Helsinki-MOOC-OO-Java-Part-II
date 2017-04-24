/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author W
 */

public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> duplicateRemover;
    private int duplicateAmount;
    
    public PersonalDuplicateRemover() {
        this.duplicateRemover = new HashSet<String>();
        this.duplicateAmount = 0;
    }
    
    @Override
    public void add(String characterString) {
        if (this.duplicateRemover.contains(characterString)) {
            this.duplicateAmount++;
            return;
        }
        this.duplicateRemover.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.duplicateAmount;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.duplicateRemover;
    }

    @Override
    public void empty() {
        this.duplicateRemover.removeAll(duplicateRemover);
        this.duplicateAmount = 0;
    }
}
