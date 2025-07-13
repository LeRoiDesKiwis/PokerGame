package fr.leroideskiwis.poker.game;

import fr.leroideskiwis.poker.game.io.GameDisplay;
import fr.leroideskiwis.poker.game.io.GameInput;

public class Game {

    private Table table;
    private GameInput gameInput;
    private final GameDisplay gameDisplay;

    public Game(GameInput gameInput, GameDisplay display, Table table) {
        this.gameInput = gameInput;
        this.gameDisplay = display;
        this.table = table;
    }

    public void play(){
        while(!table.isOver()) {
            table.dealCards();
            round();
            table.dealCommunityCards(3);
            round();
            table.dealCommunityCards(1);
            round();
            table.dealCommunityCards(1);
            round();
            table.finish();
        }
    }

    private void round() {
        for(int i = 0; i < table.playerSize(); i++){
            if(table.isOut(i)) continue;
            table.displayPlayerTurn(i);

            boolean bool = true;
            while(bool){
                GameInput.Action action = table.getAction(i, gameInput);
                bool = !table.executeAction(i, action);
            }
        }
    }

}
