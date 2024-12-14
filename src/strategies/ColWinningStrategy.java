package strategies;

import models.Board;
import models.Move;

public class ColWinningStrategy implements WinningStrategy {
    public boolean checkWin(Board board, Move move) {
        System.out.println( "Checking for column win");
        return true;
    }
}
