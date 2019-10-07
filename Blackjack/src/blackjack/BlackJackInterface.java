package blackjack;

/**
 * Interface for creating the view of the blackjack game 
 */
public interface BlackJackInterface {
    /**
     * Displays the welcome message 
     */
    public void introduction();
    
    /**
     * Gets user input on number of players, allowing 
     * for it to be both single and multiplayer game. 
     */
    public void askNumberOfPlayers();
    
    /**
     * Displays the contents of the initial instances in a 
     * Person's hand as it is viewable for the player. 
     */
    public void showInitialHand(Person person);
    
    /**
     * Displays the contents of the instances in a Person's hand 
     * and displays the total value of that hand. 
     */
    public void showHand(Person person);
    
    /**
     * Asks if the player wants to hit or stay.
     */
    public String askForTurn(Person person);
    
    /**
     * Displays the total value of a Person's hand. 
     */
    public void displayTotal(Person person);
    
    /**
     * Shows who the winner is. 
     */
    public  void showWinner(Person person);
    
    /**
     * Asks whether the user wants to play another round. 
     */
    public boolean wantToPlayAgain();
    
    /**
     * Thanks player at the end. 
     */
    public void thankPlayer();
}
