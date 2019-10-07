package blackjack;

/**
 * A Person is anyone who sits at the table to play Blackjack.
 */
public class Person {
    //relevant characteristics rach person will have 
    private String name;
    private Hand hand = new Hand();
    private boolean isOver21 = false;
    private Blackjack blackjack;
    
   
    /**
     * Constructs an instance of a Person along with 
     * the instance of the Blackjack game this Person is playing
     */
    public Person(String name, Blackjack blackjack) {
        this.name = name;
        this.blackjack = blackjack;
    }
    //for the dealer 
    public Person(Blackjack blackjack) {
        this.blackjack = blackjack;
    }
    
    /**
     * Returns the current hand of the person. 
     */
    public Hand getHand() {
        return this.hand;
    }
    
    /**
     * Returns the name of the Person.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Adds a card to the Person's hand when Person wants to "hit".
     */
    public void addToHand(Card card) {
        hand.addCardToHand(card);
    }
    
    /**
     * Returns the part of the Hand that is currently viewable to the player. 
     */
    public Hand getOpenHand() {
        return hand;
    }
    
    public void wantsToHit() {
        blackjack.dealCard(this);
    }
    
    /**
     * Only relevant when the Person is the Dealer, 
     * who has to respond by itself instead of waiting for user input.
     */
    public String autoWantToHit() {
        return "";
    }
    
    /**
     * Returns whether the current hand of the Person is over a value of 21. 
     */
    public boolean isOver21Total() {
        return this.isOver21;
    }
    
    /**
     * Sets the boolean indicator to true when a Person's hand is over the
     *  value of 21.
     */
    public void isBusted() {
        this.isOver21 = true;
    }

}
