package business.builders;

import model.Health;
import model.ManaCap;
import model.Player;
import util.GameConstants;

/**
 * This Builder written cause of Player could choose class like Hunter,Warlock in the future
 */
public class PlayerBuilder {

    private static PlayerBuilder playerBuilder;

    private PlayerBuilder() {
    }

    public static PlayerBuilder getInstance() {
        if (playerBuilder == null) {
            playerBuilder = new PlayerBuilder();
        }
        return playerBuilder;
    }

    public Player preparePlayer() {
        Player player = new Player();
        player.setDeck(DeckBuilder.getInstance().prepareDeck());
        player.setHealth(new Health(GameConstants.maxHealth));
        player.setManaCap(new ManaCap(0, 0));
        return player;
    }
}
