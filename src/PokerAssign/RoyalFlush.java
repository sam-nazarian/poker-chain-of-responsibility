package PokerAssign;
//DONE
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
            if(!handList.get(0).suit.equals(handList.get(i).suit)) {
                chain.evaluate(hand); //go to next chain
                return;//leave function
            }
        }

        //if the ranks match Royal Flush's pattern
        if(handList.get(0).rank == 10 && handList.get(1).rank == 11 && handList.get(2).rank == 12 &&
                handList.get(3).rank == 13 && handList.get(4).rank == 14){
            System.out.println("You Have RoyalFlush!");
        }else{
            chain.evaluate(hand); //go to next chain
        }

    }
}
