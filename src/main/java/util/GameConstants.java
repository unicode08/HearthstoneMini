package util;

public class GameConstants {

    public static final Integer maxHealth = 1;
    public static final Integer initialManaCap = -1;
    public static final Integer initialCardCount = 2;
    public static final Integer maxActiveDeckSize = 5;
    public static final Integer[] allAvaliableCardManaCostArray = new Integer[]{0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8};

    public static final String lineSeperator = System.getProperty("line.separator");

    public static final String turnGameInfo = "Please choose action that you want to do. (Play = P , Show Card And Mana = S , End Turn = E)";
    public static final String selectCardInfo = "Please choose card number that you want to play. For cancel choose -1 .";

    public static final String wrongCardNumberEntered = "Please choose only card number that you want to play. For cancel choose -1 .";
    public static final String notEnoughActiveManaCap = "Your active mana cap is not enough. For cancel choose -1 .";
    public static final String wrongMovementEntered = "Please choose only action that you want to do. (Play = P , Show Card And Mana = S , End Turn = E)";
    public static final String overloadWarning = "Your active deck size is full. Your next card going to discard.";
    public static final String bleedingOutWarning = "Your deck is empty. You going to take 1 HP damage.";
}
