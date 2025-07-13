package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;

import java.util.Optional;
import java.util.stream.Collectors;

public class FlushRule implements PokerRule{
    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        int i = hand.stream().map(card -> card.suit).collect(Collectors.groupingBy(card -> card, Collectors.summingInt(_ -> 1))).size();
        if(i == 1) return Optional.of(new EvaluatedRule(PokerHand.FLUSH, hand.getBestCard()));
        return Optional.empty();
    }
}
