package business;

import business.builders.PlayerBuilder;
import business.event.PlayerEventContext;
import business.event.impl.FirstPlayerEventStrategy;
import business.event.impl.SecondPlayerEventStrategy;
import model.Player;

import java.util.Random;

public class Game {
    private static Game game;
    private static Player firstPlayer;
    private static Player secondPlayer;
    public static PlayerEventContext firstPlayerContext;
    public static PlayerEventContext secondPlayerContext;

    private Game() {
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
            firstPlayer = PlayerBuilder.getInstance().preparePlayer();
            firstPlayer.setName("First Player");
            secondPlayer = PlayerBuilder.getInstance().preparePlayer();
            secondPlayer.setName("Second Player");
            firstPlayerContext = new PlayerEventContext(new FirstPlayerEventStrategy(), firstPlayer, secondPlayer);
            secondPlayerContext = new PlayerEventContext(new SecondPlayerEventStrategy(), secondPlayer, firstPlayer);
        }
        return game;
    }

    public void runGame() {
        System.out.println("Welcome to HeartstoneMini");
        boolean isEndMessagePrinted = false;
        while (true) {
            PlayerEventContext activePlayerContent = getTurn();
            activePlayerContent.startTurn();
            System.out.println("Hey " + activePlayerContent.getCurrentPlayer().getName() + "! İt's your turn, Play careful.");
            while (activePlayerContent.play()) {
                if (isGameEnded(activePlayerContent)) {
                    isEndMessagePrinted = true;
                    break;
                }
            }

            if (!isEndMessagePrinted && isGameEnded(activePlayerContent)) {
                break;
            }
        }

    }

    public boolean isGameEnded(PlayerEventContext activePlayerContent) {
        boolean retval = false;
        if (activePlayerContent.getCurrentPlayer().getHealth().getHealth() <= 0) {
            System.out.println(activePlayerContent.getOpponentPlayer().getName() + " is winner.");
            retval = true;
        } else if (activePlayerContent.getOpponentPlayer().getHealth().getHealth() <= 0) {
            System.out.println(activePlayerContent.getCurrentPlayer().getName() + " is winner.");
            retval = true;
        }
        return retval;
    }


    public PlayerEventContext getTurn() {
        //Beggining of the game
        if (!firstPlayerContext.isYourTurn() && !secondPlayerContext.isYourTurn()) {
            randomizeInitialTurn();
        } else {
            firstPlayerContext.setYourTurn(!firstPlayerContext.isYourTurn());
            secondPlayerContext.setYourTurn(!secondPlayerContext.isYourTurn());
        }
        return firstPlayerContext.isYourTurn() ? firstPlayerContext : secondPlayerContext;
    }

    private void randomizeInitialTurn() {
        Random random = new Random();
        firstPlayerContext.setYourTurn(random.nextBoolean());
        secondPlayerContext.setYourTurn(!firstPlayerContext.isYourTurn());
    }


}
