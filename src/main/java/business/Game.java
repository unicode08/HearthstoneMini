package business;

import business.builders.PlayerBuilder;
import business.event.PlayerEventContext;
import business.event.impl.FirstPlayerEventStrategy;
import business.event.impl.SecondPlayerEventStrategy;
import model.Player;

public class Game {
    private static Game game;

    private Game() {
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void runGame() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        Player secondPlayer = PlayerBuilder.getInstance().preparePlayer();

        PlayerEventContext firstPlayerContext = new PlayerEventContext(new FirstPlayerEventStrategy(), firstPlayer, secondPlayer);
        PlayerEventContext secondPlayerContext = new PlayerEventContext(new SecondPlayerEventStrategy(), secondPlayer, firstPlayer);



    }
}
