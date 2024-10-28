package org.example;


public class Main {
    public static void main(String[] args) {
        String[][] array1 = new String[3][3];
        try {
            System.out.println(getArrayElementsSum(array1));
        } catch (MyArraySizeExeption | MyArrayDataExeption e){
            System.out.println(e);
        }

        String[][] array2 = {{"1", "1", "1", "кот"},{"2", "3", "4", "5"}};
        try {
            System.out.println(getArrayElementsSum(array2));
        } catch (MyArraySizeExeption | MyArrayDataExeption e) {
            System.out.println(e);
        }
        String[][] array3 = {{"1", "1", "1", "8"},{"2", "3", "4", "5"}};
        try {
            System.out.println(getArrayElementsSum(array3));
        } catch (MyArraySizeExeption | MyArrayDataExeption e) {
            System.out.println(e);
        }


    }

    public static int getArrayElementsSum(String[][] twoDimArray)
            throws MyArraySizeExeption, MyArrayDataExeption  {
        if (twoDimArray[0].length != 4 || twoDimArray[1].length != 4) {
            throw new MyArraySizeExeption ();
        }
        int sum = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(twoDimArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataExeption(i, j);
                }
            }
        }
        return sum;
    }
}