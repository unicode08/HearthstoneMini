package business.event.impl;

import business.event.PlayerEventStrategy;
import model.Player;

public abstract class AbstractPlayerEventStrategy implements PlayerEventStrategy {


    public abstract boolean playImpl(Player currentPlayer, Player opponentPlayer);

    public boolean play(Player currentPlayer, Player opponentPlayer) {
        specialRuleValidation(currentPlayer);
        playImpl(currentPlayer, opponentPlayer);
        return true;
    }

    private void specialRuleValidation(Player player) {
    }

}
