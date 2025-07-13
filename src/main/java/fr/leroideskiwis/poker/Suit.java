package fr.leroideskiwis.poker;

public enum Suit {
    HEARTS("h"),
    DIAMONDS("d"),
    CLUBS("c"),
    SPADES("s"),
    UNKNOWN("?");

    private final String symbol;
    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol;
    }
}
