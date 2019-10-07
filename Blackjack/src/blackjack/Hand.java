package blackjack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

/**
 * A Hand object hodls a collection of Card Instances. 
 * Each Person in the game has a Hand. 
 */
public class Hand {
    
    private Queue<Card> cards  = new PriorityQueue<Card>();
    
    /**
     * Adds a Card to the collection.
     */
    public void addCardToHand(Card card) {
        cards.add(card);
    }
    
    /**
     * Returns the cards in the Hand instance.
     */
    public Queue<Card> getCards(){
        return cards;
    }
    
    /**
     * Returns the total value of the cards in the Hand.
     * If  there are aces, returns the highes value under 22. 
     */
    public int getTotal() {
        int total = 0;
        //if there are aces, counts the highest value under 22
        int aceTotal = 0;
        for(Card card: cards) {
            total = total + card.getValue();
        }
        aceTotal = total;
        for(Card card: cards) {
            if(card.getRank() == 1) {
                aceTotal = total - 10;
            }
        }
        if(aceTotal > 0 && aceTotal < 22) {
            return aceTotal;
        }else {
            return total;
       }
        
    }
    
    /**
     * Overrides toString for this class to easily print out 
     * the rank of the card. 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nHand:\n");
        for (Card card : cards) {
            sb.append(card).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1); // remove last new line
        return sb.toString();
    }

}
