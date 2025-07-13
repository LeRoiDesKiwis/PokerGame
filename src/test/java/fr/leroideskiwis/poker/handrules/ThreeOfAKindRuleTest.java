package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeOfAKindRuleTest {

    private ThreeOfAKindRule threeOfAKindRule = new ThreeOfAKindRule();

    @Test
    void testNoXOfAKind() {
        Hand hand = TestUtil.createHighCardHand();
        Optional<EvaluatedRule> result = threeOfAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with no pairs");
        hand = TestUtil.createPairHand();
        result = threeOfAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with only a pair");
    }

    @Test
    void testThreeOfAKind() {
        Hand hand = TestUtil.createThreeOfAKindHand();
        Optional<EvaluatedRule> result = threeOfAKindRule.evaluate(hand);
        assertTrue(result.isPresent(), "Expected three of a kind to be detected");
        assertTrue(result.get().isPokerHand(PokerHand.THREE_OF_A_KIND), "Expected hand to be evaluated as THREE_OF_A_KIND");
        assertEquals(new Card(Rank.TWO), result.get().bestCard);
    }
}
