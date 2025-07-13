package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StraightFlushRuleTest {

    private StraightFlushRule straightFlushRule = new StraightFlushRule();

    @Test
    void evaluateStraightFlush() {
        // Test with a hand that has a straight flush
        Hand handWithStraightFlush = TestUtil.createStraightFlushHand();
        Optional<EvaluatedRule> evaluate = straightFlushRule.evaluate(handWithStraightFlush);
        assertTrue(evaluate.isPresent(), "Expected straight flush to be detected");
        assertTrue(evaluate.get().isPokerHand(PokerHand.STRAIGHT_FLUSH));
    }

    @Test
    void evaluateNoStraightFlush() {
        // Test with a hand that does not have a straight flush
        Hand handWithoutStraightFlush = TestUtil.createHighCardHand();
        assertFalse(straightFlushRule.evaluate(handWithoutStraightFlush).isPresent(), "Expected no straight flush in hand");
    }

    @Test
    void evaluateFlush() {
        // Test with a hand that has a flush but not a straight flush
        Hand handWithFlush = TestUtil.createFlushHand();
        assertFalse(straightFlushRule.evaluate(handWithFlush).isPresent(), "Expected no straight flush in hand with flush");
    }

    @Test
    void evaluateStraight() {
        // Test with a hand that has a straight but not a flush
        Hand handWithStraight = TestUtil.createStraightHand();
        assertFalse(straightFlushRule.evaluate(handWithStraight).isPresent(), "Expected no straight flush in hand with straight");
    }

    @Test
    void evaluateRoyalFlush() {
        // Test with a hand that has a straight flush including an Ace
        Hand handWithAceStraightFlush = TestUtil.createRoyalFlushHand();
        Optional<EvaluatedRule> evaluate = straightFlushRule.evaluate(handWithAceStraightFlush);
        assertTrue(evaluate.isPresent(), "Expected straight flush with Ace to be detected");
        assertTrue(evaluate.get().isPokerHand(PokerHand.ROYAL_FLUSH), "Expected poker hand to be Royal Flush");
    }

}