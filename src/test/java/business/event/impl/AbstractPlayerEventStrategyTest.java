package business.event.impl;

import business.builders.PlayerBuilder;
import business.event.PlayerEventContext;
import model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractPlayerEventStrategyTest {

    @Test
    public void play() {
    }

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

        assertEquals(1,firstPlayer.getManaCap().getCap().intValue());
        assertEquals(1,firstPlayer.getManaCap().getActiveManaCount().intValue());
        assertEquals(4, firstPlayer.getDeck().getActiveCards().size());
        assertEquals(16, firstPlayer.getDeck().getPassiveCards().size());
    }

    @Test
    public void coordinateManaCap() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.coordinateManaCap(firstPlayer);

        assertEquals(1,firstPlayer.getManaCap().getCap().intValue());
        assertEquals(1,firstPlayer.getManaCap().getActiveManaCount().intValue());
        firstPlayerEventStrategy.coordinateManaCap(firstPlayer);

        assertEquals(2,firstPlayer.getManaCap().getCap().intValue());
        assertEquals(2,firstPlayer.getManaCap().getActiveManaCount().intValue());
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
}