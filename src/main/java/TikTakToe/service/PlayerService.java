package TikTakToe.service;

import TikTakToe.constant.PieceType;
import TikTakToe.model.Player;
import TikTakToe.repository.InMemory;

import java.util.HashMap;

public class PlayerService {

    InMemory inMemory;

    PlayerService(){
        inMemory = InMemory.getInMemory();
    }

    public Player addPlayer(String name, PieceType pieceType){
        Player player = new Player(name, pieceType);
        inMemory.getPlayerMap().putIfAbsent(pieceType, player);
        return player;
    }
}
