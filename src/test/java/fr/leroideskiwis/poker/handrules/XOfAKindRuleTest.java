package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.*;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class XOfAKindRuleTest {

    private XOfAKindRule xOfAKindRule = new XOfAKindRule();

    @Test
    void testNoXOfAKind() {
        Hand hand = TestUtil.createHighCardHand();
        Optional<EvaluatedRule> result = xOfAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with no pairs");
        hand = TestUtil.createPairHand();
        result = xOfAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with only a pair");
    }

    @Test
    void testThreeOfAKind() {
        Hand hand = TestUtil.createThreeOfAKindHand();
        Optional<EvaluatedRule> result = xOfAKindRule.evaluate(hand);
        assertTrue(result.isPresent(), "Expected three of a kind to be detected");
        assertTrue(result.get().isPokerHand(PokerHand.THREE_OF_A_KIND), "Expected hand to be evaluated as THREE_OF_A_KIND");
        assertEquals(new Card(Rank.TWO), result.get().bestCard);
    }

    @Test
    void testFourOfAKind() {
        Hand hand = TestUtil.createFourOfAKindHand();
        Optional<EvaluatedRule> result = xOfAKindRule.evaluate(hand);
        assertTrue(result.isPresent(), "Expected four of a kind to be detected");
        assertTrue(result.get().isPokerHand(PokerHand.FOUR_OF_A_KIND), "Expected hand to be evaluated as FOUR_OF_A_KIND");
        assertEquals(new Card(Rank.TWO), result.get().bestCard);
    }

}