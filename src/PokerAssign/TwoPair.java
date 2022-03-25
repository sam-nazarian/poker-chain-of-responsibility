package PokerAssign;

import java.util.List;

public class TwoPair implements Handler{
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {
        List<Card> handList = hand.getHand();

        int count = 0;
        for(int i=1; i<hand.getHandSize(); i++){
            int curr = handList.get(i).getRank();
            int prev = handList.get(i-1).getRank(); //only need a var of prev

            if(curr == prev){
                count++;
            }
        }

        if(count == 2){
            System.out.println("You Have TwoPair!");
            return;
        }else{
            chain.evaluate(hand); //go to next chain
            return;
        }

    }
}
