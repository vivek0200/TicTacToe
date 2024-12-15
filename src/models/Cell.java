package models;

public class Cell {
    private int row;
    private int col;
    private Symbol symbol;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = null;
        this.cellState = CellState.Empty;
    }

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public CellState getCellState() {
        return cellState;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public void displayCell() {
        if(cellState == CellState.Empty) {
            System.out.print("| - |");
        }
        else {
            System.out.print("| " + symbol.getSymbol() + " |");
        }
    }
}
