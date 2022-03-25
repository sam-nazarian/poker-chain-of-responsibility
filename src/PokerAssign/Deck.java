package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.*;

public class Deck {

    private final int DECK_SIZE = 52;
    private final int SHUFFLE_AMOUNT = 1500;
    private int handCounter = 0; //used in dealHand()

    private Hand hand = new Hand();
    private Random rnd = new Random();

    private int handSize = hand.getHandSize(); //default is 5

    private Card[] deck = new Card[DECK_SIZE]; //an array of cards

    /**
     * Fills Array of deck, (11=J, 12=Q, 13=K, 14=A)
     */
    public void fillDeck() {
        int cardCount = 0;
        for (int rank = 2; rank <= 14; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                deck[cardCount] = new Card(suit, rank);
                cardCount++;
            }
        }
    }

    /**
     * Select 2 random cards, swap their positions, due this SHUFFLE_AMOUNT(1500) times
     */
    public void shuffle() {
        for (int i = 0; i < SHUFFLE_AMOUNT; i++) {
            int rndIndex1 = rnd.nextInt(DECK_SIZE); //rnd num between 0&51, as deck array starts from 0 & ends at 51
            int rndIndex2 = rnd.nextInt(DECK_SIZE);

            //swap the two randomly selected cards
            Card temp = deck[rndIndex1];

            //we want to change the deckArray, not just the values
            deck[rndIndex1] = deck[rndIndex2];
            deck[rndIndex2] = temp;
        }
    }

    /**
     * Gets next 5 elm of deck puts it in a handList(ArrayList) then sorts list(by asc rank).
     * Finally, set the List in Hand class to the list that was just made.
     * @throws Exception if not enough cards to make a hand
     */
    void dealHand() throws Exception {
        List<Card> handList = new ArrayList<>();

        //checking to see if there's enough cards to have a hand
        if (handCounter + 5 > 51) { //51 is last index in a deck
            throw new Exception("No more cards exist to have another hand. Please resetHand, & then shuffle again.");
        }

        for (int i = handCounter; i < handCounter + handSize; i++) {
            //handList should always be 0...5 but deck should keep updating
            handList.add(deck[i]);

//            handList[i-handCounter] = deck[i]; If using an array do this, (note for myself just ignore)
        }

//        sort hand arrayList by cardRank in ascending order
        Collections.sort(handList, new SortCard()); //sort hand by cardRank in ascending order

        //change arrayList of hand to current one that was just made
        hand.setHand(handList);

        handCounter += handSize; //next hand will start at 0+5 (5) so cards won't be repeated
        //another solution is to use an arrayList for deck & remove 1st elm of arrayList(deck), so it doesn't get repeated
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
