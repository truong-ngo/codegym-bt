package next_day_calculator;

public class NextDayCalculator {

    public static String nextDayCalculator(int day, int month, int year) {
        if (!isInputDateValid(day, month, year)) {
            return "Wrong input date";
        }
        String result;
        final int DECEMBER = 12;
        if (month != DECEMBER) {
            result = (isLastDayOfMonth(day, month, year)) ? getFirstDayOfNextMonth(month, year)
                                                          : getNextDay(day, month, year);
        } else {
            result = (isLastDayOfMonth(day, month, year)) ? "1/1/" + (year + 1)
                                                          : getNextDay(day, month, year);
        }
        return result;
    }

    public static boolean isLeapYear(int year) {
        final int FOUR = 4;
        final int ONE_HUNDRED = 100;
        final int FOUR_HUNDRED = 400;
        boolean isDivisibleByFour = year % FOUR == 0;
        boolean isDivisibleByOneHundred = year % ONE_HUNDRED == 0;
        boolean isDivisibleByFourHundred = year % FOUR_HUNDRED == 0;
        if (isDivisibleByFour) {
            if (isDivisibleByOneHundred) {
                return isDivisibleByFourHundred;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean is31DayMonth(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return true;
            default:
                return false;
        }
    }

    public static boolean is30DayMonth(int month) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return true;
            default:
                return false;
        }
    }

    public static boolean isInputDateValid(int day, int month, int year) {
        final int FEBRUARY = 2;
        if (month == FEBRUARY) {
            if (isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if (is30DayMonth(month)) {
            return day <= 30;
        } else if (is31DayMonth(month)) {
            return day <= 31;
        } else {
            return false;
        }
    }

    public static boolean isLastDayOfMonth(int day, int month, int year) {
        if (is30DayMonth(month)) {
            return day == 30;
        } else if (is31DayMonth(month)) {
            return day == 31;
        } else {
            if (isLeapYear(year)) {
                return day == 29;
            } else {
                return day == 28;
            }
        }
    }

    public static String getNextDay(int day, int month, int year) {
        return (day + 1) + "/" + month + "/" + year;
    }

    public static String getFirstDayOfNextMonth(int month, int year) {
        return "1/" + (month + 1) + "/" + year;
    }
}
