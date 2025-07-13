package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StraightRuleTest {

    private StraightRule straightRule = new StraightRule();

    @Test
    public void testEvaluateStraight() {
        // Test with a hand that has a straight
        Hand handWithStraight = TestUtil.createStraightHand();
        Optional<EvaluatedRule> evaluate = straightRule.evaluate(handWithStraight);
        assertTrue(evaluate.isPresent(), "Expected straight to be detected");
        assertTrue(evaluate.get().isPokerHand(PokerHand.STRAIGHT), "Expected hand to be evaluated as STRAIGHT");
        assertEquals(new Card(Rank.SIX), evaluate.get().bestCard, "Expected best card to be the highest card in the straight");
    }

    @Test
    public void testEvaluateNoStraight() {
        // Test with a hand that does not have a straight
        Hand handWithoutStraight = TestUtil.createHighCardHand();
        assertFalse(straightRule.evaluate(handWithoutStraight).isPresent(), "Expected no straight in hand");
    }

    @Test
    public void testEvaluateFlush() {
        // Test with a hand that has a flush
        Hand handWithFlush = TestUtil.createFlushHand();
        assertFalse(straightRule.evaluate(handWithFlush).isPresent(), "Expected no straight in hand with flush");
    }

}