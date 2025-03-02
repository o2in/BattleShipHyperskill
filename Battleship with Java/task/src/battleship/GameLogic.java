package battleship;

import java.util.Scanner;

public class GameLogic {

    private Player playerA;
    private Player playerB;
    private Scanner sc;


    public GameLogic(boolean onePlayer, boolean twoPlayer) {
        playerA = new Player();
        playerB = new Player();
        sc = new Scanner(System.in);
    }

    //multiplayer game
    public void startMultiplayerGame() {
        System.out.println("Player 1, place your ships on the game field");
        playerA.setupPlayerShips();

        System.out.println("Player 2, place your ships on the game field");
        playerB.setupPlayerShips();
        while (true) {
//            System.out.println();
            System.out.println("Player 1, it's your turn:");
            System.out.println();
            playerB.printFogField();
            playerA.printVisibleField();
            playerB.takeShot();
            if (gameOver(playerB)) {
                System.out.println("You sank the last ship. You won. Congratulations! ");
                return;
            }
//            System.out.println();
            System.out.println("Press enter and pass the move to another player");
            System.out.println("...");
            sc.nextLine();
            System.out.println("Player 2, it's your turn:");
            System.out.println();
            playerA.printFogField();
            playerB.printVisibleField();
            playerA.takeShot();
            if (gameOver(playerA)) {
                System.out.println("You sank the last ship. You won. Congratulations! ");
                return;
            }
            System.out.println("Press enter and pass the move to another player");
            System.out.println("...");
            sc.nextLine();
        }
    }


    public boolean gameOver(Player player) {
        return player.getShipHandler().allShipsHaveHit();
    }


}



