package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.List;

public class RoyalFlush implements Handler {

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
            if(!handList.get(0).getSuit().equals(handList.get(i).getSuit())) {
                chain.evaluate(hand); //go to next chain
                return;//leave function
            }
        }

        //if the ranks match Royal Flush's pattern
        if(handList.get(0).getRank() == 10 && handList.get(1).getRank() == 11 && handList.get(2).getRank() == 12 &&
                handList.get(3).getRank() == 13 && handList.get(4).getRank() == 14){
            System.out.println("You Have RoyalFlush!");
        }else{
            chain.evaluate(hand); //go to next chain
        }

    }
}
