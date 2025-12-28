import entities.GameBox;
import enums.GameState;
import enums.PlayerSymbol;

import java.util.HashMap;
import java.util.Map;

public class GameDriver {
    private static volatile GameDriver INSTANCE;
    Map<String,GameBox> boxes = new HashMap<>();
    private PlayerSymbol currentPlayer;
    private GameState gameState =  GameState.NOT_STARTED;
    private static int filledNumber = 0;

    public static GameDriver getInstance() {
        if (INSTANCE == null) {
            synchronized (GameDriver.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GameDriver();
                }
            }
        }
        return INSTANCE;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setCurrentPlayer(PlayerSymbol symbol) {
        currentPlayer = symbol;
    }
    public PlayerSymbol getCurrentPlayer() {
        return currentPlayer;
    }
    public void initializeGameboard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                GameBox box = new GameBox(row, col);
                String key = row+"-"+col;
                boxes.put(key,box);
            }
        }
        setGameState(GameState.RUNNING);
        setCurrentPlayer(PlayerSymbol.CROSS);

    }

    public void makeMove(int row, int col) {
        String key = row+"-"+col;
        GameBox box = boxes.get(key);
        if(box.getSymbol() == PlayerSymbol.EMPTY) {
            box.setSymbol(currentPlayer);
            filledNumber++;
        }else {
            System.out.println("This box isn't available");
            return;
        }
        checkGameStatus();
        printGameBoard();
    }

    public void printGameBoard() {
        for(int row = 0; row < 3; row++) {
            String rowState = "";
            for(int col = 0; col < 3; col++) {
                String key = row+"-"+col;
                GameBox box = boxes.get(key);
                if(box.getSymbol() == PlayerSymbol.EMPTY) {
                    rowState += " -";
                }else if(box.getSymbol() == PlayerSymbol.CIRCLE) {
                    rowState += " O";
                }else{
                    rowState += " X";
                }
            }
            System.out.println(rowState);
        }
    }

    public void stopGame(GameState state) {
        setGameState(state);
        if (state == GameState.DRAW) {
            System.out.println("Game has been finished. Its a Draw");
        }else {
            System.out.println("Game has been finished. " + state.toString() + " is the winner.");
        }
    }

    public void checkGameStatus() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                GameBox box = boxes.get(row+"-"+col);
                if(box.getSymbol() == PlayerSymbol.EMPTY || box.getSymbol() != currentPlayer) {
                    break;
                }else{
                    if(col == 2){
                        if (currentPlayer == PlayerSymbol.CROSS)
                            stopGame(GameState.WINNER_X);
                        else
                            stopGame(GameState.WINNER_O);
                        return;
                    }
                }
            }
        }

        for(int col = 0; col < 3; col++) {
            for(int row = 0; row < 3; row++) {
                GameBox box = boxes.get(row+"-"+col);
                if(box.getSymbol() == PlayerSymbol.EMPTY || box.getSymbol() != currentPlayer) {
                    break;
                }else{
                    if(row == 2){
                        if (currentPlayer == PlayerSymbol.CROSS)
                            stopGame(GameState.WINNER_X);
                        else
                            stopGame(GameState.WINNER_O);
                        return;
                    }
                }
            }
        }

        for(int row = 0,col=0; row < 3; row++) {
            col = row;
            GameBox box = boxes.get(row+"-"+col);
            if(box.getSymbol() == PlayerSymbol.EMPTY || box.getSymbol() != currentPlayer) {
                break;
            }
            if(row == 2){
                if (currentPlayer == PlayerSymbol.CROSS)
                    stopGame(GameState.WINNER_X);
                else
                    stopGame(GameState.WINNER_O);
                return;
            }

        }

        for(int row = 0,col=2; row < 3; row++,col--) {
            GameBox box = boxes.get(row+"-"+col);
            if(box.getSymbol() == PlayerSymbol.EMPTY || box.getSymbol() != currentPlayer) {
                break;
            }
            if(row == 2){
                if (currentPlayer == PlayerSymbol.CROSS)
                    stopGame(GameState.WINNER_X);
                else
                    stopGame(GameState.WINNER_O);
                return;
            }
        }
        if(filledNumber == 9){
            stopGame(GameState.DRAW);
            return;
        }
        if(currentPlayer == PlayerSymbol.CROSS){
            setCurrentPlayer(PlayerSymbol.CIRCLE);
        }else{
            setCurrentPlayer(PlayerSymbol.CROSS);
        }
    }
}
