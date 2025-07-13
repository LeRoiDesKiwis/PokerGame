package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.*;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairRuleTest {

    private TwoPairRule twoPairRule = new TwoPairRule();

    @Test
    void evaluateDoublePair() {
        // Test with a hand that has two pairs
        Hand handWithTwoPairs = TestUtil.createTwoPairHand();
        Optional<EvaluatedRule> evaluate = twoPairRule.evaluate(handWithTwoPairs);
        assertTrue(evaluate.isPresent(), "Expected two pairs to be detected");
        assertTrue(evaluate.get().isPokerHand(PokerHand.TWO_PAIR), "Expected hand to be evaluated as TWO_PAIR");
        assertEquals(new Card(Rank.ACE), evaluate.get().bestCard, "Expected best card to be the highest pair");
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