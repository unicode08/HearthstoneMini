package business;

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
}