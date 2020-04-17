
package unogameproject;

import java.util.*;

public class Main {
    // GAME SCANNER
    static Scanner scanner = new Scanner(System.in);


    // USER INPUT
    static String userInput;


    public static void main(String[] args) {

        System.out.println("|-----------------------------------|UNO GAME|------------------------------------------|");

        // START A GAME
        UnoGame.startGame();

        // GET NUMBER OF PLAYERS
        System.out.println("Enter an int number of players (2-10): ");

        userInput = scanner.nextLine();

        // SET PLAYERS
        while(!inputIsNumber() || !UnoGame.setPlayers(inputAsNumber())) {
            System.out.println("Your input is invalid.");
            System.out.println("Enter an int number of players (2-10): ");
            userInput = scanner.nextLine();
        }

        // GAME FLOW
        while(!UnoGame.checkWinCondition()) {

            UnoGame.setNextPlayerToMakeMove();

            while(true) {

                UnoGame.showPlayerOptions();
                System.out.println("You have 20 seconds to make your move...");
                System.out.println("Enter ('q'-to leave the game, 'int'-to play a card, Enter-to skip your turn): ");

                // GET USER OPTION
                userInput = scanner.nextLine();

                // EXIT THIS LOOP OF THE USER HAS CHOSEN TO LEAVE OR SKIP
                if(processUserInput()) {
                    if(userInput.equals("")) {
                        UnoGame.drawOneCard();
                    }
                    break;
                }
                if(!inputIsNumber()) {
                    System.out.println("Invalid input.");
                    continue;
                }
                if(UnoGame.makeMove(inputAsNumber())) {
                    break;
                }
            }
        }
        System.out.println("SCORE");

        UnoGame.showScore();
        UnoGame.endGame();
    }

    public static boolean inputIsNumber() {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int inputAsNumber() {
        try {
            Integer.parseInt(userInput);
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean processUserInput() {
        if(userInput.equals("q")) {
            UnoGame.unsetPlayer();
            return true;
        } else if(userInput.equals("")) {
            UnoGame.skipTurn();
            return true;
        }
        return false;
    }

}
