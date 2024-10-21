package org.example;


import org.example.lesson10.*;
import org.example.lesson6.Employee;
import org.example.lesson6.Park;

public class Main {
    public static void main(String[] args) {
        lesson10part1();
        lesson10part2();
    }

    public static void lesson10part1() {
        System.out.println("Часть 1:");
        Dog dog1 = new Dog("Шелби");
        Cat cat1 = new Cat("Саманта", 20);
        dog1.run(300);
        dog1.run(700);
        dog1.swim(5);
        dog1.swim(20);
        cat1.run(100);
        cat1.run(500);
        cat1.swim(20);
        Cat.catAmount();
        Dog.dogAmount();
        Animal.animalAmount();
        System.out.println();
        Bowl bowl1 = new Bowl(0);
        bowl1.addEat(50);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Муся", 10);
        cats[1] = new Cat("Маркиз", 30);
        cats[2] = new Cat("Ксюша", 40);
        cats[0].eat(bowl1);
        cats[1].eat(bowl1);
        cats[2].eat(bowl1);
    }

    public static void lesson10part2() {
        System.out.println();
        System.out.println("Часть 2:");
        Circle circle1 = new Circle(3.75, "Серый", "Желтый");
        Rectangle rectangle1 = new Rectangle(5, 2.5, "Голубой", "Синий");
        Triangle triangle1 = new Triangle(5, 5.68, 3, "Фиолетовый", "Оранжевый");
        circle1.figureInfo();
        System.out.println();
        rectangle1.figureInfo();
        System.out.println();
        triangle1.figureInfo();
    }

    public static void lesson6part1() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan Ivanovich", "Engineer",
                "ivanov@gmail.com", "89271111111", 30000, 32);
        employees[0].employeeInfo();
        employees[1] = new Employee("Petrov Petr Petrovich", "Engineer",
                "petrov@gmail.com", "89272222222", 32000, 34);
        employees[1].employeeInfo();
        employees[2] = new Employee("Alekseev Aleksey Alekseevich", "Manager",
                "alekseev@gmail.com", "89273333333", 34000, 30);
        employees[2].employeeInfo();
        employees[3] = new Employee("Sidorova Marina Viktotovna", "Secretary",
                "sidorova@gmail.com", "89274444444", 15000, 19);
        employees[3].employeeInfo();
        employees[4] = new Employee("Kosilov Nikita Vladimirovich", "Plumber",
                "kosilov@gmail.com", "89275555555", 5000, 31);
        employees[4].employeeInfo();

    }

    public static void lesson6part2() {
        Park park = new Park("Парк Гагарина");
        park.attractions = new Park.Attraction[2];
        park.attractions[0] = new Park.Attraction("Американские горки", "9.00 - 18.00",
                500);
        park.attractions[1] = new Park.Attraction("Колесо обозрения", "9.00 - 15.00",
                400);
        park.parkInfo();

        Park park1 = new Park("Загородный парк");
        park1.attractions = new Park.Attraction[2];
        park1.attractions[0] = new Park.Attraction("Батуты", "9.00 - 11.00",
                100);
        park1.attractions[1] = new Park.Attraction("Паровозик", "7.00 - 20.00",
                700);
        park1.parkInfo();
    }


    public static void lesson2() {
        System.out.println("Задание 1");
        printThreeWords();
        System.out.println("Задание 2 " + checkSumSign());
        System.out.println("Задание 3 " + printColor());
        System.out.println("Задание 4 " + compareNumbers());
        System.out.println("Задание 5 " + checkSum(13, 5));
        System.out.println("Задание 6 " + checkNumber(500));
        System.out.println("Задание 7 " + isNumberNegative(100));
        System.out.println("Задание 8");
        printLine("привет", 3);
        System.out.println("Задание 9 " + checkLeapYear(2024));
        System.out.println("Задание 10");
        int[] a = {0, 1, 0, 1, 1};
        replace(a);
        System.out.println();
        System.out.println("Задание 11");
        int[] b = new int[100];
        completion(b);
        System.out.println();
        System.out.println("Задание 12");
        int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        replace1(c);
        System.out.println();
        System.out.println("Задание 13");
        int[][] d = {{0,0,0},{0,0,0},{0,0,0}};
        replace2(d);
        System.out.println("Задание 14");
        create(5,3);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static String checkSumSign() {
        int a = 5;
        int b = -10;
        int sum = a + b;
        if (sum >= 0) {
            return "Сумма положительная";
        } else {
            return "Сумма отрицательная";
        }
    }

    public static String printColor() {
        int value = 101;
        if (value <= 0) {
            return "Красный";
        } else {
            if (value > 0 && value <= 100) {
                return "Желтый";
            } else {
               return "Зеленый";
            }
        }
    }

    public static String compareNumbers() {
        int a = 150;
        int b = 126;
        if (a >= b) {
            return "a >= b";
        } else {
            return "a < b";
        }
    }

    public static boolean checkSum(int a, int b) {
        if ((a + b) > 10 && (a + b) < 20) {
            return true;
        } else {
            return false;
        }
    }

    public static String checkNumber(int a) {
        if (a<0) {
            return "отрицательное";
        } else {
            return "положительное";
        }
    }

    public static boolean isNumberNegative(int a) {
        if (a < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void printLine(String str, int a) {
        int b;
        for (b = 0; b < a; b++) {
            System.out.println(str);
        }
    }

    public static boolean checkLeapYear (int a) {
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void replace(int[] a) {
        for (int b = 0; b < a.length; b++) {
            if (a[b] == 0) {
                a[b] = 1;
            } else {
                if (a[b] == 1) {
                    a[b] = 0;
                }
            }
            System.out.print(a[b]);
        }
    }

    public static void completion(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i]);
        }
    }

    public static void replace1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] = a[i] * 2;
            }
            System.out.print(a[i]);
        }
    }

    public static void replace2(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < a[i].length; i1++){
                if (i == i1) {
                    a[i][i1] = 1;
                } else {
                    if (i + i1 == a.length - 1) {
                        a[i][i1] = 1;
                    }
                }
                System.out.print(a[i][i1]);

            }
            System.out.println();
        }
    }

    public static void create(int len, int initialValue) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = initialValue;
            System.out.print(a[i]);
        }
    }
}