package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class OnePairRule implements PokerRule {
    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        Map<Rank, Integer> rankCount = hand.getRankCount();
        return rankCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey()))
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .filter(entry -> entry.getValue() == 2)
                .map(entry -> new EvaluatedRule(
                        PokerHand.ONE_PAIR,
                        new Card(entry.getKey())
                ));
    }
}
