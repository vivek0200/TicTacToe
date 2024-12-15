package models;

import strategies.BotPlayingStartegyFactory;

import java.util.List;

public class Bot extends Player {
    private BotLevel level;

    public Bot(int id,String name,Symbol symbol,BotLevel level) {
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
       return BotPlayingStartegyFactory.getBotPlayingStartegy(level).makeMove(board);
    }
}
