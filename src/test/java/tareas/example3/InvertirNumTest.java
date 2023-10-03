package tareas.example3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InvertirNumTest {
    @ParameterizedTest
    @CsvSource(
            {
                "0,0",
                "2,2",
                "21,12",
                "123,321",
                "2147483647,7463847412",
                "-1,Valor Incorrecto",
                "-45, Valor Incorrecto",
                "-2147483648, Valor Incorrecto",
            }
    )
    public void verifyTest(int num, String invertedNum){
        InvNumber inv = new InvNumber();

        String actualResult = inv.invertir(num);

        Assertions.assertEquals(invertedNum, actualResult);
    }
}
