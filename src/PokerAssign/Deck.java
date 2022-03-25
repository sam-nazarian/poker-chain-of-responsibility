package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.*;

public class Deck {

    private final int DECK_SIZE = 52;
    private final int SHUFFLE_AMOUNT = 1500;
    int handCounter = 0; //used in dealHand()

    Hand hand = new Hand();
    Random rnd = new Random();

    private int handSize = hand.getHandSize(); //default is 5

    Card[] deck = new Card[DECK_SIZE]; //an array of cards
//    Card[] handArray = new Card[handSize]; //an array of cards

    public void fillDeck() {
        int cardCount = 0;
        for (int rank = 2; rank <= 14; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                deck[cardCount] = new Card(suit, rank);
                cardCount++;
            }
        }

//        for(int i=0; i<handSize; i++) handList.add(new Card(1,0));//in dealHand() we will set value of each index
        //because in an arrayList you can't do arrayList[0] = value; we need to do arrayList.set(0,value); can only do set when we already have a value.
        //btw this is why I don't like arrayLists :(
    }

    /**
     * Select 2 random cards, swap their positions, due this SHUFFLE_AMOUNT(1500) times
     */
    public void shuffle() {
        for (int i = 0; i < SHUFFLE_AMOUNT; i++) {
            int rndIndex1 = rnd.nextInt(DECK_SIZE); //rnd num between 0&51, as deck array starts from 0 & ends at 51
//            Card card1 = deck[rndIndex1]; //james, stores value not index
            int rndIndex2 = rnd.nextInt(DECK_SIZE);
//            Card card2 = deck[rndIndex2]; //hassan

            //swap the two randomly selected cards

            Card temp = deck[rndIndex1];

            //we want to change the deckArray, not just the values
            deck[rndIndex1] = deck[rndIndex2];
            deck[rndIndex2] = temp;
//            card1 = card2; //hassan, here we're storing values
//            card2 = temp; //james
        }
    }

    //passes array to hand
    void dealHand() throws Exception {
        List<Card> handList = new ArrayList<>();

        //checking to see if there's enough cards to have a hand
        if (handCounter + 5 > 51) { //51 is last index in a deck
            throw new Exception("No more cards exist to have another hand. Please resetHand, & then shuffle again.");
        }

        for (int i = handCounter; i < handCounter + handSize; i++) {
//            System.out.println(i-handCounter);
//            System.out.println("loop");
            //handList should always be 0...5 but deck should keep updating
//            handList.add(i - handCounter, deck[i]); //need to do to put elms in list inorder to use set
//            handList.set(i - handCounter, deck[i]);
            handList.add(deck[i]);

//            System.out.println(i - handCounter);
        }
//        System.out.println("hello");

        //sort the array, based on suit rank
        Collections.sort(handList, new SortCard()); //sort hand by cardRank in ascending order

        //set hand
        hand.setHand(handList);

        handCounter += handSize; //next hand will start at 0+5 (5) so cards won't be repeated
        //another solution is to use an arrayList & remove 1st elm of arrayList, so it doesn't get repeated
        // (but I preferred using arrays hence I used a handCounter to not repeat elements)
    }

    void resetHand() {
        handCounter = 0;
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Deck{" +
                ", deck=" + Arrays.toString(deck) +
                '}';
    }
}
