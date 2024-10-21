package org.example.lesson10;

public class Dog extends Animal {
    String dogName;
    static int dogAmount;

    public Dog(String dogName) {
        super();
        dogAmount++;
        this.dogName = dogName;
    }

    public void run(int runDistance) {
        if (runDistance <= 500) {
            System.out.println(dogName + " пробежал " + runDistance + "м.");
        } else {
            System.out.println(dogName + " не может пробежать больше 500 м.");
        }
    }

    public void swim(int swimDistance) {
        if (swimDistance <= 10) {
            System.out.println(dogName + " проплыл " + swimDistance + "м.");
        } else {
            System.out.println(dogName + " не может проплыть больше 10 м.");
        }
    }

    public static void dogAmount() {
        System.out.println("Количество собак: " + dogAmount);
    }
}
