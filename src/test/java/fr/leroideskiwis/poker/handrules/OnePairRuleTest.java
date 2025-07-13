package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OnePairRuleTest {

    private OnePairRule onePairRule = new OnePairRule();

    @Test
    void evaluateDoublePair() {
        // Test with a hand that has two pairs
        Hand handWithTwoPairs = TestUtil.createTwoPairHand();
        Optional<EvaluatedRule> evaluate = onePairRule.evaluate(handWithTwoPairs);
        assertTrue(evaluate.isPresent(), "Expected one pair to be detected in a hand with two pairs");
        assertTrue(evaluate.get().isPokerHand(PokerHand.ONE_PAIR), "Expected poker hand to be One Pair");
        assertEquals(new Card(Rank.ACE), evaluate.get().bestCard, "Expected highest card in one pair to be Ace");
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

        Optional<EvaluatedRule> evaluate = onePairRule.evaluate(handWithOnePair);
        assertTrue(evaluate.isPresent(), "Expected one pair to be detected");
        assertTrue(evaluate.get().isPokerHand(PokerHand.ONE_PAIR), "Expected poker hand to be One Pair");
        assertEquals(new Card(Rank.ACE), evaluate.get().bestCard, "Expected highest card in one pair to be Ace");

    }
}