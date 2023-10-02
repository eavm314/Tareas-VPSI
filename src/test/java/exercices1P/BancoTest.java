package exercices1P;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BancoTest {
    Asfi serviceAsfiMock = Mockito.mock(Asfi.class);

    @Test
    public void verifyPrestamoMaximo(){

        Mockito.when(serviceAsfiMock.getCategoria("454566")).thenReturn("A");
        Mockito.when(serviceAsfiMock.getCategoria("999999")).thenReturn("B");
        Mockito.when(serviceAsfiMock.getCategoria("77777")).thenReturn("C");


        Banco banco = new Banco();
        banco.setAsfiService(serviceAsfiMock);

        // Primer test
        int actual = banco.getMaximoPrestamo("454566");
        int expected = 200000;
        Assertions.assertEquals(expected,actual,"ERROR> el resultado es incorrecto");

        // Segundo test
        actual = banco.getMaximoPrestamo("999999");
        expected = 100000;
        Assertions.assertEquals(expected,actual,"ERROR> el resultado es incorrecto");

        // Primer test
        actual = banco.getMaximoPrestamo("77777");
        expected = 0;
        Assertions.assertEquals(expected,actual,"ERROR> el resultado es incorrecto");

        Mockito.verify(serviceAsfiMock).getCategoria("454566");
    }
}
