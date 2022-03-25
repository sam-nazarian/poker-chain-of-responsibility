package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws Exception {

        //Setting Winning Hands Poker
        Handler c1 = new RoyalFlush(); //first one that happens
        Handler c2 = new StraightFlush();
        Handler c3 = new FourOfKind();
        Handler c4 = new FullHouse();
        Handler c5 = new Flush();
        Handler c6 = new Straight();
        Handler c7 = new ThreeOfKind();
        Handler c8 = new TwoPair();
        Handler c9 = new Pair();
        Handler c10 = new HighCard();

        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);
        c4.setNext(c5);
        c5.setNext(c6);
        c6.setNext(c7);
        c7.setNext(c8);
        c8.setNext(c9);
        c9.setNext(c10);

        //Creating Deck
        Deck deck = new Deck();
        deck.fillDeck();
        deck.shuffle();

        //Dealing A Hand 10 Times & Getting Their Evaluation
        System.out.println();//add a line break at beginning, makes it easier to read
        for(int i=0; i<10; i++) {
            deck.dealHand();
            Hand hand = deck.getHand();
            System.out.println(hand);
            c1.evaluate(hand);
            System.out.println();//line break
        }

        //PLEASE USE THE BELOW TO TEST THE HANDLER'S CHILDREN CLASSES
        //BUT KEEP IN MIND, RANKS OF AN ARRAYLIST NEED TO BE IN ORDER OTHERWISE IT WON'T WORK
        /*
        //create a hand where values are custom, for testing Handler's children classes
        Hand customHand = new Hand();
        List<Card> handList = new ArrayList<>();
        handList.add(new Card(1,2));
        handList.add(new Card(1,3));
        handList.add(new Card(1,4));
        handList.add(new Card(2,5));
        handList.add(new Card(2,7));
        customHand.setHand(handList);

        System.out.println(customHand);
        c1.evaluate(customHand); //testing with our custom Hand
        */
    }
}