package avance.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void verifyAdd(){
        int expectedResult = 250;
        int actualResult = calculator.add(135, 115);

        Assertions.assertEquals(expectedResult, actualResult, "Error, la suma es incorrecta");
    }

    @Test
    public void verifyAdditionImpar(){
        int actualResult=calculator.add(3,3);
        int expectedResult=6;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma entre impares es incorrecta");
    }

    @Test
    public void verifyAdditionImparPar(){
        int actualResult=calculator.add(2,3);
        int expectedResult=5;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma entre impar y par es incorrecta");
    }
}
