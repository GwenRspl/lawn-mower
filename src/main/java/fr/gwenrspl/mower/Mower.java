package fr.gwenrspl.mower;

import fr.gwenrspl.Lawn;
import fr.gwenrspl.mower.position.Position;

import java.util.List;
import java.util.Objects;

public class Mower {
    private Position position;
    private List<Instruction> instructions;

    public Mower(Position position, List<Instruction> instructions) {
        this.position = position;
        this.instructions = instructions;
    }


    public Position processInstructions(Lawn lawn) {
        for (Instruction instruction : this.instructions) {
            switch (instruction) {
                case FORWARD:
                    this.position.moveForward(lawn);
                    break;
                case LEFT:
                    this.position.turnLeft();
                    break;
                case RIGHT:
                    this.position.turnRight();
                    break;
            }
        }
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
        Mower mower = (Mower) o;
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
