package TikTakToe.model;

import TikTakToe.util.ResultValidationStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    Board board;
    List<Player> playerList;
    List<Piece> pieceList;
    Queue<Player> playerQueue;
    ResultValidationStrategy resultValidationStrategy;
    String gameId;

    public Game(Board board, ResultValidationStrategy resultValidationStrategy) {
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

    public ResultValidationStrategy getResultValidationStrategy() {
        return resultValidationStrategy;
    }

    public Queue<Player> getPlayerQueue() {
        return playerQueue;
    }
}
