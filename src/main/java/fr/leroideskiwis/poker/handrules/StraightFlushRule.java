package fr.leroideskiwis.poker.handrules;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.Rank;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.handrules.handlers.PokerRule;

import java.util.Optional;

public class StraightFlushRule implements PokerRule {

    @Override
    public Optional<EvaluatedRule> evaluate(Hand hand) {
        Optional<EvaluatedRule> straight = new StraightRule().evaluate(hand);
        Optional<EvaluatedRule> flush = new FlushRule().evaluate(hand);

        if(straight.isPresent() && flush.isPresent()){
            if(hand.getBestCard().rank == Rank.ACE) return Optional.of(new EvaluatedRule(
                    PokerHand.ROYAL_FLUSH,
                    hand.getBestCard()
            ));
            return Optional.of(new EvaluatedRule(
                    PokerHand.STRAIGHT_FLUSH,
                    hand.getBestCard()
            ));
        }

        return Optional.empty();
    }
}
