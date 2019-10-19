package business.builders;

import business.builders.PlayerBuilder;
import model.Player;
import org.junit.Test;
import util.GameConstants;

import static org.junit.Assert.*;

public class PlayerBuilderTest {

    @Test
    public void preparePlayer() {

        Player player= PlayerBuilder.getInstance().preparePlayer();

        assertEquals(player.getHealth().getHealth() , GameConstants.maxHealth);
        assertEquals(player.getManaCap().getCap() , GameConstants.maxManaCap);
        assertTrue(player.getDeck().getPassiveCards() != null && player.getDeck().getPassiveCards().size() == 17);

    }
}