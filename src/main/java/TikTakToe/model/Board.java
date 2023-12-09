package TikTakToe.model;

import TikTakToe.constant.PieceType;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<PieceType>> board;

    public Board(int boardSize) {
        this.board = new ArrayList<>();
        initializeBoard(boardSize);
    }

    private void initializeBoard(int boardSize){
        for (int i = 0; i < boardSize; i++) {
            List<PieceType> boardRow = new ArrayList<PieceType>();
            for (int j = 0; j < boardSize; j++) {
                boardRow.add(null);
            }
            board.add(boardRow);
        }
    }

    public List<List<PieceType>> getBoard() {
        return board;
    }

    public int getBoardSize(){
        return board.size();
    }

    public PieceType getPieceAtPosition(int row, int col){
        // Assuming row and col index are valid
        return board.get(row).get(col);
    }

    public void addPieceAtPosition(int row, int col, PieceType pieceType){
        // Assuming row and col index are valid
        board.get(row).set(col, pieceType);
    }
}
