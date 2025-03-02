package battleship;

public class Main {
    public static void main(String[] args) {

        GameLogic gameManager = new GameLogic(true,true);
        gameManager.startMultiplayerGame();
    }



}