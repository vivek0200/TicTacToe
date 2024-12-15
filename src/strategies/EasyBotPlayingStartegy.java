package strategies;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;

import java.util.List;

public class EasyBotPlayingStartegy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row: board.getGrid()){
            for(Cell cell:row){
                if(cell.getCellState().equals(CellState.Empty)){
                    return new Move(new Cell(cell.getRow(),cell.getCol()),null);
                }
            }
        }
        return null;
    }

}
