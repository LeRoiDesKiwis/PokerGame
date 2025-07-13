package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.*;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindRuleTest {

    private FourOfAKindRule fourofAKindRule = new FourOfAKindRule();

    @Test
    void testNoXOfAKind() {
        Hand hand = TestUtil.createHighCardHand();
        Optional<EvaluatedRule> result = fourofAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with no pairs");
        hand = TestUtil.createPairHand();
        result = fourofAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with only a pair");
    }

    @Test
    void testThreeOfAKind() {
        Hand hand = TestUtil.createThreeOfAKindHand();
        Optional<EvaluatedRule> result = fourofAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected three of a kind to be detected");
    }

    @Test
    void testFourOfAKind() {
        Hand hand = TestUtil.createFourOfAKindHand();
        Optional<EvaluatedRule> result = fourofAKindRule.evaluate(hand);
        assertTrue(result.isPresent(), "Expected four of a kind to be detected");
        assertTrue(result.get().isPokerHand(PokerHand.FOUR_OF_A_KIND), "Expected hand to be evaluated as FOUR_OF_A_KIND");
        assertEquals(new Card(Rank.TWO), result.get().bestCard);
    }

}