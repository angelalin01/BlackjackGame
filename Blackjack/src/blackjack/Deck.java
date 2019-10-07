package blackjack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Deck {
   
    /**
     * Deck that contains a list of all Card instances with 
     * 4 references to each value
     */
    private LinkedList<Card> cards = new LinkedList<Card>();
    
    /**
     * Creates a new deck with 52 cards. 
     */
    public Deck() {
        fillDeckWithAllCards();
    }
    
    public LinkedList<Card> getCards(){
        return this.cards;
    }
    
    /**
     * Handles logic for drawing next card off the deck. 
     * If the deck is empty, automatically refills deck with all 52 cards.
     * Returns the first Card reference on the deck.
     */
    public Card drawNextCard() {
        try {
            return cards.remove();
        } catch (NoSuchElementException e) {
            fillDeckWithAllCards();
            return drawNextCard();
        }
    }
    
   
    
    private void fillDeckWithAllCards() {
        for(Card card: Card.values()) {
           for(int count =1; count<=4; count++) {
               cards.add(card);
           }
        }
        shuffleCards();
    }
    
    /**
     * Shuffles deck
     */
    public void shuffleCards() {
        Collections.shuffle(cards);
    }

}
