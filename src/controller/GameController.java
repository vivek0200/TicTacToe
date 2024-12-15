package controller;

import models.Game;
import models.GameState;
import models.Player;
import strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player>players, List<WinningStrategy>winningStrategies) {
        try {
            return Game.getBuilder().setSize(size).setPlayers(players).setWinningStrategies(winningStrategies).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
