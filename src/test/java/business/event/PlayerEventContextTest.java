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

        assertTrue(firstPlayerContext.play());
    }
}