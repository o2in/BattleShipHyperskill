package battleship;

import java.util.ArrayList;

public class ShipHandler {
    private TripleList<Node> shotsRecordedList;
    private ArrayList<ShipInstance> shipInstances;


    public ShipHandler() {
        shotsRecordedList = new TripleList<>();
        shipInstances = new ArrayList<>();
        for (Ship s : Ship.values()) {
            shipInstances.add(new ShipInstance(s));
        }

    }


    public void addShipAction(ShipInstance ship, Placement placement) {
        for (ShipInstance s : shipInstances) {
            if (s.getShip().equals(ship.getShip())) {
                if (s.getPosition() == null)
                    s.setPosition(placement);
                else {
                    System.out.println("Error! Ship is already placed! Try again!");
                    return;
                }
            }
        }
    }


    public boolean addShipCondition(Ship ship, Placement placement) {

        if (!placement.validPlacement()) {
            System.out.println("Error! Wrong ship location! Try again!");
        } else if (placement.initLength() != ship.getLength()) {
            System.out.println("Error! Wrong length of the " + ship + "! Try again!");
        } else if (isShipPlacedBeside(placement)) {
            System.out.println("Error! Ship is placed beside another ship! Try again!");
        } else {
            return true;
        }
        return false;
    }


    public ArrayList<ShipInstance> getShipInstances() {
        return shipInstances;
    }

    private boolean isShipPlacedBeside(Placement placement) {
        for (ShipInstance s : shipInstances) {
            for (Node n1 : placement.getNodes()) {
                if (s.getPosition() == null) {
                    continue;
                }
                for (Node n2 : s.getPosition().getNodes()) {
                    if (isOneUnitAway(n1.getX(), n1.getY(), n2.getX(), n2.getY())) {
                        return true;
                    }
                }
                if (s.getPosition().getNodes().contains(n1)) {
                    return true;
                }
            }

        }

        //if false means there is no value already beside the cell
        //and we can proceed (ideal path)
        return false;
    }


    static boolean isOneUnitAway(int x1, int y1, int x2, int y2) {
        // Calculate the difference in X and Y coordinates
        int xDifference = Math.abs(x1 - x2);
        int yDifference = Math.abs(y1 - y2);

        // Check if they are exactly 1 unit away
        if ((xDifference == 1 && yDifference == 0) ||
                (yDifference == 1 && xDifference == 0)) {
            return true; // They are 1 unit away in X direction
        }

        // Otherwise, return false (Not 1 unit in either X or Y direction)
        return false;
    }


    public boolean alreadyShot(Node shot) {
        return shotsRecordedList.alreadyShot(shot);
    }

    private void recordShotList(Node node) {
        shotsRecordedList.add("shot", node);

    }

    public void recordHitList(Node node) {
        shotsRecordedList.add("hit", node);
        recordShotList(node);
    }

    public void recordMissList(Node node) {
        shotsRecordedList.add("miss", node);
        recordShotList(node);
    }

    public boolean allShipsHaveHit() {
        return shotsRecordedList.allHit();
    }
}