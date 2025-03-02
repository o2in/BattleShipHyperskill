package battleship;

import java.util.ArrayList;
import java.util.Objects;

public class Placement {

    private final Node start;
    private final Node end;
    private int length;
    private ArrayList<Node> nodes;

    public Placement(Node start, Node end) {
        this.start = start;
        this.end = end;
        nodes = new ArrayList<>();
        initLength();

    }

    public Node[] getNodesArray(){

        return new Node[] {start,end};
    }


    public boolean validPlacement() {
//check to see if points are within board
        if (!(start.isValid() && end.isValid())) {
            return false;
        }
        // checking to see if placement has both coordinates in same row/column
        if (start.getX() == end.getX() || start.getY() == end.getY()) {
            return true;
        }
        return false;
    }

    public int initLength() {
        if (validPlacement()) {
            if (start.getX() == end.getX()) {
                this.length = Math.abs(start.getY() - end.getY()) + 1;
            } else if (start.getY() == end.getY()) {
                this.length = Math.abs(start.getX() - end.getX()) + 1;
            } else {
                return -1;
            }
        }
        return this.length;
    }

    // null return if there are no parts
    public String getParts() {
        String[] parts;
        if (this.length > 0) {
            int k = 0;
            parts = new String[this.length];
//            if in the same column (x value is the same)
            switch (start.getX() - end.getX()) {
                case 0:
                    if (start.getY() < end.getY()) {
                        for (int i = start.getY(); i <= end.getY(); i++) {
                            parts[k] = String.valueOf((char) (i + 64)) + String.valueOf(start.getX());
                            k++;
                        }

                    } else if (start.getY() > end.getY()) {
                        for (int i = start.getY(); i >= end.getY(); i--) {
                            parts[k] = String.valueOf((char) (i + 64)) + String.valueOf(start.getX());
                            k++;
                        }

                    }
                    break;
//                    if in the same row (y value is the same)
                default:
                    if (start.getX() < end.getX()) {
                        for (int i = start.getX(); i <= end.getX(); i++) {
                            parts[k] = String.valueOf(start.charYPos()) + String.valueOf(i);
                            k++;
                        }

                    } else if (start.getX() > end.getX()) {
                        for (int i = start.getX(); i >= end.getX(); i--) {
                            parts[k] = String.valueOf(start.charYPos()) + String.valueOf(i);
                            k++;
                        }

                    }
                    break;
            }


            return yieldBuilder(parts);
        }
//        calling method to change string array to string
        return null;
    }


    //        creating string with string array
    private String yieldBuilder(String[] parts) {

        StringBuilder yield = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            yield.append(parts[i]);
            yield.append(" ");
        }
        return yield.toString();
    }

    public ArrayList<Node> getNodes() {
        for (int i = 0; i < this.length; i++) {
            String x = this.getParts().split(" ")[i];
            if (nodes.contains(new Node(x)) == false)
                nodes.add(new Node(x));
        }
        return nodes;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Placement placement = (Placement) o;
        return length == placement.length && Objects.equals(start, placement.start) && Objects.equals(end, placement.end) && Objects.equals(nodes, placement.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, length, nodes);
    }

    @Override
    public String toString() {
        return "start=" + start +
                ", end=" + end ;

    }
}