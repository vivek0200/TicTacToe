package models;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayer;
    private List<Move> moves;
    private Player winner;
}
