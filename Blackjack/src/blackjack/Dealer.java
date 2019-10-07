package blackjack;
import java.util.Random;

/**
 * Handles the logic of a Person who is the Dealer in the game.
 */
public class Dealer extends Person{
    private static final int CUSP = 16;

    /**
     * Constructs new instance of the  Dealer. 
     */
    public Dealer(Blackjack blackjack) {
        super("The Dealer", blackjack);
    }
    

    /**
     * Only returns a Hand with the open Cards that all Player instances can see. 
     */
    @Override
    public Hand getOpenHand() {
        Hand hand = new Hand();
        hand.addCardToHand(super.getHand().getCards().peek());
        return hand;
    }

    /**
     * Randomized output for Dealer's auto-generated moves. 
     */
    public String autoWantToHit() {
        if (this.getHand().getTotal() == CUSP) {
            return (new Random().nextBoolean() ? "hit" : "stay");
        }
        return (this.getHand().getTotal() < CUSP ? "hit" : "stay");
    }
}
