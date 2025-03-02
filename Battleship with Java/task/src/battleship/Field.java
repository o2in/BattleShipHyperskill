package battleship;


public class Field {

    private char[][] gameField = new char[11][11];

    public Field() {
        for (int i = 0; i < 10; i++) {
            this.gameField[0][i] = (char) (i + 48);
            for (int j = 66; j <= 75; j++) {
                gameField[j - 65][0] = (char) (j - 1);
                gameField[i + 1][j - 65] = '~';
            }
        }
        gameField[0][0] = ' ';
    }

    public char[][] getGameField() {
        return gameField;
    }

    public void modifyField(Placement placement) {
        placement.getNodes().forEach(node -> gameField[node.getY()][node.getX()] = 'O');

    }

    public void recordHit(Node node) {

        gameField[node.getY()][node.getX()] = 'X';

    }

    public void recordMiss(Node node) {
        gameField[node.getY()][node.getX()] = 'M';

    }

    public void printField() {

        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 10) {
                    System.out.print("10");
                    continue;
                }
                System.out.print(this.gameField[i][j] + " ");
            }
        }
        System.out.println();
    }
}