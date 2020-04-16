
package unogameproject;


public class UnoCard{
    /**
     *  Card Factory For Using In UnoCards |UnoCards.createDeck()| method
     *  to retrieve |ArrayList<UnoCard>|
     *
     *  How To Get:
     *      (1) Ordinary Card, - |UnoCard.getOrdinaryCard()|
     *      (2) Action Card, -   |UnoCard.getActionCard()|
     *      (3) Wild Cards -     |UnoCard.getWildCard()|
     *
     *  Possible Values:
     *      (1) Ordinary Card |0-9| of colors |RED, GREEN, BLUE, YELLOW|
     *      (2) Action Card |STOP, REVERSE, DRAW_2| of colors |RED, GREEN, BLUE, YELLOW|
     *      (3) Wild Cards |COLOR, REVERSE_DRAW_2| of color |NONE|
     *
     */


    //-------------------------ENUMS---------------------------------//

    /**
     *  COLORS
     */
    public enum COLORS {
        NONE,
        GREEN,
        RED,
        BLUE,
        YELLOW,
    }

    /**
     *  NUMBERS
     */
    public enum NUMBERS {
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE
    }

    /**
     *  ACTIONS
     */
    public enum ACTIONS {
        STOP,
        REVERSE,
        DRAW_2
    }

    /**
     *  WILD
     */
    public enum WILD {
        COLOR,
        REVERSE_DRAW_4
    }

    //-------------------------FIELDS---------------------------------//

    /**
     *  FIELDS
     */
    private COLORS color;
    private NUMBERS number;
    private ACTIONS action;
    private WILD wild;

    //------------------------FACTORIES--------------------------------//

    /**
     *  ORDINARY CARD INSTANCE
     */
    public static UnoCard getOrdinaryCard (NUMBERS number, COLORS color) {
        return new UnoCard(number, color);
    }

    /**
     *  ACTION CARD INSTANCE
     */
    public static UnoCard getActionCard (ACTIONS action,COLORS color) {
        return new UnoCard(action, color);
    }

    /**
     *  WILD CARD INSTANCE
     */
    public static UnoCard getWildCard (WILD wild) {
        return new UnoCard(wild, COLORS.NONE);
    }

    //----------------------CONSTRUCTORS------------------------------//

    /**
     *  ORDINARY CARD CONSTRUCTOR
     */
    private UnoCard(NUMBERS number, COLORS color) {
        this.number = number;
        this.color = color;
    }

    /**
     *  ACTION CARD CONSTRUCTOR
     */
    private UnoCard(ACTIONS action,COLORS color) {
        this.action = action;
        this.color = color;
    }


    /**
     *  WILD CARD CONSTRUCTOR
     */
    private UnoCard(WILD wild,COLORS color) {
        this.wild = wild;
        this.color = color;
    }

    //---------------------CHECK_CARD_METHODS--------------------------//

    /**
     *  CHECK IF CARD IS ORDINARY
     */
    public boolean isOrdinary() {
        return (this.number != null);
    }

    /**
     *  CHECK IF CARD IS ACTION CARD
     */
    public boolean isAction() {
        return (!isOrdinary() && this.action != null);
    }

    /**
     *  CHECK IF CARD IS WILD CARD
     */
    public boolean isWild() {
        return (!isAction() && this.wild != null);
    }

    //--------------------CHECK_VALUE_METHODS---------------------------//

    /**
     *  CHECK IF CARD CAN BE PLAYED (PLACED ON A PILE)
     */
    public boolean canBePlayed(UnoCard cardToCheck) {
        if(cardToCheck.isOrdinary()) {
            if(this.intValue() == cardToCheck.intValue() || this.hasSameColor(cardToCheck)) {
                return true;
            }
            return false;
        } else if(cardToCheck.isAction()) {
            if(this.hasSameColor(cardToCheck)) {
                return true;
            }
            return false;
        } else if(cardToCheck.isWild()) {
            return true;
        }
        return false;
    }


    /**
     *  CHECK IF CARD HAS THE SAME COLOR
     */
    public boolean hasSameColor(UnoCard cardToCheck) {
        if(this.getColor().equals(cardToCheck.getColor())) {
            return true;
        }
        return false;
    }


    /**
     *  GET INT BASED ON CARD VALUES
     */
    public int intValue() {
        switch (number) {
            case ZERO:  return 0;
            case ONE:   return 1;
            case TWO:   return 2;
            case THREE: return 3;
            case FOUR:  return 4;
            case FIVE:  return 5;
            case SIX:   return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE:  return 9;
            default:   return -1;
        }
    }

    //--------------------STRING_REPRESENTATIONS-------------------------//

    /**
     *  CARD STRING REPRESENTATION
     */
    @Override
    public String toString() {
        if(this.isOrdinary()) {
            return "O UnoCard{" +  "number=" +  number + " " + "color=" + color + '}';
        } else if(this.isAction()) {
            return "A UnoCard{" +  "number=" +  action + " " + "color=" + color + '}';
        } else {
            return "W UnoCard{" +  "number=" +  wild + " " + "color=" + color + '}';
        }
    }

    /**
     *  VALUE STRING REPRESENTATION
     */
    public String getValue() {
        if(this.isOrdinary()) {

            if     (this.number.equals(NUMBERS.ZERO))  return "0     ";
            else if(this.number.equals(NUMBERS.ONE))   return "1     ";
            else if(this.number.equals(NUMBERS.TWO))   return "2     ";
            else if(this.number.equals(NUMBERS.THREE)) return "3     ";
            else if(this.number.equals(NUMBERS.FOUR))  return "4     ";
            else if(this.number.equals(NUMBERS.FIVE))  return "5     ";
            else if(this.number.equals(NUMBERS.SIX))   return "6     ";
            else if(this.number.equals(NUMBERS.SEVEN)) return "7     ";
            else if(this.number.equals(NUMBERS.EIGHT)) return "8     ";
            else if(this.number.equals(NUMBERS.NINE))  return "9     ";
            else                                       return "ERROR ";

        } else if(this.isAction()) {

            if     (this.action.equals(ACTIONS.STOP))      return "  STOP";
            else if(this.action.equals(ACTIONS.REVERSE))   return "REVERS";
            else if(this.action.equals(ACTIONS.DRAW_2))    return "DRAW_2";
            else                                           return " ERROR";

        } else if(this.isWild()){

            if     (this.wild.equals(WILD.COLOR))            return " COLOR";
            else if(this.wild.equals(WILD.REVERSE_DRAW_4))   return "RE-DRA";
            else                                             return " ERROR";
        }
        return " ERROR";
    }

    /**
     *  COLOR STRING REPRESENTATION
     */
    public String getColor() {
        if(this.color.equals(COLORS.NONE))        return "⛭WILD";
        else if(this.color.equals(COLORS.RED))    return "   RED";
        else if(this.color.equals(COLORS.GREEN))  return " GREEN";
        else if(this.color.equals(COLORS.BLUE))   return "  BLUE";
        else if(this.color.equals(COLORS.YELLOW)) return "YELLOW";
        return " ERROR";
    }
}
