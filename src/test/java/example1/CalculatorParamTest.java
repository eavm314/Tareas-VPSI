package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorParamTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "2,2,4",
                    "2,7,9",
                    "-3,-6,-9",
                    "123,-7,116"
            }
    )
    public void verifyAdd(int num1, int num2, int expectedResult){
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(num1, num2);

        Assertions.assertEquals(expectedResult, actualResult, "Error, la suma es incorrecta");
    }
}
