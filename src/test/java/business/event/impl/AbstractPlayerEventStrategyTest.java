package business.event.impl;

import business.builders.PlayerBuilder;
import business.event.PlayerEventContext;
import model.Card;
import model.Player;
import org.junit.Test;
import util.GameConstants;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

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

        assertEquals(0, firstPlayer.getManaCap().getCap().intValue());
        assertEquals(0, firstPlayer.getManaCap().getActiveManaCount().intValue());
        assertEquals(3, firstPlayer.getDeck().getActiveCards().size());
        assertEquals(17, firstPlayer.getDeck().getPassiveCards().size());
    }

    @Test
    public void coordinateManaCap() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.coordinateManaCap(firstPlayer);

        assertEquals(0, firstPlayer.getManaCap().getCap().intValue());
        assertEquals(0, firstPlayer.getManaCap().getActiveManaCount().intValue());
        firstPlayerEventStrategy.coordinateManaCap(firstPlayer);

        assertEquals(1, firstPlayer.getManaCap().getCap().intValue());
        assertEquals(1, firstPlayer.getManaCap().getActiveManaCount().intValue());
    }

    @Test
    public void drawCard() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.drawCard(firstPlayer);

        assertEquals(3, firstPlayer.getDeck().getActiveCards().size());
        assertEquals(17, firstPlayer.getDeck().getPassiveCards().size());

        firstPlayerEventStrategy.drawCard(firstPlayer);
        assertEquals(4, firstPlayer.getDeck().getActiveCards().size());
        assertEquals(16, firstPlayer.getDeck().getPassiveCards().size());

        firstPlayer.getDeck().setPassiveCards(new Stack<Card>());
        assertEquals(0,firstPlayer.getDeck().getPassiveCards().size());
    }

    @Test
    public void getCardsAsString() {
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        List<Card> cards = new ArrayList<Card>();
        assertEquals("Your playable Cards is empty.", firstPlayerEventStrategy.getCardsAsString(cards));
        Card c1 = new Card(0);
        cards.add(c1);
        assertEquals("Your playable Cards :" + GameConstants.lineSeperator + "Card Number:1 Mana Cost:0", firstPlayerEventStrategy.getCardsAsString(cards));
        Card c2 = new Card(1);
        cards.add(c2);
        assertEquals("Your playable Cards :" + GameConstants.lineSeperator + "Card Number:1 Mana Cost:0" + GameConstants.lineSeperator + "Card Number:2 Mana Cost:1", firstPlayerEventStrategy.getCardsAsString(cards));
    }


    @Test
    public void validateChoosenCard() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        firstPlayer.getManaCap().setActiveManaCount(10);
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        System.out.println(firstPlayerEventStrategy.getCardsAsString(firstPlayer.getDeck().getActiveCards()));
        assertTrue(firstPlayerEventStrategy.validateChoosenCard(1, firstPlayer));
        assertTrue(firstPlayerEventStrategy.validateChoosenCard(2, firstPlayer));
        try {
            assertTrue(firstPlayerEventStrategy.validateChoosenCard(3, firstPlayer));
        } catch (InputMismatchException e) {
            assertTrue(true);
        }

        try {
            firstPlayerEventStrategy.validateChoosenCard(100, firstPlayer);
        } catch (InputMismatchException e) {
            assertTrue(true);
        }

        try {
            firstPlayerEventStrategy.validateChoosenCard(-1, firstPlayer);
        } catch (InputMismatchException e) {
            assertTrue(true);
        }

        firstPlayer.getManaCap().setActiveManaCount(-1);

        try {
            firstPlayerEventStrategy.validateChoosenCard(1, firstPlayer);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            assertTrue(e.getMessage().contains(GameConstants.notEnoughActiveManaCap));
        }
    }

    @Test
    public void playSelectedCard() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        Player secondPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        System.out.println(firstPlayerEventStrategy.getCardsAsString(firstPlayer.getDeck().getActiveCards()));
        System.out.println(secondPlayer.getHealth().getHealth());
        Card testCard =  new Card(firstPlayer.getDeck().getActiveCards().get(0).getManaCost()) ;
        firstPlayerEventStrategy.playSelectedCard(1, firstPlayer, secondPlayer);
        System.out.println(secondPlayer.getHealth().getHealth());
        assertEquals(testCard.getManaCost().intValue(), (GameConstants.maxHealth - secondPlayer.getHealth().getHealth()));
    }
}