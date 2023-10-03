package tareas.practice1P;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DaysTest {
    @ParameterizedTest
    @CsvSource(
        {
            "1,1,2000, 02/01/2000",
            "15,1,2000, 16/01/2000",
            "1,11,2000, 02/11/2000",
            "15,11,2000, 16/11/2000",
            "1,1,1937, 02/01/1937",
            "15,1,1937, 16/01/1937",
            "1,11,1937, 02/11/1937",
            "15,11,1937, 16/11/1937",
        }
    )
    public void verifyDaysBeforeLast(int day, int month, int year, String expectedResult){
        Days days = new Days();
        String actualResult = days.nextDay(day, month, year);

        Assertions.assertEquals(expectedResult, actualResult, "Error, la fecha proporcionada no es correcta para los dias en medio del mes");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "31,1,2001, 01/02/2001",
                    "31,3,2001, 01/04/2001",
                    "31,5,2001, 01/06/2001",
                    "31,7,2001, 01/08/2001",
                    "31,8,2001, 01/09/2001",
                    "31,10,2001, 01/11/2001",
            }
    )
    public void verifyLastDaysOfTheMonth(int day, int month, int year, String expectedResult){
        Days days = new Days();
        String actualResult = days.nextDay(day, month, year);

        Assertions.assertEquals(expectedResult, actualResult, "Error, la fecha proporcionada no es correcta para los ultimos dias del mes");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "31,12,1880, 01/01/1881",
                    "31,12,2003, 01/01/2004",
            }
    )
    public void verifyLastDaysOfTheYear(int day, int month, int year, String expectedResult){
        Days days = new Days();
        String actualResult = days.nextDay(day, month, year);

        Assertions.assertEquals(expectedResult, actualResult, "Error, la fecha proporcionada no es correcta para los ultimos dias del año");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "28,2,2019, 01/03/2019",
                    "28,2,1987, 01/03/1987",
                    "29,2,2004, 01/03/2004",
                    "29,2,2404, 01/03/2404",
            }
    )
    public void verifyLastDaysOfFebruary(int day, int month, int year, String expectedResult){
        Days days = new Days();
        String actualResult = days.nextDay(day, month, year);

        Assertions.assertEquals(expectedResult, actualResult, "Error, la fecha proporcionada no es correcta para Los ultimos dias de febrero");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "-1,1,2000",
                    "15,-1,2000",
                    "1,11,-2000",
                    "15,-11,-2000",
                    "-1,-1,1937",
                    "-15,1,-1937",
                    "-1,-11,-1937",
                    "15,0,-2000",
                    "0,-1,1937",
                    "0,3,1937",
                    "-1,-11,0",
                    "1,11,0",
                    "0,0,0",
            }
    )
    public void verifyNegativeOrZeroDates(int day, int month, int year){
        Days days = new Days();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String actualResult = days.nextDay(day, month, year);
        }, "La fecha, no debería ser valida por ser 0 o negativa");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "32,1,2000",
                    "32,3,2000",
                    "31,4,2000",
                    "32,7,2000",
                    "32,8,2000",
                    "31,9,2000",
                    "32,10,2000",
                    "31,11,2000",
                    "32,12,2000",
                    "30,2,2000",
                    "29,2,2001",
            }
    )
    public void verifyDatesOutOfBound(int day, int month, int year){
        Days days = new Days();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String actualResult = days.nextDay(day, month, year);
        }, "La fecha, no debería ser valida por sobrepasar los dias de un mes");
    }
}
