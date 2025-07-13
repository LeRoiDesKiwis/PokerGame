package fr.leroideskiwis.poker;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @org.junit.jupiter.api.Test
    void testCompareTo() {
        Card card1 = new Card(Rank.ACE, Suit.HEARTS);
        Card card2 = new Card(Rank.KING, Suit.SPADES);
        Card card3 = new Card(Rank.ACE, Suit.CLUBS);

        assertTrue(card1.compareTo(card2) > 0, "ACE should be greater than KING");
        assertTrue(card2.compareTo(card1) < 0, "KING should be less than ACE");
        assertEquals(0, card1.compareTo(card3), "Two Aces should be equal regardless of suit");
    }

}