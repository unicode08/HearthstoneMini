package business.builders;

import model.Card;
import model.Deck;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class DeckBuilderTest {

    @Test
    public void prepareDeck() {
        Deck deck = DeckBuilder.getInstance().prepareDeck();
        assertTrue(deck.getActiveCards() != null && deck.getActiveCards().size() == 3);
        assertTrue(deck.getPassiveCards() != null && deck.getPassiveCards().size() == 17);
    }

}