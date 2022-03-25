package Poker;

import java.util.Random;

public class Deck 
{
  
	private final int DECK_SIZE = 52;
	private final int SHUFFLE_EXCHANGES = 2000;
	private final int HAND_SIZE = 5;
	public int restOfDeck = 6;
	
	Card[] deck = new Card[DECK_SIZE]; //an array of cards
	Random r = new Random(); //creating random instance
	
	// fill deck with cards
	public void fillDeck()
	{
		int counter = 0; //currentCardBeingRead
		for (int suit = 1; suit <= 4; suit++)
		{
			for (int rank = 1; rank <= 13; rank++)
			{
				deck[counter] = new Card();
				deck[counter].suit = suit;
				deck[counter].rank = rank;
				counter++;
			}
		}
	}

	//don't make mistake of storing values
//	/**
//	 * Select 2 random cards, swap their positions, due this SHUFFLE_AMOUNT(1500) times
//	 */
//	public void shuffle() {
//		for (int i = 0; i < SHUFFLE_AMOUNT; i++) {
//			int rndIndex1 = rnd.nextInt(DECK_SIZE); //rnd num between 0&51, as deck array starts from 0 & ends at 51
//			PokerAssign.Card card1 = deck[rndIndex1]; //james, stores value not index
//			int rndIndex2 = rnd.nextInt(DECK_SIZE);
//			PokerAssign.Card card2 = deck[rndIndex2]; //hassan
//
//			//swap the two randomly selected cards
//			PokerAssign.Card temp = card1;
//			card1 = card2; //hassan, here we're storing values
//			card2 = temp; //james
//		}
//	}

	// shuffle deck
	public void shuffle()
	{
		for (int x = 0; x <= SHUFFLE_EXCHANGES; x++)
		{
			int number1 = r.nextInt(DECK_SIZE); //generates random value from 0-51
			int number2 = r.nextInt(DECK_SIZE);

			//swap number 1 & number 2, due this SHUFFLE_EXCHANGES amount of times
			Card temp = deck[number1];
			deck[number1] = deck[number2];
			deck[number2] = temp;
		}
	}
	
	// deals 5 cards
	public Card[] deal()
	{
		Card[] hand = new Card[HAND_SIZE];
		for (int deckPosition = 0; deckPosition < 5; deckPosition++)
		{
			hand[deckPosition] = deck[deckPosition];
		}
		return hand;
	}
	
	// deals cards for redraw
	public Card redeal()
	{
		Card nextCard = deck[restOfDeck];
		restOfDeck++;
		return nextCard;
	}
	
	// refreshes deck position to 6 for next hand
	public void refreshDeckPosition()
	{
		restOfDeck = 6;
	}

}
