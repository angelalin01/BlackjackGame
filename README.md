# BlackjackGame
Console-based Blackjack game implementation in Java.

## Instructions for running your code
- To run a Java program on your computer, first install a Java compiler. You can do this by downloading the Java Development Kit (JDK) from Oracle’s website. 
- Open the Command Prompt. Locate the path to the version of the JDK on your computer. Set the path to the JDK with the “set” command. After properly compiling from source and setting to the right path, run it using the below command : javac BlackJackController.java. 

## Design choices: 

- This implementation of Blackjack follows the MVC, Model-View-Controller, framework, where BlackjackController is the controller of the given instance of the Blackjack game, Console is the “view” of the game in the console window that interfaces with the user, and Blackjack.java is the model that stores the data about the players and deck of cards for the given Blackjack instance. I wanted to make the process as intuitive as possible from the user standpoint when interfacing with the game (thus all the step by step guided statements implemented in the Console), compartmentalizing functionalities into different classes and methods as much as possible to make it clear what my code was doing each step along the way. I represented each aspect of the game with a different object, which I’ve identified as the players, the cards, the logic, and the procedure and outcome of the game (mainly handled by the Blackjack MVC). I created interfaces and parent classes when possible to reduce redundant code. 

- Because both the player and the dealer share common features and capabilities just as anyone who sat at the table to play the game, it made sense to create a parent class called “Person” which “Player” and “Dealer” would both extend, but also be able to perform unique functions on their own— or performance the same functions with different logic. For example, both the “Player” and the “Dealer” would need to choose to “hit” or “stay” but based on the player would give a human response whereas the “Dealer” would be a computer-generated response so method overriding was used to implement the logic corresponding to the specific person. 

- I wanted the console interactions to be as illustrative as possible to ensure the smoothest user experience, thus printing and keeping track of the user’s cumulative total and indicating the appropriate outcome/result each step along the way (e.g., printing “bust” if player’s cards exceed a total of 21) so it’s easy for the user to follow along. I also enabled the game to be single or multi-player. A while loop is used to run each round of the game until the user indicates otherwise and a for loop is used to allow each player in a single game to play their turn, and the respective logic to follow based on their decision (as there are a finite number of players). 

- Data structures used: 
    - LinkedList to represent the deck; LinkedList has constant time for adding and removing elements, given that we are removing a card from the deck each time we draw a next card we want to take advantage of LinkedList’s cheap add/remove operations. Also don’t need random access to elements in the LinkedList. 
    - Priority Queue to represent the hand that each player has; easy to add and remove cards, want to have them in sorted order too.  
    - ArrayList was used to represent the players of the game, which makes it easy to add and remove players as needed as a dynamic data structure. 
    - Enum was the most logical way to represent each card, as the cards are just a predefined list of values hat represent numeric and textual data. 
    
- Tooling: I used Java to program my game given its characteristics of being object-oriented and platform-independent. I wanted more control and customizability over my software design where I could easily define the data type of my data structure as well as the types of operations/functions that can be applied to each structure or class - give this object-oriented programming nature, Java was the most logical choice. Furthermore, Java is also easily movable from one computer system to another and runs on many different systems. I also used the Scanner library in Java as it was the easiest way to parse and read keyboard inputs from the user. 

