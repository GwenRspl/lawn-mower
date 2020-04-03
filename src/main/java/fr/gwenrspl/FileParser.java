package fr.gwenrspl;

import fr.gwenrspl.exceptions.FileParserException;
import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.exceptions.InvalidOrientationCharacter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {
    private static final String PATH_TO_FILE = "src/resources/input.txt";

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

    public static List<Character> splitToListOfChar(String str) {
        return str.chars()
                .mapToObj(item -> (char) item)
                .collect(Collectors.toList());
    }
}
