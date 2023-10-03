package avance.example1Mocks;

import avance.mockExample1.CalculatorAdvanced;
import avance.mockExample1.ServiceCalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculatorAdvancedTest {
    // PASO 2
    // necesitamos crear el objecto falso usando  Mockito.mock(tipo de la clases)

    ServiceCalc serviceCalcMock = Mockito.mock(ServiceCalc.class);

    @Test
    public void verifyFactorial(){
        // PASO 3 > le decimos al metodo que queremos que retorne
        Mockito.when(serviceCalcMock.mult(1,1)).thenReturn(1);
        Mockito.when(serviceCalcMock.mult(1,2)).thenReturn(2);
        Mockito.when(serviceCalcMock.mult(2,3)).thenReturn(6);
        Mockito.when(serviceCalcMock.mult(6,4)).thenReturn(24);
        // PASO 4 > usar el objeto mockeado

        CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();
        calculatorAdvanced.setCalcService(serviceCalcMock);
        int actual = calculatorAdvanced.getFactorial(4);
        int expected = 24;
        Assertions.assertEquals(expected,actual,"ERROR> el factorial es incorrecto");

        // PASO 5  verificar que el mock y los metodos mockeados se usen
        Mockito.verify(serviceCalcMock).mult(1,1);
        Mockito.verify(serviceCalcMock).mult(1,2);
        Mockito.verify(serviceCalcMock).mult(2,3);
        Mockito.verify(serviceCalcMock).mult(6,4);

    }

}
