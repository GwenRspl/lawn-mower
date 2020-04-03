package fr.gwenrspl;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowersHandlerTest {

    @Test
    public void should_return_correct_string_given_valid_instruction_file() {
        String actualResult = new MowersHandler().executeMowersHandler();
        String expectedResult = "1 3 N\n5 1 E";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
