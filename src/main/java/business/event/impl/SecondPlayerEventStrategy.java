package business.event.impl;

import model.Card;
import model.Player;
import util.GameConstants;

public class SecondPlayerEventStrategy extends AbstractPlayerEventStrategy {


    public boolean playImpl(Player currentPlayer, Player opponentPlayer) {
        System.out.println(GameConstants.selectCardInfo);
        Integer playedCard = super.readPlayersCardThatWantToPlay(currentPlayer);
        if (playedCard == -1) {
            return true;
        }
        playSelectedCard(playedCard, currentPlayer, opponentPlayer);
        return true;
    }

}
