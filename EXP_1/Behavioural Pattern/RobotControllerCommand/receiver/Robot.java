package receiver;
import utils.LoggerUtil;

public class Robot {

    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.NORTH;

    public void moveForward() {
        switch (direction) {
            case NORTH -> y++;
            case SOUTH -> y--;
            case EAST -> x++;
            case WEST -> x--;
        }
        LoggerUtil.log("Robot moved forward to position: (" + x + "," + y + ") facing " + direction);
    }

    public void moveBackward() {
        switch (direction) {
            case NORTH -> y--;
            case SOUTH -> y++;
            case EAST -> x--;
            case WEST -> x++;
        }
        LoggerUtil.log("Robot moved backward to position: (" + x + "," + y + ") facing " + direction);
    }

    public void turnLeft() {
        direction = switch (direction) {
            case NORTH -> Direction.WEST;
            case WEST -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
            case EAST -> Direction.NORTH;
        };
        LoggerUtil.log("Robot turned left. Now facing " + direction);
    }

    public void turnRight() {
        direction = switch (direction) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
        };
        LoggerUtil.log("Robot turned right. Now facing " + direction);
    }

    public void pickPlaceObject() {
        LoggerUtil.log("Robot performed pick/place action at position: (" + x + "," + y + ")");
    }

    public String getPosition() {
        return "(" + x + "," + y + ")";
    }

    public Direction getDirection() {
        return direction;
    }
}
