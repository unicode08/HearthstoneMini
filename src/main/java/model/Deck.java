package model;

import java.util.Stack;

public class Deck {
    private Stack<Card> activeCards;
    private Stack<Card> passiveCards;
    private Stack<Card> usedCards;
    private Stack<Card> discardedCards;

    public Stack<Card> getActiveCards() {
        return activeCards;
    }

    public void setActiveCards(Stack<Card> activeCards) {
        this.activeCards = activeCards;
    }

    public Stack<Card> getPassiveCards() {
        return passiveCards;
    }

    public void setPassiveCards(Stack<Card> passiveCards) {
        this.passiveCards = passiveCards;
    }

    public Stack<Card> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(Stack<Card> usedCards) {
        this.usedCards = usedCards;
    }

    public Stack<Card> getDiscardedCards() {
        return discardedCards;
    }

    public void setDiscardedCards(Stack<Card> discardedCards) {
        this.discardedCards = discardedCards;
    }
}
