package models;

public class Bot extends Player {
    private BotLevel level;

    public Bot(BotLevel level,int id,String name,PlayerType playerType,Symbol symbol) {
        super(id,name,symbol,PlayerType.bot);
        this.level = level;
    }
    public BotLevel getLevel() {
        return level;
    }
    public void setLevel(BotLevel level) {
        this.level = level;
    }

    @Override
    public Move makeMove(Board board) {
        return null;
    }
}
