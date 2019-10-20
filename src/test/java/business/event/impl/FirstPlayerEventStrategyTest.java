package business.event.impl;

import business.Game;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstPlayerEventStrategyTest {

    @Test
    public void playImpl() {
        FirstPlayerEventStrategy fpes = new FirstPlayerEventStrategy();
        fpes.playImpl(Game.getInstance().firstPlayerContext.getCurrentPlayer(),Game.getInstance().firstPlayerContext.getOpponentPlayer());
    }
}