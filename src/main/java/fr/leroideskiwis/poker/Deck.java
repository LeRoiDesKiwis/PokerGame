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

    public Hand createHand(int numberOfCards) {
        if (numberOfCards < 1 || numberOfCards > cards.size()) {
            throw new IllegalArgumentException("Invalid number of cards requested: " + numberOfCards);
        }
        Hand hand = new Hand();
        for (int i = 0; i < numberOfCards; i++) {
            hand.addCard(drawCard());
        }
        return hand;
    }

    public int size() {
        return cards.size();
    }
}
