package PokerAssign;

import java.util.List;

public class ThreeOfKind implements Handler{
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {
        List<Card> handList = hand.getHand();

        for(int i=0; i<hand.getHandSize(); i++){
            int repeatingCount = 0;
            for(int j=i+1; j< hand.getHandSize(); j++){

                if(handList.get(i).getRank() == handList.get(j).getRank()){
                    repeatingCount++;
                }

                if(repeatingCount == 2){
                    System.out.println("You Have ThreeOfKind!");
                    return;
                }
            }
        }

        chain.evaluate(hand); //go to next chain
        return; //not essential to have return but good to have
    }
}
