package fr.leroideskiwis.poker.game;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.Deck;
import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.game.io.GameDisplay;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;
import fr.leroideskiwis.poker.handrules.handlers.RuleEvaluator;

public class Player {

    private int money;
    private String name;
    private Hand hand;
    private boolean fold;
    private int bet;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.hand = new Hand();
        this.fold = false;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public EvaluatedRule evaluateHand(RuleEvaluator evaluator, Hand table) {
        return evaluator.evaluate(hand.union(table));
    }

    public boolean hasEnoughMoney(int amount) {
        return money >= amount;
    }

    public void bet(int amount) {
        if (amount > money) {
            throw new IllegalArgumentException("Cannot bet more than available money");
        }
        money -= Math.abs(amount);
        bet += Math.abs(amount);
    }

    public void fold() {
        this.fold = true;
    }

    public void credit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot credit a negative amount");
        }
        money += Math.abs(amount);
    }

    public void deal(Deck deck) {
        hand = deck.createHand(2);
    }

    public int diffBet(int bet){
        return bet-this.bet;
    }

    public void reset() {
        this.fold = false;
        this.bet = 0;
        this.hand = new Hand();
    }

    public boolean hasFolded() {
        return fold;
    }

    public void showPrivateCards(GameDisplay gameDisplay) {
        gameDisplay.onShowPrivateCards(name, hand.stream().toList());
    }

    public void displayTurn(GameDisplay gameDisplay, int pot, int currentBet) {
        gameDisplay.onPlayerTurn(name, money, pot, currentBet);
    }

    @Override
    public String toString() {
        return name;
    }
}
