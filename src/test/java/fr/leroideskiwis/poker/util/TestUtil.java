package fr.leroideskiwis.poker.util;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.Suit;

public class TestUtil {

    public static Hand createPairHand() {
        // Create a hand with a pair of Aces
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.HEARTS)
        );
    }

    public static Hand createThreeOfAKindHand() {
        // Create a hand with three of a kind (Aces)
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.ACE, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.HEARTS)
        );
    }

    public static Hand createFourOfAKindHand() {
        // Create a hand with four of a kind (Aces)
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.ACE, Suit.DIAMONDS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS)
        );
    }

    public static Hand createNoPairHand() {
        // Create a hand with no pairs
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.KING, Suit.SPADES),
                new Card(Rank.QUEEN, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.TEN, Suit.HEARTS)
        );
    }

    public static Hand createTwoPairHand() {
        // Create a hand with two pairs (Aces and Twos)
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.HEARTS)
        );
    }

    public static Hand createFullHouseHand() {
        // Create a hand with a full house (Aces over Twos)
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.ACE, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS)
        );
    }

    public static Hand createStraightHand() {
        // Create a hand with a straight (A, 2, 3, 4, 5)
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.TWO, Suit.SPADES),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.HEARTS)
        );
    }

    public static Hand createFlushHand() {
        // Create a hand with a flush (all hearts)
        return new Hand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.HEARTS),
                new Card(Rank.TEN, Suit.HEARTS)
        );
    }

    public static Hand createStraightFlushHand() {
        // Create a hand with a straight flush (5, 6, 7, 8, 9 of hearts)
        return new Hand(
                new Card(Rank.FIVE, Suit.HEARTS),
                new Card(Rank.SIX, Suit.HEARTS),
                new Card(Rank.SEVEN, Suit.HEARTS),
                new Card(Rank.EIGHT, Suit.HEARTS),
                new Card(Rank.NINE, Suit.HEARTS)
        );
    }

    public static Hand createRoyalFlushHand() {
        // Create a hand with a royal flush (10, J, Q, K, A of hearts)
        return new Hand(
                new Card(Rank.TEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.HEARTS),
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.ACE, Suit.HEARTS)
        );
    }

}
