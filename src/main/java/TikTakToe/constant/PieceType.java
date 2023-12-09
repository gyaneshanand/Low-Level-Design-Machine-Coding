package TikTakToe.constant;

public enum PieceType {
    X("X"),
    O("O");

    String pieceValue;

    PieceType(String o) {
        this.pieceValue = o;
    }

    public String getPieceValue(){
        return this.pieceValue;
    }
}
