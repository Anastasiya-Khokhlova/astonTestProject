package org.example;

public class Triangle implements Figure {
    double sideAB;
    double sideBC;
    double sideCD;
    String fillColor;
    String borderColor;

    public Triangle(double sideAB, double sideBC, double sideCD, String fillColor, String borderColor) {
        this.sideAB = sideAB;
        this.sideBC = sideBC;
        this.sideCD = sideCD;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculatePerimeter() {
        return sideAB + sideBC + sideCD;
    }

    public double calculateArea(){
        double p = (sideAB + sideBC + sideCD) / 2;
        return Math.sqrt(p * (p - sideAB) * (p - sideBC) * (p-sideCD));
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void figureInfo() {
        System.out.println("Периметр треугольника: " + calculatePerimeter());
        System.out.println("Площадь треугольника: " + calculateArea());
        System.out.println("Цвет заливки треугольника: " + getFillColor());
        System.out.println("Цвет границы треугольника: " + getBorderColor());
    }


}


