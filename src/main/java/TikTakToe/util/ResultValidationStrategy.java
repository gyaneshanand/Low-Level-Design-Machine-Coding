package TikTakToe.util;

import TikTakToe.constant.PieceType;
import TikTakToe.model.Board;
import TikTakToe.model.Piece;

import java.util.List;

public class ResultValidationStrategy {

    public ResultValidationStrategy() {
    }

    public boolean validateResult(List<List<PieceType>> board, PieceType pieceType){
        return validateColumn(board, pieceType) ||
                validateRow(board, pieceType) ||
                validateDiagonal(board, pieceType);
    }

    private boolean validateRow(List<List<PieceType>> board, PieceType pieceType){

        for(List<PieceType> boardRow : board){
            boolean isRowValid = true;
            for(PieceType piece : boardRow){
                if(piece==null || !(piece.compareTo(pieceType)==0)){
                    isRowValid = false;
                    break;
                }
            }
            if(isRowValid)
                return true;
        }
        return false;
    }

    private boolean validateColumn(List<List<PieceType>> board, PieceType pieceType){
        int boardSize = board.size();
        for (int i = 0; i < boardSize; i++) {
            boolean isColValid = true;
            for (int j = 0; j < boardSize; j++) {
                if(board.get(j).get(i)==null || !(board.get(j).get(i).compareTo(pieceType)==0)){
                    isColValid = false;
                    break;
                }
            }
            if (isColValid)
                return true;
        }
        return false;
    }

    private boolean validateDiagonal(List<List<PieceType>> board, PieceType pieceType){
        int boardSize = board.size()-1;

        // Check left Diagonal
        boolean isLeftDiagonalValid = true;
        for (int i = 0; i <= boardSize; i++) {
            if(board.get(i).get(i)==null || !(board.get(i).get(i).compareTo(pieceType)==0)){
                isLeftDiagonalValid = false;
            }
        }
        boolean isRightDiagonalValid = true;
        for (int i = 0; i <= boardSize; i++) {
            if(board.get(i).get(boardSize-i)==null || !(board.get(i).get(boardSize-i).compareTo(pieceType)==0)){
                isRightDiagonalValid = false;
            }
        }
        return isLeftDiagonalValid || isRightDiagonalValid;
    }
}
