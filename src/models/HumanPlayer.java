package models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private int level;
    private int coins;
    private Scanner sc;

    public HumanPlayer(int id,String name,PlayerType type,Symbol symbol) {
        super(id,name,symbol,PlayerType.human);
        sc = new Scanner(System.in);
        this.coins = 100;
        this.level = 1;
    }
    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Please enter row");
        int row= sc.nextInt();
        System.out.println("Please enter column");
        int col= sc.nextInt();
        return new Move(new Cell(row,col),this);
    }


}
