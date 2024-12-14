package strategies;

import models.Board;
import models.Move;

public class RowWinningStrategy implements WinningStrategy {
    public boolean checkWin(Board board, Move move) {
        System.out.println( "Checking for row win");
        return true;
    }
}
