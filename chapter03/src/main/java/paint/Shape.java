package paint;

public abstract class Shape implements Drawable {
	private String lineColor;
	private String fillcolor;
	
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public String getFillcolor() {
		return fillcolor;
	}
	public void setFillcolor(String fillcolor) {
		this.fillcolor = fillcolor;
	}
	
}
