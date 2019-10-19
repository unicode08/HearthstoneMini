package business.event;

import model.Player;

public class PlayerEventContext {

    private PlayerEventStrategy playerEventStrategy;
    private Player currentPlayer;
    private Player opponentPlayer;

    public PlayerEventContext(PlayerEventStrategy playerEventStrategy,Player currentPlayer,Player opponentPlayer) {
        this.playerEventStrategy = playerEventStrategy;
        this.currentPlayer = currentPlayer;
        this.opponentPlayer = opponentPlayer;
    }

    public boolean play() {
        return playerEventStrategy.play(currentPlayer,opponentPlayer);
    }

}
