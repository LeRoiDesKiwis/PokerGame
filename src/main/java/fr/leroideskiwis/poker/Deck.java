package fr.leroideskiwis.poker;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck(){
        for (Suit suit : Suit.values()) {
            if(suit == Suit.UNKNOWN) break;
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck");
        }
        int randomIndex = (int) (Math.random() * cards.size());
        Card drawnCard = cards.get(randomIndex);
        cards.remove(randomIndex);
        return drawnCard;
    }

    public int size() {
        return cards.size();
    }
}
