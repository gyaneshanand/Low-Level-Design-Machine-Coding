package TikTakToe.util;

import TikTakToe.exception.InvalidMoveException;
import TikTakToe.model.Board;

public class MoveValidator {

    public static void validateMove(Board board, int row, int col){

        boolean isValidMove = validateRow(board, row) &&
                validateCol(board, col) &&
                checkIfEmpty(board, row, col);
        if(!isValidMove)
            throw new InvalidMoveException("Invalid Move");

    }

    private static boolean validateRow(Board board, int row){
        return row >=0 && row<board.getBoardSize();
    }

    private static boolean validateCol(Board board, int col){
        return col >=0 && col<board.getBoardSize();
    }

    private static boolean checkIfEmpty(Board board, int row, int col){
        return board.getPieceAtPosition(row, col)==null;
    }
}
