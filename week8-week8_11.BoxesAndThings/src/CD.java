/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W
 */
public class CD implements ToBeStored {
    private String artist;
    private String title;
    private int publishingYear;

    public CD(String artist, String title, int publishingYear) {
        this.artist = artist;
        this.title = title;
        this.publishingYear = publishingYear;
    }
    
    public double weight() {
        double weight = 0.1;
        return weight;
    }
    
    @Override
    public String toString() {
        return this.artist + ": " + this.title + " (" + this.publishingYear + ")";
    }
    
    
}
