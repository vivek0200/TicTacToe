package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    List<List<Cell>> grid;

    public int getSize() {
        return size;
    }
    public List<List<Cell>> getGrid() {
        return grid;
    }
    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Board(int size) {
        this.size = size;
        grid=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                grid.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard() {
        for (List<Cell> row : grid){
            for (Cell cell : row){
                cell.displayCell();
            }
            System.out.println();
        }
    }

}
