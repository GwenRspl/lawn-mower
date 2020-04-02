package fr.gwenrspl;

import java.util.List;
import java.util.Objects;

public class MowerImpl implements Mower {
    private Position position;
    private List<Instruction> instructions;

    public MowerImpl(Position position, List<Instruction> instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    @Override
    public void moveForward() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public Position processInstructions() {
        return this.position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public List<Instruction> getInstructions() {
        return this.instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        MowerImpl mower = (MowerImpl) o;
        return Objects.equals(this.position, mower.position) &&
                Objects.equals(this.instructions, mower.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position, this.instructions);
    }

    @Override
    public String toString() {
        return "MowerImpl{" +
                "position=" + this.position +
                ", instructions=" + this.instructions +
                '}';
    }
}
