import enums.GameState;
import enums.PlayerSymbol;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameDriver gameDriver = GameDriver.getInstance();
        gameDriver.initializeGameboard();
        while(gameDriver.getGameState() == GameState.RUNNING) {
            System.out.println(gameDriver.getCurrentPlayer().toString() + ", please make your move!");
            int row = sc.nextInt();
            int column = sc.nextInt();
            gameDriver.makeMove(row, column);
        }
    }
}