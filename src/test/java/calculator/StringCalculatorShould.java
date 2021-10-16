package calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    private StringCalculator stringCalculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        assertEquals(5,stringCalculator.add("5"));
    }

    @Test
    public void numbersCommaDelimitedShouldBeSummed() {
        assertEquals(3,stringCalculator.add("1,2"));
        assertEquals(25,stringCalculator.add("10,15"));
    }

    @Test
    public void numbersNewlineDelimitedShouldBeSummed() {
        assertEquals(3,stringCalculator.add("1\n2"));
        assertEquals(24,stringCalculator.add("11\n13"));
    }

    @Test
    public void threeNumbersDelimitedAnywayShouldBeSummed() {
        assertEquals(6,stringCalculator.add("1,2,3") );
        assertEquals(10,stringCalculator.add("5\n2\n3"));
    }

    @Test
    public void negativeInputReturnsException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative input!");
        stringCalculator.add("-1");
        stringCalculator.add("-5,10\n-15");
    }

    @Test
    public void numbersGreaterThan1000AreIgnored() {
        assertEquals(17, stringCalculator.add("5,12,1001"));
        assertEquals(26, stringCalculator.add("14124,22\n4,1214"));
    }
}
