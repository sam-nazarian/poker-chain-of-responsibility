package PokerAssign;

import java.util.List;

public class FullHouse implements Handler {
    private Handler chain;

    //Setter, sets chain to value of next
    @Override
    public void setNext(Handler next) {
        chain = next;
    }

    @Override
    public void evaluate(Hand hand) {
        List<Card> handList = hand.getHand();

        //if curr == prev, 3 times, then it's going to be a full house
        int count = 0;
        for(int i=1; i<hand.getHandSize(); i++){
            int current = handList.get(i).getRank();
            int prev = handList.get(i-1).getRank();

            if(current == prev){
                count++;
            }
        }
        if(count == 3){
            System.out.println("You Have FullHouse!");
        }else{
            chain.evaluate(hand); //go to next chain
            return;//leave function(not important to have return as we're already at end of func but included anyways)
        }

    }
}

//  Instead of above, I could also do this, I left it for myself as a note. TA you can ignore.

//it's four of a kind, if 1'st & 3rd elms are same & 4th & 5th elms are also same

//        if(handList.get(0).getRank() == handList.get(2).getRank() && handList.get(3).getRank() == handList.get(4).getRank()){
//            //it's four of a kind, if 1'st & 3rd elms are same & 4th & 5th elms are also same
//            System.out.println("You Have FullHouse!");
//        }else{
//            chain.evaluate(hand); //go to next chain
//            return;//leave function(not important to have return as we're already at end of func but included anyways)
//        }
