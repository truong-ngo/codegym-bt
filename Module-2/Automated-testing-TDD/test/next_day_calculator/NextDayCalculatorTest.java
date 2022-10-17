package next_day_calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void nextDayCalculatorNormalDay() {
        int day = 5;
        int month = 5;
        int year = 2009;
        String expected = "6/5/2009";
        String result = NextDayCalculator.nextDayCalculator(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorEndOfMonth() {
        int day = 31;
        int month = 5;
        int year = 2009;
        String expected = "1/6/2009";
        String result = NextDayCalculator.nextDayCalculator(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorEndOfFebruary() {
        int day = 29;
        int month = 2;
        int year = 2008;
        String expected = "1/3/2008";
        String result = NextDayCalculator.nextDayCalculator(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorEndOfYear() {
        int day = 31;
        int month = 12;
        int year = 2009;
        String expected = "1/1/2010";
        String result = NextDayCalculator.nextDayCalculator(day,month,year);
        assertEquals(expected, result);
    }


    @Test
    void nextDayCalculatorWrongFebDate() {
        int day = 29;
        int month = 2;
        int year = 2009;
        String expected = "Wrong input date";
        String result = NextDayCalculator.nextDayCalculator(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorWrongDate() {
        int day = 29;
        int month = 22;
        int year = 2009;
        String expected = "Wrong input date";
        String result = NextDayCalculator.nextDayCalculator(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void isLeapYear2008() {
        int year = 2008;
        boolean result = NextDayCalculator.isLeapYear(year);
        assertTrue(result);
    }

    @Test
    void isLeapYear2000() {
        int year = 2000;
        boolean result = NextDayCalculator.isLeapYear(year);
        assertTrue(result);
    }

    @Test
    void isLeapYear1900() {
        int year = 1900;
        boolean result = NextDayCalculator.isLeapYear(year);
        assertFalse(result);
    }

    @Test
    void isLeapYear1990() {
        int year = 1990;
        boolean result = NextDayCalculator.isLeapYear(year);
        assertFalse(result);
    }

    @Test
    void is31DayMonthJanuary() {
        int month = 1;
        boolean result = NextDayCalculator.is31DayMonth(month);
        assertTrue(result);
    }

    @Test
    void is31DayMonthApril() {
        int month = 4;
        boolean result = NextDayCalculator.is31DayMonth(month);
        assertFalse(result);
    }

    @Test
    void is31DayMonthFebruary() {
        int month = 2;
        boolean result = NextDayCalculator.is31DayMonth(month);
        assertFalse(result);
    }

    @Test
    void is30DayMonthApril() {
        int month = 4;
        boolean result = NextDayCalculator.is30DayMonth(month);
        assertTrue(result);
    }

    @Test
    void is30DayMonthMarch() {
        int month = 5;
        boolean result = NextDayCalculator.is30DayMonth(month);
        assertFalse(result);
    }

    @Test
    void is30DayMonthFebruary() {
        int month = 2;
        boolean result = NextDayCalculator.is30DayMonth(month);
        assertFalse(result);
    }

    @Test
    void isInputDateValidTrue() {
        int day = 29;
        int month = 5;
        int year = 2009;
        boolean result = NextDayCalculator.isInputDateValid(day,month,year);
        assertTrue(result);
    }

    @Test
    void isInputDateValidFebFalse() {
        int day = 29;
        int month = 2;
        int year = 2009;
        boolean result = NextDayCalculator.isInputDateValid(day,month,year);
        assertFalse(result);
    }

    @Test
    void isInputDateValidWrongMonth() {
        int day = 5;
        int month = 15;
        int year = 2009;
        boolean result = NextDayCalculator.isInputDateValid(day,month,year);
        assertFalse(result);
    }

    @Test
    void getNextNormalDay() {
        int day = 5;
        int month = 5;
        int year = 2009;
        String expected = "6/5/2009";
        String result = NextDayCalculator.getNextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void getFirstDayOfNextMonth() {
        int month = 5;
        int year = 2009;
        String expected = "1/6/2009";
        String result = NextDayCalculator.getFirstDayOfNextMonth(month,year);
        assertEquals(expected, result);
    }

    @Test
    void isLastDayOfMonthJanuary() {
        int day = 31;
        int month = 5;
        int year = 2009;
        boolean result = NextDayCalculator.isLastDayOfMonth(day, month, year);
        assertTrue(result);
    }

    @Test
    void isLastDayOfMonthApril() {
        int day = 30;
        int month = 4;
        int year = 2009;
        boolean result = NextDayCalculator.isLastDayOfMonth(day, month, year);
        assertTrue(result);
    }

    @Test
    void isLastDayOfMonthFebruary() {
        int day = 29;
        int month = 2;
        int year = 2008;
        boolean result = NextDayCalculator.isLastDayOfMonth(day, month, year);
        assertTrue(result);
    }
}