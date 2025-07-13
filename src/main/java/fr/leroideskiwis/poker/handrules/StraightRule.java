package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;

import java.util.List;
import java.util.Optional;

/**
 * Rule for determining if a hand is a straight
 */
public class StraightRule implements PokerRule {

    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        List<Card> cards = hand.stream().sorted().toList();

        for(int i = 0; i < cards.size(); i++){
            if(i == cards.size() - 1) break;
            if(!cards.get(i).isBefore(cards.get(i+1))) return Optional.empty();
        }

        return Optional.of(new EvaluatedRule(
                PokerHand.STRAIGHT,
                cards.getFirst()
        ));

    }
}
