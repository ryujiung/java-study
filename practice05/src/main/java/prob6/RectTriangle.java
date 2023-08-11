package prob6;

public class RectTriangle extends Shape {
    private double width;
    private double height;

    public RectTriangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * width * height;
    }

    @Override
    public double getPerimeter() {
        double  a = Math.sqrt(width * width + height * height);
        return width + height + a;
    }
}
