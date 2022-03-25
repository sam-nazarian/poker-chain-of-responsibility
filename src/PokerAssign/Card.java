package PokerAssign;

public class Card {
    String suit;
    int rank;

    //Constructor
    public Card(int suitNumber, int rank){
        String suitValue;

        switch (suitNumber) {
            case 1:
                suitValue = "Spade";
                break;
            case 2:
                suitValue = "Club";
                break;
            case 3:
                suitValue = "Heart";
                break;
            case 4:
                suitValue = "Diamond";
                break;
            default:
                throw new IllegalStateException("Unexpected Suit value: " + suitNumber);
        }

        this.suit = suitValue;
        this.rank = rank;
    }

    //Setters & Getters
    public String getSuit() {
        return suit;
    }
    public int getRank() {
        return rank;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }
}
