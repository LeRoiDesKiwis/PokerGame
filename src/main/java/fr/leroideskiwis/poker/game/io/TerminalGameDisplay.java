package fr.leroideskiwis.poker.game.io;

import fr.leroideskiwis.poker.Card;
import fr.leroideskiwis.poker.game.Player;
import fr.leroideskiwis.poker.handrules.handlers.EvaluatedRule;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TerminalGameDisplay implements GameDisplay {
    @Override
    public void onMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void onShowPrivateCards(String playerName, List<Card> privateCards) {
        System.out.printf("Showing %s private cards, please look away for a second! And %s, please write it down as it will not be display twice!\n", playerName, playerName);
        System.out.println("Press enter to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.printf("%s's private cards: %s\n", playerName, privateCards);
        System.out.println("Press enter to continue");
        scanner.nextLine();
        System.out.println("\n".repeat(50));

    }

    @Override
    public void onShowCommunityCards(List<Card> communityCards) {
        System.out.println("Community cards: " + communityCards+"\n");
    }

    @Override
    public void onPlayerTurn(String name, int money, int pot, int currentBet) {
        System.out.printf("It's %s's turn! (%d money left)\n", name, money);
        System.out.println("Current pot: " + pot);
        System.out.println("Current bet: " + currentBet+"\n");
    }

    @Override
    public void onGameOver(Set<Map.Entry<Player, EvaluatedRule>> entries) {
        System.out.println("Game Over! Here are the results:");
        entries.stream()
                .sorted((e1, e2) -> e2.getValue().hand.compareTo(e1.getValue().hand))
                .forEach(entry -> {
                    Player player = entry.getKey();
                    EvaluatedRule rule = entry.getValue();
                    System.out.printf("%s: %s (Best card: %s)\n", player.toString(), rule.hand, rule.bestCard);
                });
        System.out.println("Thank you for playing!");
    }
}
