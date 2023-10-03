package avance.exampleStaticMock;

import avance.mockExample3.CalculatorAdvanced;
import avance.mockExample3.ServiceCalcStatic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


public class CalculatorAdvancedStaticMockTest {


    @Test
    public void verifyFactorial(){
        // Create Mock
        MockedStatic<ServiceCalcStatic>  serviceCalcStaticMockedStatic = Mockito.mockStatic(ServiceCalcStatic.class);
        // Create method - mock
        serviceCalcStaticMockedStatic.when(()-> ServiceCalcStatic.mult(1,1)).thenReturn(1);
        serviceCalcStaticMockedStatic.when(()-> ServiceCalcStatic.mult(1,2)).thenReturn(2);
        serviceCalcStaticMockedStatic.when(()-> ServiceCalcStatic.mult(2,3)).thenReturn(6);

        CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();
        int actualResult =calculatorAdvanced.getFactorial(3) ;
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! el factorial generado es incorrecto");
    }
}