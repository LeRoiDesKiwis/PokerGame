package fr.leroideskiwis.poker.util;

import java.util.Scanner;

public class Utils {

    public static int askNumber(Scanner scanner){

        int answer;
        while (true) {
            if(scanner.hasNextInt()){
                answer = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                return answer;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

    }

}
