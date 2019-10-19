package model;

public class Card {
    public Card(Integer manaCost) {
        this.manaCost = manaCost;
    }

    private Integer manaCost;

    public Integer getManaCost() {
        return manaCost;
    }

    public void setManaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }
}
