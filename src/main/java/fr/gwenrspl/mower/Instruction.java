package fr.gwenrspl.mower;

import fr.gwenrspl.exceptions.InvalidInstructionCharacter;

public enum Instruction {
    LEFT('G'),
    RIGHT('D'),
    FORWARD('A');

    private final char instructionChar;

    Instruction(char instructionChar) {
        this.instructionChar = instructionChar;
    }

    public static Instruction getByChar(char character) throws InvalidInstructionCharacter {
        for (Instruction instruction : Instruction.values()) {
            if (character == instruction.instructionChar) {
                return instruction;
            }
        }
        throw new InvalidInstructionCharacter(character + " is not a valid instruction character");
    }
}
