package fr.gwenrspl;

import fr.gwenrspl.exceptions.InvalidOrientationCharacter;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrientationTest {

    @Test
    public void should_return_orientation_given_correct_char() throws InvalidOrientationCharacter {
        SoftAssertions should = new SoftAssertions();
        should.assertThat(Orientation.getByChar('N')).isEqualTo(Orientation.NORTH);
        should.assertThat(Orientation.getByChar('E')).isEqualTo(Orientation.EAST);
        should.assertThat(Orientation.getByChar('W')).isEqualTo(Orientation.WEST);
        should.assertThat(Orientation.getByChar('S')).isEqualTo(Orientation.SOUTH);
        should.assertAll();
    }

    @Test
    public void should_throw_exception_given_invalid_char() {
        assertThatThrownBy(() -> Orientation.getByChar('Z')).isInstanceOf(InvalidOrientationCharacter.class);
    }
}
