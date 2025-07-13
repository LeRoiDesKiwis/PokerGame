package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class XOfAKindRule implements PokerRule {

    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {

        Map<Rank, Integer> rankCount = hand.getRankCount();
        return rankCount.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .filter(entry -> entry.getValue() >= 3) // Only consider three of a kind or higher
                .map(entry -> new EvaluatedRule(entry.getValue() == 3 ? PokerHand.THREE_OF_A_KIND : PokerHand.FOUR_OF_A_KIND, new Card(entry.getKey())));

    }
}
