package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

import java.util.Comparator;

/**
 * sort hand by cardRank in ascending order
 */
public class SortCard implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if(o1.getRank() < o2.getRank()) {
            return -1;
        }else if(o1.getRank() > o2.getRank()) {
            return 1;
        }else{
            return 0;
        }
    }
}
