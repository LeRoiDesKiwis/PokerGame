package fr.leroideskiwis.poker.game.io;

import fr.leroideskiwis.poker.Hand;
import fr.leroideskiwis.poker.util.Utils;

import java.util.Scanner;

public class TerminalGameInput implements GameInput {

    private Scanner scanner;

    public TerminalGameInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Action getAction(int toCall, int pot, Hand communityCards) {
        System.out.println("Choose an action");
        System.out.printf("1. %s (%d to call)%n", toCall > 0 ? "Call" : "Check", toCall);
        System.out.println("2. Raise");
        System.out.println("3. Fold");
        System.out.print("Your choice: ");
        String input = scanner.nextLine().trim();
        switch (input) {
            case "1" -> {
                return new Action(Action.Type.CALL, toCall);
            }
            case "2" -> {
                System.out.print("Enter the amount to raise: ");
                int raiseAmount = Utils.askNumber(scanner);
                return new Action(Action.Type.RAISE, raiseAmount);
            }
            case "3" -> {
                return new Action(Action.Type.FOLD, 0);
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                return getAction(toCall, pot, communityCards);
            }
        }
    }
}
