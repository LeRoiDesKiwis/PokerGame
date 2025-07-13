package fr.leroideskiwis.poker.game;

import fr.leroideskiwis.poker.Deck;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.game.io.GameDisplay;
import fr.leroideskiwis.poker.game.io.GameInput;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.handrules.handlers.RuleEvaluator;

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
    private GameDisplay gameDisplay;

    public Table(GameDisplay gameDisplay, Player... players) {
        this.deck = new Deck();
        this.communityCards = new Hand();
        this.players = List.of(players);
        this.pot = 0;
        this.currentBet = 10;
        this.gameDisplay = gameDisplay;
    }

    public void dealCards() {
        for (Player player : players) {
            player.deal(deck);
            player.showPrivateCards(gameDisplay);
        }
    }

    public void dealCommunityCards(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            communityCards.addCard(deck.drawCard());
        }
        gameDisplay.onShowCommunityCards(communityCards.stream().toList());
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

    public void bet(int playerIndex, int toBet) {
        Player currentPlayer = players.get(playerIndex);
        currentPlayer.bet(toBet);
        addToPot(toBet);
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
        gameDisplay.onGameOver(evaluateHands().entrySet());
        players.forEach(Player::reset);
        this.deck = new Deck();
        this.currentBet = 0;
        this.pot = 0;

    }

    public boolean isOver() {
        return players.stream().filter(player -> player.hasEnoughMoney(1)).count() <= 1;
    }

    public int playerSize() {
        return players.size();
    }

    public GameInput.Action getAction(int playerId, GameInput gameInput) {
        return gameInput.getAction(diffBet(playerId), pot, communityCards);
    }

    public boolean executeAction(int currentPlayerIndex, GameInput.Action action) {
        Player currentPlayer = players.get(currentPlayerIndex);
        switch (action.type) {
            case FOLD:
                fold(currentPlayerIndex);
                break;
            case CALL:
                if (!currentPlayer.hasEnoughMoney(diffBet(currentPlayerIndex))) return false;
                bet(currentPlayerIndex, diffBet(currentPlayerIndex));
                break;
            case RAISE:
                if (!currentPlayer.hasEnoughMoney(action.amount)) return false;
                raise(currentPlayerIndex, action.amount);
                break;
        }
        return true;
    }

    public boolean isOut(int i) {
        return players.get(i).hasFolded();
    }

    public void displayPlayerTurn(int currentId) {
        players.get(currentId).displayTurn(gameDisplay, pot, currentBet);
    }
}
