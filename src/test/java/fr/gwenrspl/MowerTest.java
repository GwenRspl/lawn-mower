package fr.gwenrspl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {

    Lawn lawn;

    @Before
    public void setUp() {
        this.lawn = new Lawn(5, 5);
    }

    @Test
    public void should_move_correctly_given_valid_instructions() {
        List<Instruction> instructions = Arrays.asList(Instruction.RIGHT, Instruction.FORWARD, Instruction.LEFT,
                Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD, Instruction.LEFT, Instruction.FORWARD,
                Instruction.RIGHT, Instruction.FORWARD, Instruction.RIGHT, Instruction.FORWARD);
        Mower actualMower = new Mower(new Position(2, 1, Orientation.NORTH), instructions);
        Mower expectedMower = new Mower(new Position(3, 5, Orientation.EAST), null);
        actualMower.processInstructions(this.lawn);
        assertThat(actualMower.getPosition()).isEqualTo(expectedMower.getPosition());
    }

    @Test
    public void should_move_correctly_given_instructions_outside_lawn() {
        List<Instruction> instructions = Arrays.asList(Instruction.RIGHT, Instruction.FORWARD, Instruction.RIGHT,
                Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD, Instruction.RIGHT, Instruction.FORWARD,
                Instruction.LEFT, Instruction.FORWARD, Instruction.LEFT, Instruction.FORWARD);
        Mower actualMower = new Mower(new Position(5, 5, Orientation.NORTH), instructions);
        Mower expectedMower = new Mower(new Position(5, 1, Orientation.EAST), null);
        actualMower.processInstructions(this.lawn);
        assertThat(actualMower.getPosition()).isEqualTo(expectedMower.getPosition());
    }

    @Test
    public void should_not_move_given_empty_instructions() {
        List<Instruction> instructions = new ArrayList<>();
        Mower actualMower = new Mower(new Position(2, 1, Orientation.NORTH), instructions);
        Mower expectedMower = new Mower(new Position(2, 1, Orientation.NORTH), instructions);
        actualMower.processInstructions(this.lawn);
        assertThat(actualMower.getPosition()).isEqualTo(expectedMower.getPosition());
    }


}
