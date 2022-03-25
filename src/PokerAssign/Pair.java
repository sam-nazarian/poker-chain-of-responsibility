package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.List;

public class Pair implements Handler{
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {

        int count = 0;
        for(int i=1; i<hand.getHandSize(); i++){
            List<Card> handList = hand.getHand();

            int curr = handList.get(i).getRank();
            int prev = handList.get(i-1).getRank();

            if(curr == prev){
                count++;
            }
        }

        if(count == 1 ){
            System.out.println("You Have Pair!");
            return;
        }else{
            chain.evaluate(hand); //go to next chain
            return;
        }

    }
}
