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

class FullHouseRuleTest {

    private FullHouseRule fullHouseRule = new FullHouseRule();

    @Test
    void evaluateFullHouse() {
        // Test with a hand that has a full house
        Hand handWithFullHouse = TestUtil.createFullHouseHand();
        Optional<EvaluatedRule> evaluate = fullHouseRule.evaluate(handWithFullHouse);
        assertTrue(evaluate.isPresent(), "Expected full house to be detected");
        assertTrue(evaluate.get().isPokerHand(PokerHand.FULL_HOUSE), "Expected poker hand to be Full House");
        assertEquals(new Card(Rank.ACE), evaluate.get().bestCard, "Expected highest card in full house to be Three of Aces");
    }

    @Test
    void evaluateNoFullHouse() {
        // Test with a hand that does not have a full house
        Hand handWithoutFullHouse = TestUtil.createHighCardHand();
        assertFalse(fullHouseRule.evaluate(handWithoutFullHouse).isPresent(), "Expected no full house in hand");
    }

    @Test
    void evaluatePair() {
        // Test with a hand that has only a pair
        Hand handWithPair = TestUtil.createPairHand();
        assertFalse(fullHouseRule.evaluate(handWithPair).isPresent(), "Expected no full house in hand with only a pair");
    }

    @Test
    void evaluateThreeOfAKind() {
        // Test with a hand that has only three of a kind
        Hand handWithThreeOfAKind = TestUtil.createThreeOfAKindHand();
        assertFalse(fullHouseRule.evaluate(handWithThreeOfAKind).isPresent(), "Expected no full house in hand with only three of a kind");
    }

}