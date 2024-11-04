package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FactorialTest {

    @Test
    public void calculatePositiveTest() {
        String actualResult = Factorial.calculate(4);
        String expectedResult = "24";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateIllegalInsertTest() {
        String actualResult = Factorial.calculate(-1);
        String expectedResult = "ошибка";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateNegativeTest() {
        String actualResult = Factorial.calculate(4);
        String expectedResult = "25";
        Assertions.assertNotEquals(expectedResult, actualResult);
    }
}
