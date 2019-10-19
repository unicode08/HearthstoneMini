package business.event.impl;

import model.Player;

public class FirstPlayerEventStrategy extends AbstractPlayerEventStrategy {

    public boolean playImpl(Player currentPlayer, Player opponentPlayer) {

        return true;
    }

}
