package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightRuleTest {

    private StraightRule straightRule = new StraightRule();

    @Test
    public void testEvaluateStraight() {
        // Test with a hand that has a straight
        Hand handWithStraight = TestUtil.createStraightHand();
        assertTrue(straightRule.evaluate(handWithStraight).isPresent(), "Expected straight to be detected");
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