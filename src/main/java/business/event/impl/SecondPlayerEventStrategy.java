package business.event.impl;

import model.Player;

public class SecondPlayerEventStrategy extends AbstractPlayerEventStrategy {


    public boolean playImpl(Player currentPlayer, Player opponentPlayer) {
        return true;
    }

}
