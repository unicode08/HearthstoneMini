package business.event.impl;

import business.event.PlayerEventStrategy;
import business.validate.SpecialRulesValidator;
import business.validate.impl.BleedingOutValidator;
import business.validate.impl.OverloadValidator;
import model.Card;
import model.Player;
import util.GameConstants;
import util.PlayerMove;

import java.util.*;


public abstract class AbstractPlayerEventStrategy implements PlayerEventStrategy {


    public abstract boolean playImpl(Player currentPlayer, Player opponentPlayer);

    public boolean play(Player currentPlayer, Player opponentPlayer) {
        System.out.println(GameConstants.turnGameInfo);
        PlayerMove move = readPlayersWantToDo();
        switch (move) {
            case SHOWCARDS: {
                System.out.println("Active Mana Count:" + currentPlayer.getManaCap().getActiveManaCount() + " Mana Cap: " + currentPlayer.getManaCap().getCap());
                System.out.println(getCardsAsString(currentPlayer.getDeck().getActiveCards()));
                return play(currentPlayer, opponentPlayer);
            }
            case PLAY: {
                return playImpl(currentPlayer, opponentPlayer);
            }
            case ENDTURN: {
                return false;
            }
            default: {
                return false;
            }
        }


    }

    public boolean startTurn(Player currentPlayer) {
        coordinateManaCap(currentPlayer);
        drawCard(currentPlayer);
        specialRuleValidation(currentPlayer);
        return false;
    }

    protected void specialRuleValidation(Player player) {
        List<SpecialRulesValidator> allSpecialRules = new ArrayList<SpecialRulesValidator>();
        allSpecialRules.add(new BleedingOutValidator());
        allSpecialRules.add(new OverloadValidator());

        for (SpecialRulesValidator specialRulesValidator : allSpecialRules) {
            specialRulesValidator.validate(player);
        }

    }

    protected void coordinateManaCap(Player currentPlayer) {
        currentPlayer.getManaCap().setCap(currentPlayer.getManaCap().getCap() + 1);
        currentPlayer.getManaCap().setActiveManaCount(currentPlayer.getManaCap().getCap());
    }

    public void drawCard(Player currentPlayer) {
        Stack<Card> passiveCards = currentPlayer.getDeck().getPassiveCards();
        currentPlayer.getDeck().getActiveCards().push(passiveCards.pop());
    }

    protected String getCardsAsString(List<Card> cards) {
        StringBuilder sb = new StringBuilder("Your playable Cards");
        if (cards != null && !cards.isEmpty()) {
            sb.append(" -> ");
            sb.append(GameConstants.lineSeperator);
            for (int i = 0; i < cards.size(); i++) {
                sb.append(" Card Number:");
                sb.append(i + 1);
                sb.append(" Mana Cost:");
                sb.append(cards.get(i).getManaCost());
                sb.append(GameConstants.lineSeperator);
            }
        } else {
            sb.append(" is empty.");
            sb.append(GameConstants.lineSeperator);
        }

        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    protected Integer readPlayersCardThatWantToPlay() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(GameConstants.wrongCardNumberEntered);
            return readPlayersCardThatWantToPlay();
        }
    }

    protected PlayerMove readPlayersWantToDo() {
        Scanner scanner = new Scanner(System.in);
        try {
            String line = scanner.nextLine();

            PlayerMove move = PlayerMove.fromString(line);

            if (move == null) {
                throw new InputMismatchException();
            } else {
                return move;
            }

        } catch (InputMismatchException e) {
            System.out.println(GameConstants.wrongMovementEntered);
            return readPlayersWantToDo();
        }
    }

}
