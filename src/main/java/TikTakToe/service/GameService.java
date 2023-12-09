package TikTakToe.service;

import TikTakToe.constant.PieceType;
import TikTakToe.model.Board;
import TikTakToe.model.Game;
import TikTakToe.model.Piece;
import TikTakToe.model.Player;
import TikTakToe.util.MoveValidator;
import TikTakToe.util.ResultValidationStrategy;

public class GameService {

    private Game game;
    private PlayerService playerService;

    public GameService(int boardSize, ResultValidationStrategy resultValidationStrategy){
        Board board = new Board(3);
        BoardPrinter.printBoard(board);
        this.game = new Game(board, resultValidationStrategy);
        playerService = new PlayerService();
    }

    public Player addPlayer(String piece, String name){
        PieceType pieceType = PieceType.valueOf(piece);
        game.getPieceList().add(new Piece(pieceType));
        Player player = playerService.addPlayer(name, pieceType);
        game.getPlayerQueue().add(player);
        return player;
    }

    public void makeMove(int row, int col){
        try{
            MoveValidator.validateMove(game.getBoard(), row, col);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }
        Player player = game.getPlayerQueue().remove();
        game.getBoard().addPieceAtPosition(row, col, player.getPieceType());
        game.getPlayerQueue().add(player);

        boolean isGameWon = game.getResultValidationStrategy().validateResult(game.getBoard().getBoard(), player.getPieceType());
        BoardPrinter.printBoard(game.getBoard());
        if(isGameWon){
            System.out.println(player.getName() + " won.");
        }
    }

}
