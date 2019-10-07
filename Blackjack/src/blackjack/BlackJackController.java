package blackjack;

/**
 * The controller of the Blackjack game.
 * For each new game it creates an instance of a Blackjack
 */

public class BlackJackController {
    
    private Blackjack blackjackGame;
    private BlackJackInterface UI;
    
    public static void main(String[] args) {
        BlackJackController game = new BlackJackController();
        game.runGame();
        
    }
    
    /**
    Perpetually runs the game until user indicates otherwise. Runs game in chronological order
     */
    private void runGame() {
        do {
            playOneGame();
        } while (UI.wantToPlayAgain());
        UI.thankPlayer();
    }

    private void playOneGame() {
        blackjackGame = Blackjack.initializeGame(); //create instance of blackjack
        blackjackGame.dealInitialCards();
        
        /** create instance of console view */
        UI = new Console(blackjackGame);
        UI.introduction();
        UI.askNumberOfPlayers();

        for(Person person: blackjackGame.getPlayers()) {
            UI.showInitialHand(person);
           
        }
        System.out.println("----------------------------------" + "\n");
        
        /** give each player a turn until they bust */
        for(Person person: blackjackGame.getPlayers()) {
            System.out.println(person.getName() + "'s TURN: ");
            if(person.getHand().getTotal() > 21) {
                System.out.println("Over 21: Bust!" + "\n"); 
                System.out.println("----------------------------------" + "\n");
                person.isBusted();
                break;
            }else {
                letPersonPlayItsTurn(person);
            }   
        }
       
        /** display the total each step of the way */
        for(Person person: blackjackGame.getPlayers()) {
            UI.displayTotal(person);
        }
        UI.showWinner(blackjackGame.getWinner());
    }
 
    /**
     * Reads input from each Player in the game at each turn. 
     * Continues to deal Player a card as long as he/she says "hit." 
     * Stops when the Player's total value is more than 21. 
     */
    private void letPersonPlayItsTurn(Person person) {
        UI.showHand(person);
        boolean playContinue = true;
        while(playContinue) {
            String userInput = "";
            playContinue = false;
            do {
                if(person.getHand().getTotal() > 21) {
                    System.out.println("Over 21: Bust!" + "\n"); 
                    System.out.println("----------------------------------" + "\n");
                    break;
                }
                userInput = UI.askForTurn(person);
                if (userInput.equals("hit")) {
                    playContinue = true;
                }
            } while (!(userInput.equals("hit") || userInput.equals("stay")));

            if (playContinue) person.wantsToHit();
            UI.showHand(person);
            
        }
        
    }
}
