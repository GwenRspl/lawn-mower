package fr.gwenrspl.mower.position;

import fr.gwenrspl.Lawn;
import fr.gwenrspl.mower.Mower;

import java.util.Objects;

/**
 * The class representing the position of a {@link Mower} on the {@link Lawn}
 *
 * @author Gwen Rspl
 */
public class Position {
    /**
     * The x coordinate of the position
     */
    private int x;
    /**
     * The y coordinate of the position
     */
    private int y;
    /**
     * The orientation of the position
     */
    private Orientation orientation;

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * The method to change position and move forward according to the orientation
     *
     * @param lawn the lawn to calculate if the new position will be out of bounds
     */
    public void moveForward(Lawn lawn) {
        switch (this.orientation) {
            case NORTH:
                if (this.y < lawn.getMaxHeight()) {
                    this.moveNorth();
                }
                break;
            case EAST:
                if (this.x < lawn.getMaxWidth()) {
                    this.moveEast();
                }
                break;
            case WEST:
                if (this.x > lawn.getMinWidth()) {
                    this.moveWest();
                }
                break;
            case SOUTH:
                if (this.y > lawn.getMinHeight()) {
                    this.moveSouth();
                }
                break;
        }
    }

    /**
     * The method to change the orientation of the position anticlockwise
     */
    public void turnLeft() {
        switch (this.orientation) {
            case NORTH:
                this.orientation = Orientation.WEST;
                break;
            case EAST:
                this.orientation = Orientation.NORTH;
                break;
            case WEST:
                this.orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.orientation = Orientation.EAST;
                break;
        }

    }

    /**
     * The method to change the orientation of the position clockwise
     */
    public void turnRight() {
        switch (this.orientation) {
            case NORTH:
                this.orientation = Orientation.EAST;
                break;
            case EAST:
                this.orientation = Orientation.SOUTH;
                break;
            case WEST:
                this.orientation = Orientation.NORTH;
                break;
            case SOUTH:
                this.orientation = Orientation.WEST;
                break;
        }
    }

    /**
     * Moves the position west
     */
    private void moveWest() {
        this.x -= 1;
    }

    /**
     * Moves the position east
     */
    private void moveEast() {
        this.x += 1;
    }

    /**
     * Moves the position south
     */
    private void moveSouth() {
        this.y -= 1;
    }

    /**
     * Moves the position north
     */
    private void moveNorth() {
        this.y += 1;
    }

    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }


    public Orientation getOrientation() {
        return this.orientation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return this.x == position.x &&
                this.y == position.y &&
                this.orientation == position.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y, this.orientation);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", orientation=" + this.orientation +
                '}';
    }
}
