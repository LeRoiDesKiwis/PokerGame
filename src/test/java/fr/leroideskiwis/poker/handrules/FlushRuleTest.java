package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.*;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FlushRuleTest {

    private FlushRule flushRule = new FlushRule();

    @Test
    public void testEvaluateFlush() {
        // Test with a hand that has a flush
        Hand handWithFlush = TestUtil.createFlushHand();
        Optional<EvaluatedRule> evaluate = flushRule.evaluate(handWithFlush);
        assertTrue(evaluate.isPresent(), "Expected flush to be detected");
        assertTrue(evaluate.get().isPokerHand(PokerHand.FLUSH), "Expected poker hand to be Flush");
        assertEquals(new Card(Rank.JACK, Suit.HEARTS), evaluate.get().bestCard, "Expected highest card in flush to be Jack of Hearts");

    }

    @Test
    public void testEvaluateNoFlush() {
        // Test with a hand that does not have a flush
        Hand handWithoutFlush = TestUtil.createHighCardHand();
        assertFalse(flushRule.evaluate(handWithoutFlush).isPresent(), "Expected no flush in hand");
    }

}