package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnePairRuleTest {

    private OnePairRule onePairRule = new OnePairRule();

    @Test
    void evaluateDoublePair() {
        // Test with a hand that has two pairs
        Hand handWithTwoPairs = TestUtil.createTwoPairHand();
        assertTrue(onePairRule.evaluate(handWithTwoPairs).isPresent(), "Expected one pair to be detected in a hand with two pairs");
    }

    @Test
    void evaluateNoPair(){
        // Test with a hand that does not have two pairs
        Hand handWithoutTwoPairs = TestUtil.createHighCardHand();

        assertFalse(onePairRule.evaluate(handWithoutTwoPairs).isPresent(), "Expected no one pair in hand");
    }

    @Test
    void evaluateSinglePair() {
        // Test with a hand that has only one pair
        Hand handWithOnePair = TestUtil.createPairHand();

        assertTrue(onePairRule.evaluate(handWithOnePair).isPresent(), "Expected one pair to be detected");
    }
}