/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogameproject;

import java.util.ArrayList;

public class UnoPlayer {

    /**
     *  Representation of a player to use inside UnoGame class as an ArrayList of <UnoPlayer>
     *      Every player has a hand
     *      - At the beginning of the turn draws 7 cards by default
     *      - Wins if the hand equals 0
     *      - May exit the game if its his turn:
     *          -In this case cards get returned to the deck
     *
     */

    //--------------------------FIELDS--------------------------------//

    // PLAYER NUMBER
    private int playerNumber;

    // PLAYER HAND
    private ArrayList<UnoCard> hand;

    //-----------------------CONSTRUCTORS-----------------------------//

    // CONSTRUCTOR
    public UnoPlayer(int playerNumber) {
        this.playerNumber = playerNumber;
        hand = new ArrayList<>();
    }

    //-------------------------METHODS--------------------------------//

    public int getPlayerNumber() {
        return playerNumber;
    }

    public ArrayList<UnoCard> getHand() {
        return hand;
    }

    public boolean hasCards() {
        if(hand.size() > 0) {
            return true;
        }
        return false;
    }

    //PLAY CARD
    public boolean playCard(int cardNumberToPlay, UnoPile pileToPlaceCard) {
        if(cardNumberToPlay < 0 || cardNumberToPlay > hand.size()) {
            return false;
        } else {
            if(pileToPlaceCard.placeCard(hand.get(cardNumberToPlay -1))) {
                hand.remove(cardNumberToPlay -1);
                return true;
            }
            return false;
        }
    }

    // DRAW CARDS
    public boolean drawCards(UnoDeck deckToDrawFrom, int numberOfCardsToDraw) {
        if(deckToDrawFrom.hasMoreCards(numberOfCardsToDraw)) {
            for(int i = 0; i < numberOfCardsToDraw; i++) {
                hand.add(UnoDeck.drawCard());
            }
        }
        return false;
    }

    //------------------STRING_REPRESENTATION-----------------------//

    // PAINT PLAYER'S HAND TO CONSOLE
    public void paintPlayerHand() {
        if(hand == null || hand.size() == 0) {
            System.out.println("PLAYER " + playerNumber + " HAND IS NULL OR EMPTY");
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append("---PLAYER---" + playerNumber + "------MAKE------YOUR------MOVE----------------------------------------");
            sb.append("\n");
            sb.append("\n");

            for(int i = 0; i < hand.size(); i++) {
                sb.append("   CARD_" + (i+1) + "   ");
            }
            sb.append("\n");
            for(int i = 0; i < hand.size(); i++) {
                sb.append(" ---------- ");
            }
            sb.append("\n");
            for(int i = 0; i < hand.size(); i++) {
                sb.append("| -" + hand.get(i).getColor() + "- |");
            }
            sb.append("\n");
            for(int i = 0; i < hand.size(); i++) {
                sb.append("|          |");
            }
            sb.append("\n");
            for(int i = 0; i < hand.size(); i++) {
                sb.append("| -" + hand.get(i).getValue() + "- |");
            }
            sb.append("\n");
            for(int i = 0; i < hand.size(); i++) {
                sb.append(" ---------- ");
            }
            System.out.println(sb.toString());
        }
    }

}
