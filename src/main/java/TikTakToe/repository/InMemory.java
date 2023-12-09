package TikTakToe.repository;

import TikTakToe.constant.PieceType;
import TikTakToe.model.Player;

import java.util.HashMap;

public class InMemory {

    private static InMemory inMemory;
    HashMap<PieceType, Player> playerMap;

    private InMemory(){
        playerMap = new HashMap<>();
    }

    public static InMemory getInMemory(){
        if(inMemory == null){
            inMemory = new InMemory();
        }
        return inMemory;
    }

    public HashMap<PieceType, Player> getPlayerMap() {
        return playerMap;
    }
}
