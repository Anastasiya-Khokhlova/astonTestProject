package org.example;

abstract public class Animal {
    static int amount;

    public Animal() {
        amount++;
    }


    public static void animalAmount() {
        System.out.println("Количество животных: " + amount);
    }

    abstract public void run(int runDistance);

    abstract public void swim(int swimDistance);

}
