package battleship;

public class ShipInstance {
    private Ship ship;
    private Placement position;
    private int hitCount;
    private boolean sunkStatus;

    public ShipInstance(Ship ship) {
        this.ship = ship;
        this.sunkStatus = false;
        this.hitCount = 0;
    }

    public void setPosition(Placement p) {
        this.position  = p;
    }

    public void shipSunk() {
        if (hitCount >= ship.getLength()) {
            sunkStatus = true;
        }
    }

    public Placement getPosition() {
        return position;
    }

    public boolean shipSunkStatus() {
        return sunkStatus;
    }

    public boolean shipHit(Node shot) {
        for (Node n : this.position.getNodes()) {
            if (shot.equals(n)) {
                hitCount++;
                shipSunk();
                return true;
            }
        }
        return false;
    }
    public Ship getShip() {
        return ship;
    }

    @Override
    public String toString() {
        return "ShipInstance{" +
                "ship=" + ship +"position="+position+
                '}';
    }
}
