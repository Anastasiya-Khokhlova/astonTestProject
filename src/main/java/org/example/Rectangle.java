package org.example;

class Rectangle implements Figure {
    double width;
    double length;
    String fillColor;
    String borderColor;

    public Rectangle(double width, double length, String fillColor, String borderColor) {
        this.width = width;
        this.length = length;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculateArea(){
        return width * length;
    }

    public double calculatePerimeter() {
        return 2 * (width + length);
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void figureInfo() {
        System.out.println("Периметр прямоугольника: " + calculatePerimeter());
        System.out.println("Площадь прямоугольника: " + calculateArea());
        System.out.println("Цвет заливки прямоугольника: " + getFillColor());
        System.out.println("Цвет границы прямоугольника: " + getBorderColor());
    }
}

