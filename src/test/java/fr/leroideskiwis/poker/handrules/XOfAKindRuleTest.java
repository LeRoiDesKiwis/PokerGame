package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class XOfAKindRuleTest {

    private XOfAKindRule xOfAKindRule = new XOfAKindRule();

    private Hand createPair(){
        return new Hand(new Card(Rank.ACE, Suit.HEARTS),
                        new Card(Rank.ACE, Suit.SPADES),
                        new Card(Rank.TWO, Suit.DIAMONDS),
                        new Card(Rank.THREE, Suit.CLUBS),
                        new Card(Rank.FOUR, Suit.HEARTS));
    }

    private Hand createThreeOfAKind() {
        return new Hand(new Card(Rank.ACE, Suit.HEARTS),
                        new Card(Rank.ACE, Suit.SPADES),
                        new Card(Rank.ACE, Suit.DIAMONDS),
                        new Card(Rank.TWO, Suit.CLUBS),
                        new Card(Rank.THREE, Suit.HEARTS));
    }

    private Hand createHandWithNoPairs() {
        return new Hand(new Card(Rank.ACE, Suit.HEARTS),
                        new Card(Rank.KING, Suit.SPADES),
                        new Card(Rank.QUEEN, Suit.DIAMONDS),
                        new Card(Rank.JACK, Suit.CLUBS),
                        new Card(Rank.TEN, Suit.HEARTS));
    }

    private Hand createHandWithFourOfAKind() {
        return new Hand(new Card(Rank.ACE, Suit.HEARTS),
                        new Card(Rank.ACE, Suit.SPADES),
                        new Card(Rank.ACE, Suit.DIAMONDS),
                        new Card(Rank.ACE, Suit.CLUBS),
                        new Card(Rank.TWO, Suit.HEARTS));
    }

    @Test
    void testNoXOfAKind() {
        Hand hand = createHandWithNoPairs();
        Optional<EvaluatedRule> result = xOfAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with no pairs");
        hand = createPair();
        result = xOfAKindRule.evaluate(hand);
        assertFalse(result.isPresent(), "Expected no X of a kind in hand with only a pair");
    }

    @Test
    void testThreeOfAKind() {
        Hand hand = createThreeOfAKind();
        Optional<EvaluatedRule> result = xOfAKindRule.evaluate(hand);
        assertTrue(result.isPresent(), "Expected three of a kind to be detected");
        assertTrue(result.get().isPokerHand(PokerHand.THREE_OF_A_KIND), "Expected hand to be evaluated as THREE_OF_A_KIND");
    }

    @Test
    void testFourOfAKind() {
        Hand hand = createHandWithFourOfAKind();
        Optional<EvaluatedRule> result = xOfAKindRule.evaluate(hand);
        assertTrue(result.isPresent(), "Expected four of a kind to be detected");
        assertTrue(result.get().isPokerHand(PokerHand.FOUR_OF_A_KIND), "Expected hand to be evaluated as FOUR_OF_A_KIND");
    }

}