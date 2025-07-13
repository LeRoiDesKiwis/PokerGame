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
            if(i < cards.size() - 1 && !cards.get(i).isBefore(cards.get(i+1))){
                streak = 0;
                best = null;
                continue;
            };
            streak++;
            best = cards.get(i);
        }

        return streak >=5 ?Optional.of(new EvaluatedRule(
                PokerHand.STRAIGHT,
                best.unknownize()
        )) : Optional.empty();

    }
}
