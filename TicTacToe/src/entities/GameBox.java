package entities;

import enums.PlayerSymbol;

public class GameBox {
    private String id;
    private final int row;
    private final int col;
    private PlayerSymbol symbol;

    public GameBox(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = PlayerSymbol.EMPTY;
    }

    public PlayerSymbol getSymbol() {
        return symbol;
    }
    public void setSymbol(PlayerSymbol symbol) {
        this.symbol = symbol;
    }
}
