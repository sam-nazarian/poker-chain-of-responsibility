package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.List;

public class StraightFlush implements Handler {
    private Handler chain;

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

        //here i points to Curr Value
        for(int i=1; i<hand.getHandSize(); i++){

            int current = handList.get(i).getRank(); //new current (here i points to current)
            int prev = handList.get(i-1).getRank(); //set prev

            if(current != prev+1){
                chain.evaluate(hand); //go to next chain
                return;
            }
        }

        System.out.println("You Have StraightFlush!");

    }
}

// Below is just a note for myself, I first did it this way & it didn't work, so it's just a reminder for me to know why it didn't work. You can ignore it.

//here i points to Prev Value
//if prev is one greater than current by 1, every time then it's a straight
//        int prev = handList.get(0).getRank();
//        int current = handList.get(1).getRank();
//        for(int i=1; i<hand.getHandSize(); i++){
//            if(current != prev+1){
//                chain.evaluate(hand); //go to next chain
//                return;
//            }
//
//            prev = handList.get(i).getRank(); //set prev, (here i points to previous)
//            current = handList.get(i+1).getRank(); //new current
//        }

//        int prev = handList.get(0).getRank();
//        int current = handList.get(1).getRank();