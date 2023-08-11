package prob6;

public class Rectangle extends Shape implements Resizable {
    private double width;
    private double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void resize(double s) {
        width *= s;
        height *= s;
    }
}
