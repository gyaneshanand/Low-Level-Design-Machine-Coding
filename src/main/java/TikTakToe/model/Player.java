package TikTakToe.model;

import TikTakToe.constant.PieceType;

public class Player extends Person{

    String playerId;
    PieceType pieceType;

    public Player(String name, PieceType pieceType) {
        super(name);
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
