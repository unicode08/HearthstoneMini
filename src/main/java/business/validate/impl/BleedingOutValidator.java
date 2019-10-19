package business.validate.impl;

import business.validate.SpecialRulesValidator;
import model.Player;

public class BleedingOutValidator implements SpecialRulesValidator {
    public void validate(Player player) {
        if (player.getDeck().getPassiveCards() == null || player.getDeck().getPassiveCards().isEmpty())
        {
            player.getHealth().setHealth(player.getHealth().getHealth() -1);
        }
    }
}
