package battleship;

import java.util.ArrayList;
import java.util.Objects;

public class Node {
    private int xPos;
    private int yPos;
    private ArrayList<Integer> pos;

    public Node(String inputString) {


        this.pos = new ArrayList<>();
        converter(inputString);
        //flips the input to make x the first value in int and y the second value
        xPos=pos.get(0);
        yPos=pos.get(1);

    }

    public boolean isValid() {
        if (xPos < 1 || xPos > 10 || yPos < 1 || yPos > 10) {
            return false;
        }
        return true;
    }

    public int getX() {
        return xPos;
    }

    public char charYPos() {
        return ((char) (yPos + 64));
    }

    public int getY() {
        return yPos;
    }

    public void converter(String input){
        if(input == null ){
            return;
        }
        pos.add(Integer.valueOf(input.substring(1)));
        pos.add(input.charAt(0)-64);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return xPos == node.xPos && yPos == node.yPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPos, yPos);
    }

    @Override
    public String toString() {
        return "Node{" + charYPos() + ", " + xPos + '}';
    }
}