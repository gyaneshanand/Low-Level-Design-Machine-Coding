package TikTakToe.service;

import TikTakToe.constant.PieceType;
import TikTakToe.model.Board;

import java.util.List;

public class BoardPrinter {

    public BoardPrinter() {
    }

    public static void printBoard(Board board){
        List<List<PieceType>> grid = board.getBoard();
        for(List<PieceType> boardRow : grid){
            for(PieceType p : boardRow){
                if(p==null){
                    System.out.print("-" + "\t");
                }
                else {
                    System.out.print(p.getPieceValue() + "\t");
                }
            }
            System.out.println();
        }
    }
}
