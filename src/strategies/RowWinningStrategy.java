package strategies;

import models.Board;
import models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {
    private HashMap<Integer,HashMap<Character,Integer>>rowcount=new HashMap<>();
    //0:{'X':1,'O':0}
    //0:{'X':1,'O':1}
    public boolean checkWin(Board board, Move move) {
        int row=move.getCell().getRow();
        //int col=move.getCell().getCol();
        char symbol= move.getPlayer().getSymbol().getSymbol();
        if(!rowcount.containsKey(row)){
            rowcount.put(row,new HashMap<>());
        }
        HashMap<Character,Integer> count=rowcount.get(row);
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
