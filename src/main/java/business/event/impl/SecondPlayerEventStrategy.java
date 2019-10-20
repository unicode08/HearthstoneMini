package business.event.impl;

import model.Player;

public class SecondPlayerEventStrategy extends AbstractPlayerEventStrategy {


    public boolean playImpl(Player currentPlayer, Player opponentPlayer) {
        System.out.println(super.getCardsAsString(currentPlayer.getDeck().getActiveCards()));
        super.readPlayersCardThatWantToPlay();
        return false;
    }

}
