package model;

public class Player {
    private String name;
    private ManaCap manaCap;
    private Health health;
    private Deck deck;

    public ManaCap getManaCap() {
        return manaCap;
    }

    public void setManaCap(ManaCap manaCap) {
        this.manaCap = manaCap;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
