package fr.gwenrspl;

import fr.gwenrspl.exceptions.FileParserException;
import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.exceptions.InvalidOrientationCharacter;
import fr.gwenrspl.mower.Instruction;
import fr.gwenrspl.mower.Mower;
import fr.gwenrspl.mower.position.Orientation;
import fr.gwenrspl.mower.position.Position;
import fr.gwenrspl.utils.FileParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileParserTest {

    @Test
    public void should_create_valid_lawn() throws FileParserException {
        Lawn expectedLawn = new Lawn(5, 5);
        assertThat(FileParser.parseLawn()).isEqualTo(expectedLawn);
    }

    @Test
    public void should_create_valid_mowers() throws FileParserException, InvalidOrientationCharacter, InvalidInstructionCharacter {
        Position p1 = new Position(1, 2, Orientation.NORTH);
        List<Instruction> i1 = new ArrayList<>();
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.FORWARD);
        Mower expectedMower1 = new Mower(p1, i1);

        Position p2 = new Position(3, 3, Orientation.EAST);
        List<Instruction> i2 = new ArrayList<>();
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.FORWARD);
        Mower expectedMower2 = new Mower(p2, i2);

        List<Mower> mowers = Arrays.asList(expectedMower1, expectedMower2);
        assertThat(FileParser.parseMowers()).isEqualTo(mowers);
    }

    @Test
    public void should_return_list_of_chars() {
        String stringToSplit = "ABCDEF";
        List<Character> characterList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');
        assertThat(FileParser.splitToListOfChar(stringToSplit)).isEqualTo(characterList);

    }

}
