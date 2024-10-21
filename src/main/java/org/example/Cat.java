package org.example;

public class Cat extends Animal {
    String catName;
    boolean satiety;
    static int catAmount;
    int eatAmount;

    public Cat(String catName, int eatAmount) {
        super();
        catAmount++;
        this.catName = catName;
        this.satiety = false;
        this.eatAmount = eatAmount;
    }

    public void run(int runDistance) {
        if (runDistance <= 200) {
            System.out.println(catName + " пробежал " + runDistance + "м");
        } else {
            System.out.println(catName + " не может пробежать больше 200 м.");
        }
    }

    public void swim(int swimDistance) {
        System.out.println(catName + " не умеет плавать");
    }

    public static void catAmount() {
        System.out.println("Количество котов: " + catAmount);
    }

    public void eat(Bowl bowl) {
        if (eatAmount > bowl.eatCount) {
            System.out.println("Кот " + this.catName + " остался голодным, потому что в миске недостаточно еды");
        } else {
            bowl.eatCount = bowl.eatCount - this.eatAmount;
            satiety = true;
            System.out.println("Кот " + this.catName + " поел: " + eatAmount + " еды");
            System.out.println("В миске осталось: " + bowl.eatCount + " еды");
        }
    }
}
