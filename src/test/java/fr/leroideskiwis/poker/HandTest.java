package fr.leroideskiwis.poker;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    private Hand hand = new Hand(
            new Card(Rank.ACE, Suit.HEARTS),
            new Card(Rank.ACE, Suit.SPADES),
            new Card(Rank.TWO, Suit.DIAMONDS),
            new Card(Rank.THREE, Suit.CLUBS),
            new Card(Rank.FOUR, Suit.HEARTS)
    );


    @Test
    void getRankCount() {

        Map<Rank, Integer> rankCount = hand.getRankCount();
        assertEquals(2, rankCount.get(Rank.ACE).intValue(), "There should be 2 Aces in the hand");
        assertEquals(1, rankCount.get(Rank.TWO).intValue(), "There should be 1 Two in the hand");
        assertEquals(1, rankCount.get(Rank.THREE).intValue(), "There should be 1 Three in the hand");
        assertEquals(1, rankCount.get(Rank.FOUR).intValue(), "There should be 1 Four in the hand");
    }

    @Test
    void getBestCard() {
        Card bestCard = hand.getBestCard();
        assertEquals(new Card(Rank.ACE, Suit.HEARTS), bestCard, "The best card should be the Ace of Hearts");
    }
}