package PokerAssign;

import java.util.Arrays;
import java.util.List;

public class Hand {
    private final int HAND_SIZE = 5;

    List<Card> hand;

    public Hand(){
        //setter will set the hand array
    }

//    public Hand(Card[] hand) {
//        this.hand = hand;
//        //= new Card[HAND_SIZE]
//        // hand = new Card[HAND_SIZE];
//    }

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
        return "Hand{" +
                "HAND_SIZE=" + HAND_SIZE +
                ", hand=" + hand +
                '}';
    }
}
