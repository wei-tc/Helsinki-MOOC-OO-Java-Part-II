import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author W
 */
public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        for (Card card : this.hand) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(this.hand);
        this.print();
    }
    
    @Override
    public int compareTo(Hand hand) {
        int thisValue = 0, otherValue = 0;
        for (Card thisCard : this.hand) {
            thisValue += thisCard.getValue();
        }
        
        for (Card otherCard : hand.hand) {
            otherValue += otherCard.getValue();
        }
        
        return thisValue - otherValue;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}

