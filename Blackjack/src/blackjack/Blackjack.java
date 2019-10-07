package blackjack;

import java.util.List;
import java.util.ArrayList;


/**
 * Contains the data of the people involved in game and deck
 * Adds players and deals initial cards
 */ 

public class Blackjack {
    private List<Person> players = new ArrayList<Person>();
    private Deck deck = new Deck();

    /**
     * Returns the list of players in the game including the dealer
     */
    
    public List<Person> getPlayers(){
        return players;
    }
    
    /**
     * Factory method to get a new instance of a Blackjack game 
     */ 
    public static Blackjack initializeGame() {
        return new Blackjack();
    }
    
    /**
     * Returns the current deck of cards used for the game
     */
    public Deck getDeck() {
        return deck;
    }
    
    /**
     * Method for adding players to the game. Dealer automatically included. 
     */
    public void addPlayers(String[] playerNames) {
        //add dealer then all the players
        players.add(0, new Dealer(this));
        for(String playerName : playerNames) {
            Player newGuy = new Player(playerName, this);
            players.add(0, newGuy);
        }
    }
    
    /**
     * Deals a new card for the respective person's turn. 
     */
    public void dealCard(Person person) {
        Card card = deck.drawNextCard();
        person.addToHand(card);
    }
    
    /**
     * Deals initial set of cards. 
     */
    public void dealInitialCards() {
        for(Person pers : players) {
            dealCard(pers);
        }
    }
    
    /**
     * Handles logic for getting the winner of the game. 
     * If the dealer busts, the player wins.
     * If the dealer and player tie but don't bust, the dealer wins. 
     */
    public Person getWinner() {
        int highestScore = 0;
        //removes person from the players list if their hand has a value over
        //21 as that indicates an automatic loss. 
        for(Person pers: players) {
            if(pers.isOver21Total()) {
                players.remove(pers);
            }
        }
        Person winner = players.get(0);
        for(Person pers: players) {
           if(pers.getHand().getTotal() <= 21 &&  pers.getHand().getTotal() >= highestScore) {
               highestScore = pers.getHand().getTotal();
               winner = pers;
           }
        }
        return winner;
    }
    
}
