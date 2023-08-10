package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10,20);
//		point1.setX(10);
//		point1.setY(20);
		
//		drawPoint(point1);
		draw(point1);
//		point1.disappear();
		point1.show(false);
		
		
		Point point2= new ColorPoint();
//		ColorPoint p = new ColorPoint();
//		Point point2 = p;
		
		point2.setX(20);
		point2.setY(20);
		
//		ColorPoint p = (ColorPoint)point2;
//		p.setColor("red");
		((ColorPoint)point2).setColor("red");
//		drawPoint(point2);
		draw(point2);
		
		Rect rect = new Rect();
		//drawRect(rect);
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
		//drawTriangle(triangle);
//		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("Hello World"));
		
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show(true);
//	}
//	public static void drawColorPoint(ColorPoint colorpoint) {
//		colorpoint.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
}
