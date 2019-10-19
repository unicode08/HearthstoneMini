package business.event;

import model.Player;

public class PlayerEventContext {

    private PlayerEventStrategy playerEventStrategy;
    private Player currentPlayer;
    private Player opponentPlayer;
    private boolean isYourTurn = false;

    public PlayerEventContext(PlayerEventStrategy playerEventStrategy,Player currentPlayer,Player opponentPlayer) {
        this.playerEventStrategy = playerEventStrategy;
        this.currentPlayer = currentPlayer;
        this.opponentPlayer = opponentPlayer;
    }

    public boolean play() {
        return playerEventStrategy.play(currentPlayer,opponentPlayer);
    }

    public void setYourTurn(boolean yourTurn) {
        isYourTurn = yourTurn;
    }
}
