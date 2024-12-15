package strategies;

import models.Board;
import models.Move;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy {
    HashMap<Integer,HashMap<Character,Integer>>colcount=new HashMap<>();
    public boolean checkWin(Board board, Move move) {
        int col=move.getCell().getCol();
        char symbol= move.getPlayer().getSymbol().getSymbol();
        if(!colcount.containsKey(col)){
            colcount.put(col,new HashMap<>());
        }
        HashMap<Character,Integer> count=colcount.get(col);
        if(!count.containsKey(symbol)){
            count.put(symbol,0);
        }
        count.put(symbol,count.get(symbol)+1);
        if(count.get(symbol)==board.getSize()){
            return true;
        }
        return false;
    }
}
