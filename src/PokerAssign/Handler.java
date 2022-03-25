package PokerAssign;

/**
 * @author Saman Fathnazarian
 * StudentNumber: 3119137
 */

public interface Handler {
    void setNext(Handler nextChain);
    void evaluate(Hand hand);
}
