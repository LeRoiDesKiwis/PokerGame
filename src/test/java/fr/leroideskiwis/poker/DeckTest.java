package fr.leroideskiwis.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void drawCard() {
        Card drawnCard = deck.drawCard();
        assertNotNull(drawnCard, "Drawn card should not be null");
        assertEquals(51, deck.size(), "Deck should have less than 52 cards after drawing one");
    }

    @Test
    void drawAllCards() {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            Card drawnCard = deck.drawCard();
            assertFalse(drawnCards.contains(drawnCard), "Drawn card should not be drawn again");
            drawnCards.add(drawnCard);
            assertEquals(51-i, deck.size(), "Deck should have " + (51 - i) + " cards after drawing " + (i + 1) + " cards");
        }
        assertEquals(0, deck.size(), "Deck should be empty after drawing all cards");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            deck.drawCard();
        });
        assertEquals("No cards left in the deck", exception.getMessage());
    }
}