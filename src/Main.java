import controller.GameController;
import models.*;
import strategies.RowWinningStrategy;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        List<Player> players=new ArrayList<>();

        players.add(new HumanPlayer(1,"Vivek",new Symbol('X')));
        players.add(new Bot(2,"Botty",new Symbol('O'),BotLevel.EASY));

        int size=3;

        List<WinningStrategy> winningStrategies=new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());

        Game game=gameController.startGame(size,players,winningStrategies);
        gameController.displayBoard(game);
        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.displayBoard(game);

        }

        if(gameController.getGameState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner: "+gameController.getWinner(game).getName());
        }
        else{
            System.out.println("Draw");
        }

    }
}