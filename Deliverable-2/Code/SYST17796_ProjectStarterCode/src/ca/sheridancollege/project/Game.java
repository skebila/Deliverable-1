/**
 * 1201_4081 Project Winter 2020 Base code.
 * @author daniel, 2020
 */

package CardGame;

/**
 * The class that models a game, where everything will happen. AKA "main" class
 * Here we will declare players, their hands, game deck some game mechanics, and so on...
 * We should create a more specific child of this class and instantiate the methods given.
 */

import java.util.ArrayList;

public abstract class Game
{
    /**
     * @param gameName The title of the game, - "UNO"
     */
    private final String gameName;//the title of the game
    /**
     * @param players A set of (Players) for our game, who will be taking a part.
     */
    private ArrayList <Player> players;// the players of the game

    /**
     * A default constructor which will be overriding.
     * Here we should have a specified number of players for setting.
     * @param givenName the name of our game static value "UNO"
     */
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName()
    {
        return gameName;
    }

    /**
     * @return the players of this game as an ArrayList of (Players) in the future implementation
     */
    public ArrayList <Player> getPlayers()
    {
        return players;
    }

    /**
     * @param players the players of this game, either should be declared before the game,
     * in the class game constructor, or we need to create a more suitable solution for us.
     */
    public void setPlayers(ArrayList <Player> players)
    {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();



}//end class
