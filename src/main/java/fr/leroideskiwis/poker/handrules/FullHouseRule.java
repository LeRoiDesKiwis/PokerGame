package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.PokerHand;

import java.util.Map;
import java.util.Optional;

public class FullHouseRule implements PokerRule {

    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        Map<Rank, Integer> repartition = hand.getRankCount();
        Optional<Rank> threeOfAKind = repartition.entrySet().stream()
                .filter(entry -> entry.getValue() == 3)
                .map(Map.Entry::getKey)
                .findFirst();

        if(threeOfAKind.isEmpty()) return Optional.empty();

        Optional<Rank> pair = repartition.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .filter(entry -> !entry.getKey().equals(threeOfAKind.get()))
                .map(Map.Entry::getKey)
                .findFirst();

        if(pair.isEmpty()) return Optional.empty();
        Rank best = threeOfAKind.get().compareTo(pair.get()) > 0 ? threeOfAKind.get() : pair.get();
        return Optional.of(new EvaluatedRule(
                PokerHand.FULL_HOUSE,
                new Card(best)
        ));
    }
}
