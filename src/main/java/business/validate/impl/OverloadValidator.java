package business.validate.impl;

import business.validate.SpecialRulesValidator;
import model.Card;
import model.Player;
import util.GameConstants;

import java.util.Stack;

public class OverloadValidator implements SpecialRulesValidator {
    public void validate(Player player) {
        if (player.getDeck().getActiveCards().size() > GameConstants.maxActiveDeckSize) {
            System.out.println(GameConstants.overloadWarning);
            Stack<Card> activeCards = player.getDeck().getActiveCards();
            player.getDeck().getDiscardedCards().push(activeCards.pop());
        }

    }
}
