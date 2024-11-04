package org.example;

public class Factorial {

    public Factorial() {
    }

    public static String calculate (int num)  {
        if (num < 1) {
            return "ошибка";
        }
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return String.valueOf(factorial);
    }
}
