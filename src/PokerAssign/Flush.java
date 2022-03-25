package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.List;

public class Flush implements Handler{
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {
        List<Card> handList = hand.getHand();

        //check if all values all same suit
        for(int i=1; i<hand.getHandSize(); i++){
            if(!handList.get(0).suit.equals(handList.get(i).suit)) {
                chain.evaluate(hand); //go to next chain
                return;//leave function
            }
        }

        System.out.println("You Have Flush!");
    }
}
