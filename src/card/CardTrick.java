package card;
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Add one lucky card: hard code 7 of Hearts
        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit("Hearts");
        magicHand[0] = luckyCard; // Overwrite the first card with the lucky card

        // Fill magicHand with random Card objects (excluding the first card)
        for (int i = 1; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomSuitIndex()]);
            magicHand[i] = c;
        }

        // Ask the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.println("Enter your card suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.next();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search magicHand for a match
        boolean foundMatch = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                foundMatch = true;
                break;
            }
        }

        // Report the result
        if (foundMatch) {
            System.out.println("Congratulations! You found a match in the magic hand.");
        } else {
            System.out.println("Sorry! No match found in the magic hand.");
        }

        // Close the scanner
        scanner.close();
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
