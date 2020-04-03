package fr.gwenrspl.mower.position;

import fr.gwenrspl.Lawn;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private Orientation orientation;

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

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

    private void moveWest() {
        this.x -= 1;
    }

    private void moveEast() {
        this.x += 1;
    }

    private void moveSouth() {
        this.y -= 1;
    }

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
