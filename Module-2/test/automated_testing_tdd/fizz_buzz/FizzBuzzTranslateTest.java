package automated_testing_tdd.fizz_buzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    void fizzBuzzTranslateFizzBuzzCase() {
        int number = 53;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected, result);
    }

    @Test
    void fizzBuzzTranslateFizzCase() {
        int number = 33;
        String expected = "Fizz";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected, result);
    }

    @Test
    void fizzBuzzTranslateBuzzCase() {
        int number = 25;
        String expected = "Buzz";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected, result);
    }

    @Test
    void fizzBuzzTranslateNormalCase() {
        int number = 49;
        String expected = "Four Nine";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected, result);
    }

    @Test
    void fizzBuzzTranslateNumberExceedCase() {
        int number = 200;
        String expected = "Number >= 100";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected, result);
    }
}