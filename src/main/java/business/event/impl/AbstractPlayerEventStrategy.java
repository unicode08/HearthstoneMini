package business.event.impl;

import business.event.PlayerEventStrategy;
import business.validate.SpecialRulesValidator;
import business.validate.impl.BleedingOutValidator;
import business.validate.impl.OverloadValidator;
import model.Card;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class AbstractPlayerEventStrategy implements PlayerEventStrategy {


    public abstract boolean playImpl(Player currentPlayer, Player opponentPlayer);

    public boolean play(Player currentPlayer, Player opponentPlayer) {
        playImpl(currentPlayer, opponentPlayer);
        return true;
    }

    public boolean startTurn(Player currentPlayer) {
        coordinateManaCap(currentPlayer);
        drawCard(currentPlayer);
        specialRuleValidation(currentPlayer);
        return false;
    }

    public void specialRuleValidation(Player player) {
        List<SpecialRulesValidator> allSpecialRules = new ArrayList<SpecialRulesValidator>();
        allSpecialRules.add(new BleedingOutValidator());
        allSpecialRules.add(new OverloadValidator());

        for (SpecialRulesValidator specialRulesValidator : allSpecialRules) {
            specialRulesValidator.validate(player);
        }

    }

    public void coordinateManaCap(Player currentPlayer) {
        currentPlayer.getManaCap().setCap(currentPlayer.getManaCap().getCap() + 1);
        currentPlayer.getManaCap().setActiveManaCount(currentPlayer.getManaCap().getCap());
    }

    public void drawCard(Player currentPlayer) {
        Stack<Card> passiveCards = currentPlayer.getDeck().getPassiveCards();
        currentPlayer.getDeck().getActiveCards().push(passiveCards.pop());
    }

}
