/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogameproject;

import java.util.ArrayList;
import java.util.Collections;

public class UnoCards {

    /**
     * Singleton Class Representing The Entity Of A Deck
     *              (Made For Using Inside UnoDeck)
     *
     *      - Not Possible To Create An Instance Of This Class
     *      - Only To Get |ArrayList| Of <UnoCard>
     *
     *  How To Get:
     *      |UnoCards.createDeck()| -> ArrayList<UnoCard>
     *
     */

    // |-------------------------------------------------------------------------------------------------------------------------|
    // |   TOTAL-(4)   |   TOTAL-(72)  |    TOTAL-(8)   |    TOTAL-(8)    |    TOTAL-(8)    |    TOTAL-(4)    |    TOTAL-(4)     |
    // |-------------------------------------------------------------------------------------------------------------------------|
    // |(RGBY)-(NORMAL)|(RGBY)-(NORMAL)|(RGBY)-(ACTION) |(RGBY)-(ACTION)  |(RGBY)-(ACTION)  |(NONE)----(WILD) |(NONE)----(WILD)  |
    // |  |            |  |            |  |             |  |              |  |              |  |              |  |               |
    // |  |            |  |            |  |             |  |              |  |              |  |              |  |               |
    // |  |            |  |            |  |             |  |              |  |              |  |              |  |      (DRAW-   |
    // | (4) * (0)     | (8) * (1-9)   | (8) * (STOP)   | (8) * (REVERSE) | (8) * (DRAW)    | (4) *(COLOR)    | (4) * -REVERSE)  |
    // |--------------=----------------------------------------------------------------------------------------------------------|
    // |                                              OVERALL TOTAL (108)                                                        |
    // |-------------------------------------------------------------------------------------------------------------------------|



    //-------------------------FIELDS---------------------------------//

    // UNO DECK INSTANCE
//    private static ArrayList<UnoCard> deck;

    //-----------------------CONSTRUCTORS-----------------------------//

    private UnoCards() {
        // PASS...
    }

    //-------------------------METHODS--------------------------------//

    // GET DECK
//    public static ArrayList<UnoCard> getDeck() {
//        if(deck != null) {
//            deleteDeck();
//        }
//        createDeck();
//        return deck;
//    }
//
//    // DELETE INSTANCE
//    public static void deleteDeck() {
//        deck = null;

//    }

    // CREATE DECK INSTANCE
    public static ArrayList<UnoCard> createDeck() {

        int zeroFlag = 0;

//        if(deck == null) {
//            deck = new ArrayList<>();
//        }

        ArrayList<UnoCard> deck = new ArrayList<>();
        // DECK INITIALIZATION PROCESS
        // 76 ORDINARY CARDS
        for(int i = 0; i < 2; i++) {
            for(UnoCard.NUMBERS number : UnoCard.NUMBERS.values()) {
                for(UnoCard.COLORS color : UnoCard.COLORS.values()) {
                    if(!color.equals(UnoCard.COLORS.NONE)) {

                        if(number.equals(UnoCard.NUMBERS.ZERO) && zeroFlag < 4) {
                            zeroFlag++;
                            deck.add(UnoCard.getOrdinaryCard(number, color));
                        } else if(number.equals(UnoCard.NUMBERS.ZERO) && zeroFlag > 3) {
                            // PASS...
                            // NUMBER IS ZERO HERE FOR MORE THAN 4 TIMES
                            // SO WE DONT NEED TO ADD IT
                            // SINCE WE HAVE ONLY 4 0s IN OUR DECK
                        } else {
                            deck.add(UnoCard.getOrdinaryCard(number, color));
                        }
                    }
                }
            }
        }

        // 24 ACTION CARDS
        for(int i = 0; i < 2; i++) {
            for(UnoCard.ACTIONS action : UnoCard.ACTIONS.values()) {
                for(UnoCard.COLORS color : UnoCard.COLORS.values()) {
                    if(!color.equals(UnoCard.COLORS.NONE)) {
                        deck.add(UnoCard.getActionCard(action, color));
                    }
                }
            }
        }

        // 8 WILD CARDS
        for(int i = 0; i < 4 ; i++) {
            for(UnoCard.WILD wild : UnoCard.WILD.values()) {
                deck.add(UnoCard.getWildCard(wild));
            }
        }

        // SHUFFLING PROCESS
        Collections.shuffle(deck);
        return deck;
    }

}
