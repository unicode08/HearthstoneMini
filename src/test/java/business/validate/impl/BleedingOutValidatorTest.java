package business.validate.impl;

import business.builders.PlayerBuilder;
import model.Card;
import model.Player;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class BleedingOutValidatorTest {

    @Test
    public void validate() {
        Player firstPlayer = PlayerBuilder.getInstance().preparePlayer();
        firstPlayer.getDeck().setPassiveCards(new Stack<Card>());
        BleedingOutValidator bov = new BleedingOutValidator();
        bov.validate(firstPlayer);
        assertEquals(29 , firstPlayer.getHealth().getHealth().intValue());
    }
}