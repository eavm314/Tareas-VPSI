package avance.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorDivTest {
    @Test
    public void verifyDiv() throws Exception {
        Calculator calculator = new Calculator();
        int expectedResult = 5;
        int actualResult = calculator.div(30,6);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyDivByZero() throws Exception {
        Calculator calculator = new Calculator();

        Assertions.assertThrows(Exception.class, () -> {
            calculator.div(3,0);
        });


    }
}
