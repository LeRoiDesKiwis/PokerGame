package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.PokerHand;

public class EvaluatedRule implements Comparable<EvaluatedRule> {

    private final PokerHand hand;
    public final Card bestCard;

    public EvaluatedRule(PokerHand hand, Card bestCard) {
        this.hand = hand;
        this.bestCard = bestCard;
    }

    @Override
    public int compareTo(EvaluatedRule o) {
        int handComparison = this.hand.compareTo(o.hand);
        if (handComparison != 0) return handComparison;
        return this.bestCard.compareTo(o.bestCard);
    }

    public boolean isPokerHand(PokerHand pokerHand) {
        return hand == pokerHand;
    }
}