/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogameproject;


import java.util.ArrayList;

public class UnoDeck {
    /**
     * Singleton 108 card Game Deck
     *
     *  How To Get Instance:
     *      |UnoDeck.getInstance|
     *      -returns UnoDeck instance
     *
     *
     *  To delete:
     *      |UnoDeck.deleteDeck|
     *      -deletes instance and all containing information
     *
     *  To Draw Cards:
     *      |UnoDeck.drawCards(int numberOfCardsToDraw)|
     *      -returns |false| if the deck will contain (0) cards after withdrawal
     */

    //-----------------------FIELDS-----------------------------//

     // INSTANCE
    private static UnoDeck instance = null;

     // ArrayList OF CARDS
    private static ArrayList<UnoCard> deck = null;

    //-----------------------INSTANCES-----------------------------//

    // GET INSTANCE
    public static UnoDeck getInstance() {
        if(instance == null) {
            instance = new UnoDeck();
        }
        reCreateDeck();
        return instance;
    }

    // GET DECK
    public static void reCreateDeck() {
        deleteDeck();
        deck = UnoCards.createDeck();
    }

    // DELETE A DECK
    public static void deleteDeck() {
        deck = null;
    }

    //-----------------------CONSTRUCTORS-----------------------------//

    // PRIVATE CONSTRUCTOR
    private UnoDeck() {
        // SOME INITIALIZATIONS IF NEEDED...
    }

    //-----------------------METHODS-----------------------------//


//    public static ArrayList<UnoCard> getDeck() {
//        return deck;
//    }


    public static UnoCard drawCard() {
        if(deck != null) {
            if(hasMoreCards(1)) {
//                System.out.println("HAS CARDS TO DRAW");
                return deck.remove(0);
            }
        }
//        System.out.println("NO CARDS TO DRAW");
        return null;
    }

    // HAS MORE CARDS THAN INT
    public static boolean hasMoreCards(int numberToCheck) {
        if(deck != null) {
            return deck.size() >= numberToCheck;
        }
        return false;
    }

    public int  getSize() {
        if(deck.equals(null)) {
            System.out.println("DECK WAS NOT CREATED YET");
            return -1;
        }
        return deck.size();
    }

}
