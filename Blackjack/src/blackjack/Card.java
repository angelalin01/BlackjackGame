package blackjack;

public enum Card implements Comparable<Card> {

    TWO (2,2),
    THREE (3,3),
    FOUR(4,4),
    FIVE(5,5),
    SIX(6,6), 
    SEVEN(7,7),
    EIGHT(8,8), 
    NINE(9,9),
    TEN(10,10),
    JACK(11,10),
    QUEEN(12,10),
    KING(13,10),
    ACE(1,11);
    
    
    private int rank;
    private int value;
    
    private Card(int rank, int value) {
        this.rank = rank;
        this.value = value;
    }
    
    public int getRank() {
        return rank;
    }
    
    public int getValue() {
        return value;
    }
    
    private static final String[] CARD_NAMES = {
            "joker", "ace", "two", "three",
            "four", "five", "six", "seven",
            "eight", "nine", "ten", "jack",
            "queen", "king"
    };
    
    @Override
    public String toString() {
        return CARD_NAMES[rank];
    }
}
