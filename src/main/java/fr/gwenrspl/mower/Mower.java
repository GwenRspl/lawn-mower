package fr.gwenrspl.mower;

import fr.gwenrspl.Lawn;
import fr.gwenrspl.mower.position.Position;

import java.util.List;
import java.util.Objects;

/**
 * The class representing the mower
 *
 * @author Gwen Rspl
 */
public class Mower {
    /**
     * The position of the mower on the lawn
     */
    private final Position position;
    /**
     * The list of instructions the mower must execute
     */
    private final List<Instruction> instructions;

    public Mower(Position position, List<Instruction> instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    /**
     * This method make the mower process the instructions to move on the lawn
     *
     * @param lawn the lawn where the mower is located
     * @return the new position of the mower after executing all the instructions
     */
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
