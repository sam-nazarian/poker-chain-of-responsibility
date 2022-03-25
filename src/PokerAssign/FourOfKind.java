package PokerAssign;

import java.util.List;

public class FourOfKind implements Handler {
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {
        List<Card> handList = hand.getHand();

        if((handList.get(0).getRank() == handList.get(3).getRank()) || (handList.get(1).getRank() == handList.get(4).getRank())){
            //it's four of a kind if 1'st & 4th elms are same as a hand was ordered in Deck (so this means 1&2&3&4 are all the same)
            System.out.println("You Have FourOfKind!");
        }else{
            chain.evaluate(hand); //go to next chain
            return;//leave function(not important to have return as we're already at end of func but included anyways)
        }
    }
}
