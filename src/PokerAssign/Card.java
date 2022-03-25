package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

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
        this.rank = rank; //11=J, 12=Q, 13=K, 14=A
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
        String rankValue;

        switch (rank) {
            case 1:
                rankValue = "One of ";
                break;
            case 2:
                rankValue = "Two of ";
                break;
            case 3:
                rankValue = "Three of ";
                break;
            case 4:
                rankValue = "Four of ";
                break;
            case 5:
                rankValue = "Five of ";
                break;
            case 6:
                rankValue = "Six of ";
                break;
            case 7:
                rankValue = "Seven of ";
                break;
            case 8:
                rankValue = "Eight of ";
                break;
            case 9:
                rankValue = "Nine of ";
                break;
            case 10:
                rankValue = "Ten of ";
                break;
            case 11:
                rankValue = "Eleven of ";
                break;
            case 12:
                rankValue = "Twelve of ";
                break;
            case 13:
                rankValue = "Thirteen of ";
                break;
            case 14:
                rankValue = "Fourteen of ";
                break;
            default:
                throw new IllegalStateException("Unexpected Rank value: " + rank);
        }

        StringBuffer sb = new StringBuffer();

        sb.append(rankValue).append(suit);

        return sb.toString();
    }
}
