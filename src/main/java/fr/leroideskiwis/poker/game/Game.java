package fr.leroideskiwis.poker.game;

public class Game {

    private int currentPlayerIndex = 0;
    private Table table;

    public Game(Table table) {
        this.table = table;
    }

    public void play(){
        while (!table.isOver()) {
            currentPlayerIndex = (currentPlayerIndex + 1) % table.playerSize();
        }
    }

}
