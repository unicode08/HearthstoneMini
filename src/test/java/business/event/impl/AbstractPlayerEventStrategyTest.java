package business.event.impl;

import business.builders.PlayerBuilder;
import business.event.PlayerEventContext;
import model.Card;
import model.Player;
import org.junit.Test;
import util.GameConstants;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractPlayerEventStrategyTest {


    @Test
    public void specialRuleValidation() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.specialRuleValidation(firstPlayer);

    }

    @Test
    public void startTurn() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.startTurn(firstPlayer);

        assertEquals(1, firstPlayer.getManaCap().getCap().intValue());
        assertEquals(1, firstPlayer.getManaCap().getActiveManaCount().intValue());
        assertEquals(4, firstPlayer.getDeck().getActiveCards().size());
        assertEquals(16, firstPlayer.getDeck().getPassiveCards().size());
    }

    @Test
    public void coordinateManaCap() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.coordinateManaCap(firstPlayer);

        assertEquals(1, firstPlayer.getManaCap().getCap().intValue());
        assertEquals(1, firstPlayer.getManaCap().getActiveManaCount().intValue());
        firstPlayerEventStrategy.coordinateManaCap(firstPlayer);

        assertEquals(2, firstPlayer.getManaCap().getCap().intValue());
        assertEquals(2, firstPlayer.getManaCap().getActiveManaCount().intValue());
    }

    @Test
    public void drawCard() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.drawCard(firstPlayer);

        assertEquals(4, firstPlayer.getDeck().getActiveCards().size());
        assertEquals(16, firstPlayer.getDeck().getPassiveCards().size());

        firstPlayerEventStrategy.drawCard(firstPlayer);
        assertEquals(5, firstPlayer.getDeck().getActiveCards().size());
        assertEquals(15, firstPlayer.getDeck().getPassiveCards().size());
    }

    @Test
    public void getCardsAsString() {
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        List<Card> cards = new ArrayList<Card>();
        assertEquals("Your playable Cards is empty.", firstPlayerEventStrategy.getCardsAsString(cards));
        Card c1 = new Card(0);
        cards.add(c1);
        assertEquals("Your playable Cards -> " + GameConstants.lineSeperator + " Card Number:1 Mana Cost:0", firstPlayerEventStrategy.getCardsAsString(cards));
        Card c2 = new Card(1);
        cards.add(c2);
        assertEquals("Your playable Cards -> " + GameConstants.lineSeperator + " Card Number:1 Mana Cost:0" + GameConstants.lineSeperator + " Card Number:2 Mana Cost:1", firstPlayerEventStrategy.getCardsAsString(cards));
    }


}