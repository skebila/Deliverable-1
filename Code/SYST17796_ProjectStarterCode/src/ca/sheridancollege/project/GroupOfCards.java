/**
 * 1201_4081 Project Winter 2020 Base code.
 * @author daniel, 2020
 */

package CardGame;

/**
 * An abstract class "GroupOfCard" for the future UNO Card game project.
 * Will be creating a |LinkedList| of objects (Cards) to represent a new deck,
 * Which later should be (created and shuffled) using appropriate methods inside this class,
 * or it's child, and used inside the main (CardGame) class.
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to create a deck of UNO cards
 * The group of cards has a maximum size, we'll probably should change it later.
 * As a default static value for our game. And implement method to crate a deck and shuffle it.
 */
public class GroupOfCards
{
    /**
     * @param cards - A group of classes of (Cards), stored as an |ArrayList|.
     * @param size  - A size of the group usually finalized (108) for UNO deck.
     */
    private ArrayList<Card> cards; // ArrayList of Cards.
    private int size; // size of the deck.

    /**
     * Constructor which should be changed later or used in a child class with overriding,
     * to set a value or some other stuff if this won't be needed any more.
     * Size of a UNO deck is 108, so later this constructor should not take any parameters,
     * and the field "size" should be set to final.
     * @param size - Setting a size of a deck.
     */
    public GroupOfCards(int size)
    {
        /**
         * Size of a UNO deck is static, so later this constructor should not take any parameters,
         * and the field "size" should be set to final
         **/
        this.size = size;
    }

    /**
     * A method that will be setting our deck inside the CardGame class,
     * as an |ArrayList|, probably after 2 following methods:
     * 1st - creating of a deck method (1 example of all the cards)
     * 2nd - shuffling a deck to represent a game mechanic
     * for simplisity those methods above could be done inside the constructor, so
     * they would be called with the initialisation of this class automatically.
     * @return the group of cards to be set as |ArrayList| deck inside the -(CardGame)->(deck).
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }

    /**
     * A standard shuffling method,at least one other method should to be created before using this one,
     * which will be creating a list of (Cards), with appropriate amount of card values,
     * and suits as mentioned an the game rules.
     */
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * We probably will be using a (deck) |ArrayList| field for storing and withdrawing cards
     * so again, the fields is final so we'll get rid of this code, or will use it in a different way
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * In the future we no longer need to change the size of the deck, it's static,
     * and should be created with the object class inside the constructor
     * so we could get rid of this setter later, if we won't need it for our game
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

}//end class

