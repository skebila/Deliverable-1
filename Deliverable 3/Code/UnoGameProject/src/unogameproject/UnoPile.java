/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogameproject;


public class UnoPile {

    private static UnoPile instance = null;

    private static UnoCard pileCard = null;

    public static UnoPile getInstance(UnoCard card) {
        if(instance == null) {
            instance = new UnoPile();
        }
        pileCard = card;
        return instance;
    }

    private UnoPile() {

    }

    // PLACE CARD
    public static boolean placeCard(UnoCard cardToPlace) {
        if(cardToPlace.canBePlayed(pileCard)) {
            System.out.println("Card " + cardToPlace.toString() + " was placed on the pile...");
            pileCard = cardToPlace;
        }
        return false;
    }

    public UnoCard getPileCard() {
        return pileCard;
    }

    public void printPile() {
        if(pileCard == null) {
            System.out.println("NO PILE CARD EXCEPTION");
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append("_______________________"+ "OR PRINT Q TO EXIT THE GAME" +"_________________________________");
            sb.append("\n");

                sb.append("                                     ---------- ");
            sb.append("\n");
                sb.append("                                    | -" + pileCard.getColor() + "- |");
            sb.append("\n");
                sb.append("______A CARD PLACED ON THE PILE ->  |          |  <- A CARD PLACED ON THE PILE_____");
            sb.append("\n");
                sb.append("                                    | -" + pileCard.getValue() + "- |");
            sb.append("\n");
                sb.append("                                     ---------- ");

            System.out.println(sb.toString());
        }

    }
}
