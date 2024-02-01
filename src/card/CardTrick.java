/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Sanjeev  Paudel
 */
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    private static final int MAGIC_HAND_SIZE = 7;

    public static void main(String[] args) {
        Card[] magicHand = initializeMagicHand();

        // Display the magic hand
        displayMagicHand(magicHand);

        // Ask the user for Card value and suit
        Card userCard = getUserCard();

        // Search magicHand for a match
        boolean foundMatch = searchForMatch(magicHand, userCard);

        // Report the result
        reportResult(foundMatch);
    }

    private static Card[] initializeMagicHand() {
        Card[] magicHand = new Card[MAGIC_HAND_SIZE];

        // Add one luck card: hard code 2 of clubs
        Card luckCard = new Card();
        luckCard.setValue(2);
        luckCard.setSuit("Clubs");
        magicHand[0] = luckCard; // Overwrite the first card with the luck card

        // Fill magicHand with random Card objects (excluding the first card)
        for (int i = 1; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomSuitIndex()]);
            magicHand[i] = c;
        }

        return magicHand;
    }

    private static void displayMagicHand(Card[] magicHand) {
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
    }

    private static Card getUserCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.println("Enter a suit (0-3 where 0-Hearts, 1-Diamonds, 2-Clubs, 3-Spades): ");
        int userSuitIndex = scanner.nextInt();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuitIndex]);

        return userCard;
    }

    private static boolean searchForMatch(Card[] magicHand, Card userCard) {
        for (Card card : magicHand) {
            if (card.isMatch(userCard)) {
                return true;
            }
        }
        return false;
    }

    private static void reportResult(boolean foundMatch) {
        if (foundMatch) {
            System.out.println("Congratulations! You found a match in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    // Helper method to generate a random card value (1-13)
    private static int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(13) + 1;
    }

    // Helper method to generate a random suit index (0-3)
    private static int generateRandomSuitIndex() {
        Random random = new Random();
        return random.nextInt(4);
    }
}




