package fr.leroideskiwis.poker;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand {

    private final List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = List.copyOf(cards);
    }

    public Hand(Card... cards){
        this(List.of(cards));
    }

    public Stream<Card> stream(){
        return cards.stream();
    }

    public Map<Rank, Integer> getRankCount() {
        return cards.stream()
                .collect(Collectors.groupingBy(card -> card.rank, Collectors.summingInt(_ -> 1)));
    }

    public Card getBestCard() {
        return cards.stream()
                .max(Card::compareTo).orElseThrow();
    }
}
