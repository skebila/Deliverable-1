/**
 * 1201_4081 Project Winter 2020 Base code.
 * @author daniel, 2020
 */

package CardGame;

/**
 * A class that models each (Player) in the game. Players have an identifier, which should be unique.
 * Each identifier could be like (1 - n), or if the game is online,
 * we could set it to user's id in a database.
 * Each player has his hand of cards, and turn in the game (Game) class.
 * and when 1 player takes his turn all the other players are permitted only to watch,
 * waiting for their turns.
 */
public abstract class Player
{
    private String playerID; //the unique ID for this player

    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String name)
    {
        playerID= name;
    }

    /**
     * @return the playerID
     */
    public String getPlayerID()
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID)
    {
        playerID = givenID;
    }

    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();

}


