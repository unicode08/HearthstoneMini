package business.event;

import model.Player;

public interface PlayerEventStrategy {
    public boolean play(Player currentPlayer,Player opponentPlayer);

}
