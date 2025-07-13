package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluatedRuleTest {
    private EvaluatedRule evaluatedRule1;

    private EvaluatedRule evaluatedRule2;

    @Test
    void testCompareTo() {
        evaluatedRule1 = new EvaluatedRule(PokerHand.HIGH_CARD, new Card(Rank.ACE, Suit.HEARTS));
        evaluatedRule2 = new EvaluatedRule(PokerHand.HIGH_CARD, new Card(Rank.KING, Suit.SPADES));

        assertTrue(evaluatedRule1.compareTo(evaluatedRule2) > 0);

        evaluatedRule2 = new EvaluatedRule(PokerHand.ONE_PAIR, new Card(Rank.TWO, Suit.DIAMONDS));

        assertTrue(evaluatedRule1.compareTo(evaluatedRule2) < 0);

        evaluatedRule2 = new EvaluatedRule(PokerHand.HIGH_CARD, new Card(Rank.ACE, Suit.CLUBS));

        assertEquals(0, evaluatedRule1.compareTo(evaluatedRule2));
    }

}