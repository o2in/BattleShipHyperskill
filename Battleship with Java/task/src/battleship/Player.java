package battleship;

import java.util.Scanner;

public class Player {
    private Field visibleField;
    private Field fogField;
    private ShipHandler shipManager;

    Player() {
        visibleField = new Field();
        fogField = new Field();
        shipManager = new ShipHandler();
    }

    public void setupPlayerShips() {
        visibleField.printField();
        Scanner sc = new Scanner(System.in);
        Ship[] ships = {Ship.AIRCRAFT_CARRIER, Ship.BATTLESHIP, Ship.SUBMARINE, Ship.CRUISER, Ship.DESTROYER};
        int gameStartCount = 0;

        while (gameStartCount < ships.length) {
            Ship currentShip = ships[gameStartCount]; // Extracted ship logic into an array
            System.out.println("Enter the coordinates of the " + currentShip + " (" + currentShip.getLength() + "):");

            String input = sc.nextLine();
            Placement placement = createPlacement(input); // Extracted object creation into a method

            // Validate and add ship
            if (!shipManager.addShipCondition(currentShip, placement)) {
                continue;
            }

            shipManager.addShipAction(new ShipInstance(currentShip), placement);
            visibleField.modifyField(placement);
            visibleField.printField();

            gameStartCount++;
        }
        System.out.println("Press enter and pass the move to another player");
        System.out.println("...");
        sc.nextLine();

    }
// Extracted helper method for creating Placement
        private Placement createPlacement (String input){
            String[] coordinates = input.split(" ");
            Node startNode = new Node(coordinates[0]);
            Node endNode = new Node(coordinates[1]);
            return new Placement(startNode, endNode);
        }


    public void takeShot() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Take a shot!");
            String input = sc.nextLine();
            Node shot = new Node(input);
            boolean anyShipsHit = false;
            // is shot valid //has this spot already been hit
            if (shot.isValid() && !shipManager.alreadyShot(shot)) {
                //go through every ship
                for (ShipInstance s : shipManager.getShipInstances()) {
                    // is the shot on target
                    if (s.shipHit(shot)) {
                        anyShipsHit = true;
                        shipManager.recordHitList(shot);
                        fogField.recordHit(shot);
                        // if ship hit set trigger
                        if (s.shipSunkStatus()) {
                            // check if game has ended
                            if (shipManager.allShipsHaveHit()) {
                                return;
                            }
                            //otherwise another ship sank
                            System.out.println("You sank a ship!");

                        } else {
                            System.out.println("You hit a ship!");
                        }
                        visibleField.recordHit(shot);
                        return;
                    }
                    //end of for loop go to next ship
                }
                //once ever ship has been checked confirm miss
                if (!anyShipsHit) {
                    shipManager.recordMissList(shot);
                    fogField.recordMiss(shot);
                    System.out.println();
                    System.out.println("You missed!");
                    visibleField.recordMiss(shot);
                    return;
                }
            } else {
                // possibly move this in other if statement for not containing shot
                System.out.println("Error! You entered the wrong coordinates! Try again");
                return;
            }
        }
    }


    public void printFogField() {
        fogField.printField();
        System.out.print("---------------------");
    }

    public void printVisibleField() {
        visibleField.printField();
        System.out.println();
    }

    public ShipHandler getShipHandler() {
        return shipManager;
    }



}