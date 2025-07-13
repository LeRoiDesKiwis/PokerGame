package fr.leroideskiwis.poker;

public class Card implements Comparable<Card> {

    public final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(Rank rank) {
        this(rank, Suit.UNKNOWN);
    }

    public int compareTo(Card bestCard) {
        if (this.rank.ordinal() != bestCard.rank.ordinal()) return this.rank.ordinal() - bestCard.rank.ordinal();
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card other)) return false;
        return this.rank == other.rank && this.suit == other.suit;
    }
}
