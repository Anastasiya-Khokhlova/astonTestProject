package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void calculatePositiveTest() {
        String actualResult = Factorial.calculate(4);
        String expectedResult = "24";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void calculateIllegalInsertTest() {
        String actualResult = Factorial.calculate(-1);
        String expectedResult = "ошибка";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateNegativeTest() {
        String actualResult = Factorial.calculate(4);
        String expectedResult = "25";
        Assert.assertNotEquals(expectedResult, actualResult);
    }

}
