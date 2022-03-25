package PokerAssign;

import java.util.Comparator;

/**
 * sort hand by cardRank in ascending order
 */
public class SortCard implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if(o1.rank < o2.rank) {
            return -1;
        }else if(o1.rank > o2.rank) {
            return 1;
        }else{
            return 0;
        }
    }
}
