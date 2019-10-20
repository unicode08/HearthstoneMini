package business;

import business.event.PlayerEventContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getTurn() {
        Game.getInstance().getTurn();
        assertTrue(Game.getInstance().firstPlayerContext != Game.getInstance().secondPlayerContext);
        Game.getInstance().getTurn();
        assertTrue(Game.getInstance().firstPlayerContext != Game.getInstance().secondPlayerContext);
        Game.getInstance().getTurn();
        assertTrue(Game.getInstance().firstPlayerContext != Game.getInstance().secondPlayerContext);

    }
}