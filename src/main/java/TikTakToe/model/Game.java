package TikTakToe.model;

import TikTakToe.util.DefaultResultValidationStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    Board board;
    List<Player> playerList;
    List<Piece> pieceList;
    Queue<Player> playerQueue;
    DefaultResultValidationStrategy resultValidationStrategy;
    String gameId;

    public Game(Board board, DefaultResultValidationStrategy resultValidationStrategy) {
        this.board = board;
        this.resultValidationStrategy = resultValidationStrategy;
        playerQueue=new LinkedList<>();
        this.pieceList = new ArrayList<>();
        this.playerList = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public DefaultResultValidationStrategy getResultValidationStrategy() {
        return resultValidationStrategy;
    }

    public Queue<Player> getPlayerQueue() {
        return playerQueue;
    }
}
