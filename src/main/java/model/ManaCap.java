package model;

public class ManaCap {

    public ManaCap(Integer activeManaCount, Integer cap) {
        this.activeManaCount = activeManaCount;
        this.cap = cap;
    }

    private Integer activeManaCount;
    private Integer cap;

    public Integer getActiveManaCount() {
        return activeManaCount;
    }

    public void setActiveManaCount(Integer activeManaCount) {
        this.activeManaCount = activeManaCount;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }
}
