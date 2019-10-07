package blackjack;
import java.util.Scanner;
import java.util.Queue;

/**
 * Represents the view of the game in the console. This is the interface the user will be interacting with. 
 */ 
public class Console implements BlackJackInterface {
    
    private Blackjack blackjack;
    private Scanner keyboard = new Scanner(System.in);
    
    public Console(Blackjack blackjack) {
        this.blackjack = blackjack;
    }

    @Override
    public void introduction() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Here are the initial cards that are dealt." + "\n");
        
    }
    
    @Override
    public void askNumberOfPlayers() {
        System.out.println("How many players are there?");
        String input = keyboard.nextLine();
        int playersNum = Integer.valueOf(input);
        String[] playerNames = new String[playersNum];
        for(int i=0; i<playersNum; i++) {
            System.out.println("Player" + i + " Name:" + "\n");
            String nameInput = keyboard.nextLine();
            playerNames[i] = nameInput;
        }
        this.blackjack.addPlayers(playerNames);
    }

    @Override
    public void showInitialHand(Person person) {
        Hand hand = person.getHand();
        Queue<Card> cards = hand.getCards();
        String name = person.getName();
        System.out.println(name + " has" + hand.toString());
        
    }

    @Override
    public void showHand(Person person) {
        Hand hand = person.getHand();
        Queue<Card> cards = hand.getCards();
        String name = person.getName();
        System.out.println(name + " has:" + hand.toString());
        System.out.println("This is a total of " + hand.getTotal() + "." + "\n");
        
    }


    public String askForTurn(Person person) {
        System.out.print("Do you want to 'hit' or 'stay'? " + "\n");
        String aiResponse = person.autoWantToHit();
        if (aiResponse.length() > 0) {
            System.out.print(aiResponse + "\n");
            return aiResponse;
        }
        return keyboard.nextLine();
    }
    
    @Override
    public void displayTotal(Person person) {
        
        String name = person.getName();
        int total = person.getHand().getTotal();
        System.out.println(name + " has total of  " + total + "." + "\n");
        
    }

    @Override
    public void showWinner(Person person) {
        String name = person.getName();
        System.out.println(name  + " is the winner!" + "\n");      
    }

    @Override
    public boolean wantToPlayAgain() {
        System.out.println("Do you want to play again? Please respond 'y' or 'n'." + "\n");
        String input = keyboard.nextLine();
        if(input.equals("y") || input.equals("n")) {
            return (input.equals("y"));
        }else { // if user does not hit "y" or "n"
            return wantToPlayAgain();
        }
        
    }

    @Override
    public void thankPlayer() {
        System.out.println("Thanks for playing!" + "\n");
        
    }
    
    
}
