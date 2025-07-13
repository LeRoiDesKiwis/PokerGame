package fr.leroideskiwis.poker.game;

import fr.leroideskiwis.poker.game.io.GameDisplay;
import fr.leroideskiwis.poker.game.io.GameInput;
import fr.leroideskiwis.poker.game.io.TerminalGameDisplay;
import fr.leroideskiwis.poker.game.io.TerminalGameInput;

public class Main {

    public static void main(String[] args) {
        // Exemple d'utilisation de la classe Game
        // Vous pouvez remplacer cette partie par votre implémentation de GameIO et Table
        GameInput gameInput = new TerminalGameInput(); // Implémentez votre propre GameIO
        GameDisplay gameDisplay = new TerminalGameDisplay();
        Table table = new Table(gameDisplay, new Player("kiwi", 100), new Player("nova", 100)); // Créez une table avec 4 joueurs

        Game game = new Game(gameInput, gameDisplay, table);
        game.play();
    }
}
