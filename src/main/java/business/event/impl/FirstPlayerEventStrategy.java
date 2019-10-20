package business.event.impl;

import model.Card;
import model.Player;

import java.util.List;
import java.util.Scanner;

public class FirstPlayerEventStrategy extends AbstractPlayerEventStrategy {

    public boolean playImpl(Player currentPlayer, Player opponentPlayer) {


        System.out.println(super.getCardsAsString(currentPlayer.getDeck().getActiveCards()));
        super.readPlayersCardThatWantToPlay();
        return false;
    }

}
