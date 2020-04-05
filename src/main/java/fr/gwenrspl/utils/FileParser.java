package fr.gwenrspl.utils;

import fr.gwenrspl.Lawn;
import fr.gwenrspl.exceptions.FileParserException;
import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.exceptions.InvalidOrientationCharacter;
import fr.gwenrspl.mower.Instruction;
import fr.gwenrspl.mower.Mower;
import fr.gwenrspl.mower.position.Orientation;
import fr.gwenrspl.mower.position.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class parsing the content of the input file into {@link Lawn}, {@link Mower} and {@link Instruction}
 *
 * @author Gwen Rspl
 */
public class FileParser {
    /**
     * The path to the file containing the instructions
     */
    private static final String PATH_TO_FILE = "src/resources/input.txt";

    private FileParser() {
    }

    /**
     * Creates a lawn according to the instruction in the input file
     *
     * @return the lawn newly created
     * @throws FileParserException when encounters a problem with the input file
     */
    public static Lawn parseLawn() throws FileParserException {
        int width = 0;
        int height = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_FILE))) {
            String[] stringArray = reader.readLine().split(" ");
            width = Integer.parseInt(stringArray[0]);
            height = Integer.parseInt(stringArray[1]);
        } catch (IOException e) {
            throw new FileParserException("There was a problem while trying to create the lawn, please check the name and content of the file. -> " + e.getMessage());
        }
        return new Lawn(width, height);
    }

    /**
     * Creates a list of mowers according to the instructions in the input file
     *
     * @return the list of mowers newly created
     * @throws FileParserException         when encounters a problem with the input file
     * @throws InvalidOrientationCharacter when it encounters an invalid orientation character
     * @throws InvalidInstructionCharacter when it encounters an invalid instruction character
     */
    public static List<Mower> parseMowers() throws FileParserException, InvalidOrientationCharacter, InvalidInstructionCharacter {
        List<Mower> mowers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_FILE))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] stringArray = line.split(" ");
                int x = Integer.parseInt(stringArray[0]);
                int y = Integer.parseInt(stringArray[1]);
                Orientation orientation = Orientation.getByChar(stringArray[2].charAt(0));
                Position position = new Position(x, y, orientation);

                List<Character> list = splitToListOfChar(reader.readLine());
                List<Instruction> instructions = new ArrayList<>();
                for (Character c : list) {
                    Instruction instruction = Instruction.getByChar(c);
                    instructions.add(instruction);
                }
                Mower mower = new Mower(position, instructions);
                mowers.add(mower);
            }
        } catch (IOException e) {
            throw new FileParserException("There was a problem while trying to create the lawn, please check the name and content of the file. -> " + e.getMessage());
        }
        return mowers;
    }

    /**
     * This method transform a string into a list of characters
     *
     * @param str the string to split into characters
     * @return the list of characters newly created
     */
    public static List<Character> splitToListOfChar(String str) {
        return str.chars()
                .mapToObj(item -> (char) item)
                .collect(Collectors.toList());
    }
}
