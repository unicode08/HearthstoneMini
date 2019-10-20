package business.validate.impl;

import business.validate.SpecialRulesValidator;
import model.Player;
import util.GameConstants;

public class BleedingOutValidator implements SpecialRulesValidator {
    public void validate(Player player) {
        if (player.getDeck().getPassiveCards() == null || player.getDeck().getPassiveCards().isEmpty()) {
            System.out.println(GameConstants.bleedingOutWarning);
            player.getHealth().setHealth(player.getHealth().getHealth() - 1);
        }
    }
}
