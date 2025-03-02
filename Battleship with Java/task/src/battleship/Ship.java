package battleship;

public enum Ship {
    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);
    private String name;
    private final int length;


    //status can be counter for hits
    Ship(String nm, int length) {
        this.name = nm;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return  name ;
    }



}