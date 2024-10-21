package org.example.lesson10;

public class Bowl {
    int eatCount;

    public Bowl(int eatCount) {
        this.eatCount = eatCount;
    }

    public void addEat(int eatCount) {
        this.eatCount = this.eatCount + eatCount;
        System.out.println("В миске " + this.eatCount + " еды");
    }
}
