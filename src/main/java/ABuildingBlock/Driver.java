package ABuildingBlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        String input = br.readLine();
        while (!input.equalsIgnoreCase("exit")){

            // Action 1
            String action = input.split(" ")[0];
            if(action.equals("action1")){

            } else if (action.equals("action2")) {

            }else {
                System.out.println("Invalid Input");
            }

            input = br.readLine();
        }
        System.out.println("Thank You!");
    }
}
