package business.builders;

import model.Card;
import model.Deck;
import util.GameConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.List;

public class DeckBuilder {

    private static DeckBuilder deckBuilder;

    private DeckBuilder() {
    }

    public static DeckBuilder getInstance() {
        if (deckBuilder == null) {
            deckBuilder = new DeckBuilder();
        }
        return deckBuilder;
    }

    public Deck prepareDeck() {
        Deck deck = new Deck();
        List<Card> shuffledCardList = shuffleCardsForPreparing();
        Stack activeCards = new Stack<Card>();
        activeCards.addAll((shuffledCardList.subList(0, GameConstants.initialCardCount)));
        Stack passiveCards = new Stack<Card>();
        passiveCards.addAll(shuffledCardList.subList(GameConstants.initialCardCount, GameConstants.allAvaliableCardManaCostArray.length));
        deck.setActiveCards(activeCards);
        deck.setPassiveCards(passiveCards);
        deck.setUsedCards(new Stack<Card>());
        deck.setDiscardedCards(new Stack<Card>());
        return deck;
    }


    public List<Card> shuffleCardsForPreparing() {
        List<Card> shuffedCardList = new ArrayList<Card>();
        for (Integer manaCost : GameConstants.allAvaliableCardManaCostArray) {
            shuffedCardList.add(new Card(manaCost));
        }
        Collections.shuffle(shuffedCardList);
        return shuffedCardList;
    }
}
