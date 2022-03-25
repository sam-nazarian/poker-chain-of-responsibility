package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.List;

public class HighCard implements Handler{
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {
        List<Card> handList = hand.getHand();

        //no next here, this is the last Object in chain

        //since cards are ordered in ascending order of ranks, the highest rank is the last rank
        System.out.println("You Have A High Card! Your high card is: " + handList.get(4));
        return;
    }
}
