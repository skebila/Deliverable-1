package unogameproject;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UnoGame {

    /**
     *  Singleton game class
     *
     *  How To Use:
     *
     *    (1)  -Create a game: |UnoGame.startGame()|
     *
     *    (2)  -To get a deck: |UnoGame.getDeck()|
     *
     *    (3)  -Set players:   |UnoGame.setPlayers(int number)|
     *
     *    (4)  -Draw 7 cards at the beginning of  a game:
     *
     *                         |UnoGame.startGame()|
     *
     *    (5)  -Create a game: |UnoGame.startGame()|
     *
     *    (6)  -Show score:    |UnoGame.()|
     *
     *    (7)  -End a game:    |UnoGame.endGame()|
     *
     *
     */

    //-------------------------FIELDS---------------------------------//

    // INSTANCE
    private static UnoGame instance;

    // PLAYERS
    private static List<UnoPlayer> players;

    // NUMBER OF PLAYERS
    private static int numberOfPlayers;

    // GAME DECK
    private static UnoDeck deck;

    // GAME PILE
    private static UnoPile pile;

    // DIRECTION OF THE GAME (RIGHT SIDE BY DEFAULT | FALSE)
    private static boolean gameDirection;

    // PLAYERS ITERATOR
    private static ListIterator<UnoPlayer> playerTurns;

    // PLAYER TO MAKE NEXT MOVE
    private static UnoPlayer playerToMakeNextMove;

    //---------------------------INSTANCES---------------------------------//

    // GET INSTANCE
    public static void startGame() {
        System.out.println("Initializing a new game...");
        resetFields();
        createFields();
    }

    // RESET FIELDS
    public static void resetFields() {
        instance = null;
        deck = null;
        players = null;
        numberOfPlayers = 0;
        pile = null;
        gameDirection = false;
        playerTurns = null;
        playerToMakeNextMove = null;
    }

    // RECREATE FIELDS
    private static void createFields() {
        instance = new UnoGame();
        deck = UnoDeck.getInstance();
        players = null;
        numberOfPlayers = 0;
        // set a card from a created deck as a start card
        pile = UnoPile.getInstance(deck.drawCard());
        playerTurns = null;
        playerToMakeNextMove = null;
    }

    // END GAME
    public static void endGame() {
        resetFields();
    }

    //--------------------------CONSTRUCTOR-------------------------------//

    private UnoGame() {

    }

    //----------------------------METHODS---------------------------------//

    //
    public static boolean setPlayers(int numberOfPlayers) {
        if(numberOfPlayers < 2 || numberOfPlayers > 10) {
            // WRONG NUMBER OF PLAYERS
            System.out.println("Wrong number of players.");
            return false;
        }
        UnoGame.numberOfPlayers = numberOfPlayers;
        System.out.println("The number of players is: " + UnoGame.numberOfPlayers);
        players = new ArrayList<>();
        for(int i = 0; i < UnoGame.numberOfPlayers; i++) {
            players.add(new UnoPlayer(i+1));
        }
        UnoGame.fillPlayersHands(deck);
        playerTurns = players.listIterator();
        return true;
    }


    public static UnoPlayer setNextPlayerToMakeMove() {
        if(gameDirection) {
            if(playerTurns.hasNext()) {
                playerToMakeNextMove = playerTurns.next();
            } else {
                playerTurns = players.listIterator();
                playerToMakeNextMove = playerTurns.next();
            }
        } else {
            if(playerTurns.hasPrevious()) {
                playerToMakeNextMove = playerTurns.previous();
            } else {
                playerTurns = players.listIterator(players.size());
                playerToMakeNextMove = playerTurns.previous();
            }
        }
        return null;
    }

    // EVERY PLAYER DRAWS 7 CARDS AT THE BEGINNING OF A GAME
    private static void fillPlayersHands(UnoDeck deckToDrawFrom) {
        for(int i = 0; i < players.size(); i++) {
            players.get(i).drawCards(deckToDrawFrom, 7);
        }
    }
    //
    public static int LowerScoreNumber() {
        int score = Integer.MAX_VALUE;
        if(players.size() > 0) {
            for (int i = 0; i < players.size(); i++) {
                if(players.get(i).getHand().size() < score) {
                    score = players.get(i).getHand().size();
                }
            }
            return score;
        }
        return score;
    }

    // SHOW FINAL SCORE
    public static void showScore() {
        if(players.size() > 0) {
            for (int i = 0; i < players.size(); i++) {
                System.out.println();
            }
        }
    }

    public static boolean makeMove(int cardToPlay) {
        if(playerToMakeNextMove.playCard(cardToPlay, pile)) {
            return true;
        }
        return false;
    }

    public static void unsetPlayer() {
        System.out.println(playerToMakeNextMove.getPlayerNumber() + " has left the game.");
        players.remove(playerToMakeNextMove);
        playerTurns = players.listIterator();
    }

    public static void skipTurn() {
        System.out.println(playerToMakeNextMove.getPlayerNumber() + " has skipped his turn.");

    }

    // CHECK WIN CONDITION
    public static boolean checkWinCondition() {
        if(deck.getSize() == 0) {
            System.out.println("The deck is empty, stop the game.");
            return true;
        }
        for(UnoPlayer possibleWinner : players) {
            if(!possibleWinner.hasCards()) {
                System.out.println(possibleWinner.getPlayerNumber() + " player wins, he's got 0 cards.");
                return true;
            }
        }
        return false;
    }

    public static void showPlayerOptions() {
        pile.printPile();
        playerToMakeNextMove.paintPlayerHand();
    }


    // CHANGE THE GAME DIRECTION
    public void changeGameDirection() {
        if(gameDirection) {
            gameDirection = false;
        }
        gameDirection = true;
    }

    //------------------------GETTERS_AND SETTERS-------------------------//


    public List<UnoPlayer> getPlayers() {
        return players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public boolean isGameDirection() {
        return gameDirection;
    }

    public void setGameDirection(boolean gameDirection) {
        this.gameDirection = gameDirection;
    }

    public static UnoDeck getDeck() {
        return deck;
    }

    // TESTS OF CLASS FUNCTIONALITY
    public static void main(String[] args) {

    }
}
