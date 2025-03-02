class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {

       /*
        int x = toX - robot.getX();
        int y = toY - robot.getY();
        int nX = Math.abs(x);
        int nY = Math.abs(y);
        Direction direction = robot.getDirection();


//        ++,-+,--,+-

        // iterate over quadrant then iterate through different directions
        //and create steps to reach destination


        int rotCounter = 0;
        switch (direction) {
            case RIGHT:
                if (x > 0) {
                    moveN_Steps(nX, robot);
                }
                if (y > 0) {
                    rotCounter++;
                    robot.turnLeft();
                    moveN_Steps(nY, robot);
                } else {
                    rotCounter--;
                    robot.turnRight();
                    moveN_Steps(nY, robot);
                }
                if (x < 0) {
                    rotateHelper(rotCounter, robot);
                    moveN_Steps(nX, robot);
                }
                break;
            case LEFT:
                if (x < 0) {
                    moveN_Steps(nX, robot);
                }
                if (y > 0) {
                    rotCounter++;
                    robot.turnRight();
                    moveN_Steps(nY, robot);
                } else {
                    rotCounter--;
                    robot.turnLeft();
                    moveN_Steps(nY, robot);
                }
                if (x > 0) {
                    rotateHelper(rotCounter, robot);
                    moveN_Steps(nX, robot);
                }
                break;
            case UP:
                if (y > 0) {
                    moveN_Steps(nY, robot);
                }

                if (x > 0) {
                    rotCounter--;
                    robot.turnRight();
                    moveN_Steps(nX, robot);
                } else {
                    rotCounter++;
                    robot.turnLeft();
                    moveN_Steps(nX, robot);
                }
                if (y < 0) {
                    rotateHelper(rotCounter, robot);
                    moveN_Steps(nY, robot);
                }
                break;
            case DOWN:
                if (y < 0) {
                    moveN_Steps(nY, robot);
                }
                if (x < 0) {
                    rotCounter--;
                    robot.turnRight();
                    moveN_Steps(nX, robot);
                } else {
                    rotCounter++;
                    robot.turnLeft();
                    moveN_Steps(nX, robot);
                }
                if (y > 0) {
                    rotateHelper(rotCounter, robot);
                    moveN_Steps(nX, robot);
                }
        }


    }

    public static void moveN_Steps(int count, Robot robot) {
        if (count == 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            robot.stepForward();
        }
    }

    public static void rotateHelper(int rotationCounter, Robot robot) {
        if (rotationCounter == 0) {
            robot.turnLeft();
            robot.turnLeft();
        } else if (rotationCounter == 1) {
            robot.turnLeft();
        } else if (rotationCounter == -1) {
            robot.turnRight();
        }
    }
    */

        if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnLeft();
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        } else {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        }

        if (robot.getY() < toY) {
            while (robot.getDirection() != Direction.UP) {
                robot.turnLeft();
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        } else {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }

        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}