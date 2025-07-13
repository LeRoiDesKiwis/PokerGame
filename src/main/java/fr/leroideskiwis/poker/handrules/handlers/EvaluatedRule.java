package fr.leroideskiwis.poker.handrules.handlers;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.PokerHand;

import java.util.Locale;

public class EvaluatedRule implements Comparable<EvaluatedRule> {

    public final PokerHand hand;
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

    @Override
    public String toString() {
        return hand.toString().toLowerCase(Locale.ROOT).replace("_", " ");
    }
}