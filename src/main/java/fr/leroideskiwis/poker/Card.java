package fr.leroideskiwis.poker;

public class Card implements Comparable<Card> {

    public final Rank rank;
    public final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(Rank rank) {
        this(rank, Suit.UNKNOWN);
    }

    /**
     * Check if this card is before the given card in terms of rank.
     * @param card the card to compare with
     * @return true if this card's rank is lower than the given card's rank, false otherwise (exemple : 1.isBefore(2) == true, 2.isBefore(1) == false)
     */
    public boolean isBefore(Card card){
        return rank.ordinal() == card.rank.ordinal() - 1;
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

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public Card unknownize(){
        return new Card(this.rank, Suit.UNKNOWN);
    }
}
