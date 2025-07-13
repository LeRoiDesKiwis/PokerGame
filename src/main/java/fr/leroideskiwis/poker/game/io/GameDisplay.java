package fr.leroideskiwis.poker.game.io;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.game.Player;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GameDisplay {

    void onMessage(String message);
    void onShowPrivateCards(String playerName, List<Card> privateCards);
    void onShowCommunityCards(List<Card> communityCards);
    void onPlayerTurn(String name, int money, int pot, int currentBet);
    void onGameOver(Set<Map.Entry<Player, EvaluatedRule>> entries);

}
