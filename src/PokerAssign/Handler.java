package PokerAssign;

public interface Handler {
    void setNext(Handler nextChain);
    void evaluate(Hand hand);
}

//    private Handler setNext;
//    int a = 0;
//    void processRequest(Purchase purchase);
