package business;

import business.event.PlayerEventContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void runGame() {
        try {
            Game.getInstance().runGame();
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    public void isGameEnded() {
        //  Game.getInstance().isGameEnded()
    }

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