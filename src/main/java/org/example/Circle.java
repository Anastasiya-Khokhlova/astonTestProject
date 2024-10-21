package org.example;

class Circle implements Figure {
    double radius;
    String fillColor;
    String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void figureInfo() {
        System.out.println("Периметр круга: " + calculatePerimeter());
        System.out.println("Площадь круга: " + calculateArea());
        System.out.println("Цвет заливки круга: " + getFillColor());
        System.out.println("Цвет границы круга: " + getBorderColor());
    }

}
