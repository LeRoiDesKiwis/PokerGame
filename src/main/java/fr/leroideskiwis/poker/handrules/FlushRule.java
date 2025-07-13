package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Suit;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.handrules.handlers.PokerRule;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlushRule implements PokerRule {
    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        List<Card> cards = hand.stream().sorted(Comparator.comparing(entry -> entry.suit)).toList();
        int streak = 0;
        Card best = null;
        for(int i = 0; i < cards.size(); i++){
            Card card = cards.get(i);
            Card card1 = i < cards.size() - 1 ? cards.get(i + 1) : null;
            if(card1 != null && !card.suit.equals(card1.suit)){
                streak = 0;
                best = null;
                continue;
            };
            streak++;
            best = best == null || card.compareTo(best) > 0 ? card : best; // Keep the highest card in the flush
        }

        return streak >=5 ?Optional.of(new EvaluatedRule(
                PokerHand.FLUSH,
                best
        )) : Optional.empty();
    }
}
