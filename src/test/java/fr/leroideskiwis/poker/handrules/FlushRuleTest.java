package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlushRuleTest {

    private FlushRule flushRule = new FlushRule();

    @Test
    public void testEvaluateFlush() {
        // Test with a hand that has a flush
        Hand handWithFlush = TestUtil.createFlushHand();
        assertTrue(flushRule.evaluate(handWithFlush).isPresent(), "Expected flush to be detected");
    }

    @Test
    public void testEvaluateNoFlush() {
        // Test with a hand that does not have a flush
        Hand handWithoutFlush = TestUtil.createHighCardHand();
        assertFalse(flushRule.evaluate(handWithoutFlush).isPresent(), "Expected no flush in hand");
    }

}