/**
 * 1201_4081 Project Winter 2020 Base code.
 * @author daniel, 2020
 */

package CardGame;

/**
 * An abstract class "Card" for the future UNO Card game project.
 * Will be working as an object inside (GroupOfCards) -> |LinkedList| to represent a deck
 * @author daniel, 2020
 */

public abstract class Card
{
    public Enum Value; // ENUM with all the possible values of UNO cards
    public Enum Suit; // ENUM with all the possible suits of UNO cards

    /**
     * A base constructor, to set a value and suit of an object of this class
     * need to create these fields in a real implementation of this class,
     * there is no need not to make them final, so we dont need setters in this class.
     */

    public Card() {
        // This constructor should set our final values
    }

    /**
     * @return a String representation of a UNO card.
     */

    @Override
    public abstract String toString(); // String representation of a card

}
