package tareas.practice1P;

import avance.mockExample3.CalculatorAdvanced;
import avance.mockExample3.ServiceCalcStatic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BancoStaticTest {

    private static MockedStatic<Asfi> asfiMockedStatic;
    @BeforeAll
    public static void setup(){
        // Create Mock
        asfiMockedStatic = Mockito.mockStatic(Asfi.class);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "454566, A, 200000",
                    "999999, B, 100000",
                    "77777, C, 0",
            }
    )
    public void verifyMaximoPrestamo(String ci, String categoria, int montoMaximoEsperado){
        // Create method - mock
        asfiMockedStatic.when(()-> Asfi.getCategoria(ci)).thenReturn(categoria);

        Banco banco = new Banco();
        int actualResult = banco.getMaximoPrestamo(ci) ;

        Assertions.assertEquals(montoMaximoEsperado,actualResult,"ERROR! el monto de prestamo maximo es incorrecto");
    }
}
