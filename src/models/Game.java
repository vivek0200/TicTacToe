package models;

import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayer;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private List<WinningStrategy>winningStrategies;

    private Game(int size,List<WinningStrategy>winningStrategies,List<Player> players) {
        board = new Board(size);
        this.players = players;
        this.nextPlayer = 0;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies=winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void displayBoard(){
        board.displayBoard();
    }

    private boolean validate(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        if(row<0 || row>=board.getSize() || col<0 || col>=board.getSize()){
            return false;
        }
        //System.out.println(board.getGrid().get(row).get(col).getCellState());
        return board.getGrid().get(row).get(col).getCellState().equals(CellState.Empty);
    }

    private void updateGameState(Move move,Player player){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        Cell cell=board.getGrid().get(row).get(col);

        cell.setCellState(CellState.Filled);
        cell.setSymbol(player.getSymbol());

        move.setCell(cell);
        move.setPlayer(player);
        moves.add(move);

        nextPlayer++;
        nextPlayer%=players.size();
    }

    private boolean checkWinner(Move move){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWin(board,move)){
                return true;
            }
        }
        return false;
    }

    public void makeMove(){
        Player player=players.get(nextPlayer);
        System.out.println(player.getName() +" make your move");

        Move move=player.makeMove(board);
        if(!validate(move)){
            System.out.println("Invalid move return");
            return;
        }
        updateGameState(move,player);

        if(checkWinner(move)){
            winner=player;
            gameState=GameState.SUCCESS;
        } else if (moves.size()==board.getSize()*board.getSize()) {
            gameState=GameState.DRAW;
        }
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int size;
        private List<WinningStrategy>winningStrategies;
        private List<Player>players;

        public Builder setSize(int size){
            this.size=size;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy>winningStrategies){
            this.winningStrategies=winningStrategies;
            return this;
        }

        public Builder setPlayers(List<Player>players){
            this.players=players;
            return this;
        }

        public void validate(){

        }

        public Game build(){
            validate();
            return new Game(size,winningStrategies,players);
        }
    }
}
