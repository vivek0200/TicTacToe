package models;

public abstract class Player {
    private  int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public abstract Move makeMove(Board board);
}
