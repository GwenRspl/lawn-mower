package fr.gwenrspl.mower;

import fr.gwenrspl.exceptions.InvalidInstructionCharacter;

/**
 * The Instruction enum
 *
 * @author Gwen Rspl
 */
public enum Instruction {
    /**
     * Instruction to turn left
     */
    LEFT('G'),
    /**
     * Instruction to turn right
     */
    RIGHT('D'),
    /**
     * Instruction to go forward
     */
    FORWARD('A');

    private final char instructionChar;

    Instruction(char instructionChar) {
        this.instructionChar = instructionChar;
    }

    /**
     * This method parses a character to an instruction enum
     *
     * @param character the character to parse to instruction
     * @return the instruction corresponding to the character
     * @throws InvalidInstructionCharacter when it encounters a character that it cannot parse to an instruction
     */
    public static Instruction getByChar(char character) throws InvalidInstructionCharacter {
        for (Instruction instruction : Instruction.values()) {
            if (character == instruction.instructionChar) {
                return instruction;
            }
        }
        throw new InvalidInstructionCharacter(character + " is not a valid instruction character");
    }
}
