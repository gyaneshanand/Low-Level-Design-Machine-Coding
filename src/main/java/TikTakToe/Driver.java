package TikTakToe;

import TikTakToe.service.GameService;
import TikTakToe.util.DefaultResultValidationStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        DefaultResultValidationStrategy resultValidationStrategy = new DefaultResultValidationStrategy();
        GameService gameService = new GameService(3, resultValidationStrategy);

        gameService.addPlayer("X", "Gaurav");
        gameService.addPlayer("O", "Sagar");

        String input = br.readLine();
        while(!input.equalsIgnoreCase("exit")){
            int row = Integer.parseInt(input.split(" ")[0])-1;
            int col = Integer.parseInt(input.split(" ")[1])-1;

            gameService.makeMove(row, col);

            input = br.readLine();
        }
    }
}
