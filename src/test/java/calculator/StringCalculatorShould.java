package calculator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    private StringCalculator stringCalculator;

    @Before
    public void initialize() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void numbersCommaDelimitedShouldBeSummed() {
        assertEquals(3,stringCalculator.add("1,2"));
    }

    @Test
    public void numbersNewlineDelimitedShouldBeSummed() {
        assertEquals(3,StringCalculator.add("1\n2"));
    }
}
