package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.handrules.handlers.PokerRule;

import java.util.List;
import java.util.Optional;

/**
 * Rule for determining if a hand is a straight
 */
public class StraightRule implements PokerRule {

    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        List<Card> cards = hand.stream().sorted().toList();
        int streak = 0;
        Card best = null;
        for(int i = 0; i < cards.size(); i++){
            Card card = cards.get(i);
            Card card1 = i < cards.size() - 1 ? cards.get(i + 1) : null;
            if(card1 != null && !card.isBefore(card1)){
                if(card.rank == card1.rank) continue; // Skip if the cards are the same rank
                streak = 0;
                best = null;
                continue;
            };
            streak++;
            best = card;
        }

        return streak >=5 ?Optional.of(new EvaluatedRule(
                PokerHand.STRAIGHT,
                best.unknownize()
        )) : Optional.empty();

    }
}
