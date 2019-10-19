package business.builders;

import model.Card;
import model.Deck;
import util.GameConstants;

import java.util.*;

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


        deck.setActiveCards(shuffledCardList.subList(0, GameConstants.initialCardCount));
        deck.setPassiveCards(shuffledCardList.subList(GameConstants.initialCardCount, GameConstants.allAvaliableCardManaCostArray.length));

        deck.setUsedCards(new ArrayList<Card>());
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
