package business.validate.impl;

import business.builders.PlayerBuilder;
import business.event.impl.FirstPlayerEventStrategy;
import model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverloadValidatorTest {

    @Test
    public void validate() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        FirstPlayerEventStrategy firstPlayerEventStrategy = new FirstPlayerEventStrategy();
        firstPlayerEventStrategy.drawCard(firstPlayer);
        firstPlayerEventStrategy.drawCard(firstPlayer);
        firstPlayerEventStrategy.drawCard(firstPlayer);

        OverloadValidator ov = new OverloadValidator();
        ov.validate(firstPlayer);

        assertEquals(1,firstPlayer.getDeck().getDiscardedCards().size());
        assertEquals(5,firstPlayer.getDeck().getActiveCards().size());
        assertEquals(14,firstPlayer.getDeck().getPassiveCards().size());

        firstPlayerEventStrategy.drawCard(firstPlayer);
        ov.validate(firstPlayer);

        assertEquals(2,firstPlayer.getDeck().getDiscardedCards().size());
        assertEquals(5,firstPlayer.getDeck().getActiveCards().size());
        assertEquals(13,firstPlayer.getDeck().getPassiveCards().size());
    }
}