package fr.leroideskiwis.poker.handrules.handlers;

import fr.leroideskiwis.poker.Hand;

import java.util.Optional;

public interface PokerRule {

    Optional<EvaluatedRule> evaluate(Hand hand);

}
