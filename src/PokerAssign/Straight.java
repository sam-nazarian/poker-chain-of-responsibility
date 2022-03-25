package PokerAssign;

import java.util.List;

public class Straight implements Handler{
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {
        List<Card> handList = hand.getHand();

        for(int i=1; i<hand.getHandSize(); i++){

            int current = handList.get(i).getRank(); //new current (here i points to current)
            int prev = handList.get(i-1).getRank(); //set prev

            if(current != prev+1){ //prev value must be 1 smaller than current if it's Straight
                chain.evaluate(hand); //go to next chain
                return;
            }
        }

        System.out.println("You Have Straight!");
    }
}
