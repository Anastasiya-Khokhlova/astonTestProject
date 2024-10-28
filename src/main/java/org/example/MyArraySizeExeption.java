package org.example;

public class MyArraySizeExeption extends Exception {

    public MyArraySizeExeption() {
        super("Задан некорректный размер массива. Размер массива должен быть 4х4");
    }


}
