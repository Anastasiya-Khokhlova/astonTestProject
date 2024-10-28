package org.example;

public class MyArrayDataExeption extends Exception {

    public MyArrayDataExeption(int x, int y) {
        super("Не удалось выполнить преобразование в ячейке " + x + "," + y);
    }
}