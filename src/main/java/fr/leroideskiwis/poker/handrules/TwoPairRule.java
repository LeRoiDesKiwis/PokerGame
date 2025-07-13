package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TwoPairRule implements PokerRule{
    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        Map<Rank, Integer> rankCount = hand.getRankCount();
        List<Map.Entry<Rank, Integer>> pairs = rankCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .sorted((entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey()))
                .toList();

        if (pairs.size() == 2) return Optional.of(new EvaluatedRule(
                    PokerHand.TWO_PAIR,
                    new Card(pairs.getFirst().getKey())));

        return Optional.empty();
    }
}
