package fr.leroideskiwis.poker.handrules.handlers;

import fr.leroideskiwis.poker.*;
import fr.leroideskiwis.poker.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RuleEvaluatorTest {

    private RuleEvaluator ruleEvaluator = new RuleEvaluator();

    @Test
    void evaluateHighCard() {
        // Test with a hand that has a high card
        Hand handWithHighCard = TestUtil.createHighCardHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithHighCard);
        assertTrue(evaluate.isPokerHand(PokerHand.HIGH_CARD), "Expected poker hand to be High Card");
        assertEquals(new Card(Rank.JACK, Suit.CLUBS), evaluate.bestCard, "Expected highest card in hand to be Ace of Hearts");
    }

    @Test
    void evaluatePair() {
        // Test with a hand that has a pair
        Hand handWithPair = TestUtil.createPairHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithPair);
        assertTrue(evaluate.isPokerHand(PokerHand.ONE_PAIR), "Expected poker hand to be One Pair");
        assertEquals(new Card(Rank.ACE), evaluate.bestCard, "Expected highest card in one pair to be Ace");
    }

    @Test
    void evaluateTwoPair() {
        // Test with a hand that has two pairs
        Hand handWithTwoPairs = TestUtil.createTwoPairHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithTwoPairs);
        assertTrue(evaluate.isPokerHand(PokerHand.TWO_PAIR), "Expected poker hand to be Two Pair");
        assertEquals(new Card(Rank.ACE), evaluate.bestCard, "Expected highest card in two pair to be Ace");
    }

    @Test
    void evaluateThreeOfAKind() {
        // Test with a hand that has three of a kind
        Hand handWithThreeOfAKind = TestUtil.createThreeOfAKindHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithThreeOfAKind);
        assertTrue(evaluate.isPokerHand(PokerHand.THREE_OF_A_KIND), "Expected poker hand to be Three of a Kind");
        assertEquals(new Card(Rank.TWO), evaluate.bestCard, "Expected highest card in three of a kind to be Two");
    }

    @Test
    void evaluateStraight() {
        // Test with a hand that has a straight
        Hand handWithStraight = TestUtil.createStraightHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithStraight);
        assertTrue(evaluate.isPokerHand(PokerHand.STRAIGHT), "Expected poker hand to be Straight");
        assertEquals(new Card(Rank.SIX), evaluate.bestCard, "Expected highest card in straight to be Five");
    }

    @Test
    void evaluateFlush() {
        // Test with a hand that has a flush
        Hand handWithFlush = TestUtil.createFlushHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithFlush);
        assertTrue(evaluate.isPokerHand(PokerHand.FLUSH), "Expected poker hand to be Flush");
        assertEquals(new Card(Rank.JACK, Suit.HEARTS), evaluate.bestCard, "Expected highest card in flush to be Ace of Hearts");
    }

    @Test
    void evaluateFullHouse() {
        // Test with a hand that has a full house
        Hand handWithFullHouse = TestUtil.createFullHouseHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithFullHouse);
        assertTrue(evaluate.isPokerHand(PokerHand.FULL_HOUSE), "Expected poker hand to be Full House");
        assertEquals(new Card(Rank.ACE), evaluate.bestCard, "Expected highest card in full house to be Three of Aces");
    }

    @Test
    void evaluateFourOfAKind() {
        // Test with a hand that has four of a kind
        Hand handWithFourOfAKind = TestUtil.createFourOfAKindHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithFourOfAKind);
        assertTrue(evaluate.isPokerHand(PokerHand.FOUR_OF_A_KIND), "Expected poker hand to be Four of a Kind");
        assertEquals(new Card(Rank.TWO), evaluate.bestCard, "Expected highest card in four of a kind to be Two");
    }

    @Test
    void evaluateStraightFlush() {
        // Test with a hand that has a straight flush
        Hand handWithStraightFlush = TestUtil.createStraightFlushHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithStraightFlush);
        assertTrue(evaluate.isPokerHand(PokerHand.STRAIGHT_FLUSH), "Expected poker hand to be Straight Flush");
        assertEquals(new Card(Rank.NINE, Suit.HEARTS), evaluate.bestCard, "Expected highest card in straight flush to be Nine of Hearts");
    }

    @Test
    void evaluateRoyalFlush() {
        // Test with a hand that has a royal flush
        Hand handWithRoyalFlush = TestUtil.createRoyalFlushHand();
        EvaluatedRule evaluate = ruleEvaluator.evaluate(handWithRoyalFlush);
        assertTrue(evaluate.isPokerHand(PokerHand.ROYAL_FLUSH), "Expected poker hand to be Royal Flush");
        assertEquals(new Card(Rank.ACE, Suit.HEARTS), evaluate.bestCard, "Expected highest card in royal flush to be Ace of Hearts");
    }

    @Test
    void royalFlushIfFulLDeck(){
        Hand hand = new Hand();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                hand.addCard(new Card(rank, suit));
            }
        }

        EvaluatedRule evaluate = ruleEvaluator.evaluate(hand);
        assertTrue(evaluate.isPokerHand(PokerHand.ROYAL_FLUSH), "Expected poker hand to be Royal Flush with full deck");
        assertEquals(Rank.ACE, evaluate.bestCard.rank, "Expected highest card in royal flush to be Ace of Spades");
    }
}