package avance.example1Mocks;

import avance.mockExample1.CalculatorAdvanced;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorAdvancedTestBad {

     // no debemos realizar test normales cuando existe dependencia y llamadas a otros metodos
     // para eso usar MOCKS!
    @Test
    public void verifyFactorial(){
        CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();
        int actual = calculatorAdvanced.getFactorial(3);
        int expected = 6;
        Assertions.assertEquals(expected,actual,"ERROR! el factorial es incorrecto");
    }

}
