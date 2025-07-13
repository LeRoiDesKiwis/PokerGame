package fr.leroideskiwis.poker.handrules.handlers;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.PokerHand;
import fr.leroideskiwis.poker.handrules.*;

import java.util.List;
import java.util.Optional;

public class RuleEvaluator {

    private final List<PokerRule> rules = List.of(
            new OnePairRule(),
            new TwoPairRule(),
            new ThreeOfAKindRule(),
            new StraightRule(),
            new FlushRule(),
            new FullHouseRule(),
            new FourOfAKindRule(),
            new StraightFlushRule()
    );

    public EvaluatedRule evaluate(Hand hand) {
        EvaluatedRule result = new EvaluatedRule(PokerHand.HIGH_CARD, hand.getBestCard());
        for (PokerRule rule : rules) {
            Optional<EvaluatedRule> evalued = rule.evaluate(hand);
            if (evalued.isPresent()) result = evalued.get();
        }
        return result;
    }

}
