package fr.leroideskiwis.poker.game;

import fr.leroideskiwis.poker.Deck;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.handrules.handlers.RuleEvaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private Deck deck;
    private Hand communityCards;
    private List<Player> players;
    private int pot;
    private int currentBet;

    private RuleEvaluator ruleEvaluator = new RuleEvaluator();

    public Table(Player... players) {
        this.deck = new Deck();
        this.communityCards = new Hand();
        this.players = List.of(players);
        this.pot = 0;
        this.currentBet = 0;
    }

    public void dealCards() {
        for (Player player : players) {
            player.deal(deck);
        }
    }

    public void dealCommunityCards(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            communityCards.addCard(deck.drawCard());
        }
    }

    public Map<Player, EvaluatedRule> evaluateHands() {
        Map<Player, EvaluatedRule> results = new HashMap<>();
        for (Player player : players) {
            results.put(player, player.evaluateHand(ruleEvaluator, communityCards));
        }
        return results;
    }

    public void addToPot(int amount) {
        pot += amount;
    }

    public void bet(int playerIndex) {
        Player currentPlayer = players.get(playerIndex);
        currentPlayer.bet(currentBet);
        addToPot(currentBet);
    }

    public void fold(int playerIndex) {
        Player currentPlayer = players.get(playerIndex);
        currentPlayer.fold();
    }

    public int diffBet(int playerIndex) {
        Player currentPlayer = players.get(playerIndex);
        return currentPlayer.diffBet(currentBet);
    }

    public void raise(int playerIndex, int amount) {
        Player currentPlayer = players.get(playerIndex);
        currentPlayer.bet(amount);
        currentBet += amount;
        addToPot(amount);
    }

    public void finish(){
        Player winner = evaluateHands().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
        winner.credit(pot);
        players.forEach(Player::reset);
    }

    public boolean isOver() {
        return communityCards.size() == 5;
    }

    public int playerSize() {
        return players.size();
    }
}
