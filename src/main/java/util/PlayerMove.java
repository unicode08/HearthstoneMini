package util;

public enum PlayerMove {
    SHOWCARDS("S"), PLAY("P"), ENDTURN("E");
    private String code;

    PlayerMove(String code) {
        this.code = code;
    }

    public static PlayerMove fromString(String text) {
        for (PlayerMove b : PlayerMove.values()) {
            if (b.code.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}
