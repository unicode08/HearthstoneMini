package business.event;

import business.builders.PlayerBuilder;
import business.event.impl.FirstPlayerEventStrategy;
import model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerEventContextTest {

    @Test
    public void play() {

        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        Player secondPlayer = PlayerBuilder.getInstance().preparePlayer();

        PlayerEventContext firstPlayerContext = new PlayerEventContext(new FirstPlayerEventStrategy(), firstPlayer, secondPlayer);

        for (int i = 0; i < 4; i++) {
            System.out.println(firstPlayerContext.play());
        }

        assertTrue(firstPlayerContext.play());
    }
}