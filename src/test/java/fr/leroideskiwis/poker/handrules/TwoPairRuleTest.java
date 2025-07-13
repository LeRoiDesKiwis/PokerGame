package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.Suit;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairRuleTest {

    private TwoPairRule twoPairRule = new TwoPairRule();

    @Test
    void evaluateDoublePair() {
        // Test with a hand that has two pairs
        Hand handWithTwoPairs = TestUtil.createTwoPairHand();
        assertTrue(twoPairRule.evaluate(handWithTwoPairs).isPresent(), "Expected two pairs to be detected");
    }

    @Test
    void evaluateNoPair(){
        // Test with a hand that does not have two pairs
        Hand handWithoutTwoPairs = TestUtil.createHighCardHand();

        assertFalse(twoPairRule.evaluate(handWithoutTwoPairs).isPresent(), "Expected no two pairs in hand");
    }

    @Test
    void evaluateSinglePair() {
        // Test with a hand that has only one pair
        Hand handWithOnePair = TestUtil.createPairHand();

        assertFalse(twoPairRule.evaluate(handWithOnePair).isPresent(), "Expected no two pairs in hand with only one pair");
    }
}