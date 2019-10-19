package model;

import java.util.List;

public class Deck {
    private List<Card> activeCards;
    private List<Card> passiveCards;
    private List<Card> usedCards;

    public List<Card> getActiveCards() {
        return activeCards;
    }

    public void setActiveCards(List<Card> activeCards) {
        this.activeCards = activeCards;
    }

    public List<Card> getPassiveCards() {
        return passiveCards;
    }

    public void setPassiveCards(List<Card> passiveCards) {
        this.passiveCards = passiveCards;
    }

    public List<Card> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(List<Card> usedCards) {
        this.usedCards = usedCards;
    }
}
