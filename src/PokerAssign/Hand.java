package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.Arrays;
import java.util.List;

public class Hand {
    private final int HAND_SIZE = 5;

    private List<Card> hand;

    //constructor
    public Hand(){
        //setter will set the hand array, so constructor does nothing
    }

    //Getters & setters
    public int getHandSize() {
        return HAND_SIZE;
    }
    public List<Card> getHand() {
        return hand;
    }
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return hand.toString(); //returns hand List, look at implementation of ToString in Card to see how this works
    }
}
