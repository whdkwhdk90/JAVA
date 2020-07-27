package silsub3.model.vo;

public class Circle {

	public final double PI = 3.14;
	private int radius;
	
	
	public Circle() {}
	
	public Circle(int radius) {
		this.radius = radius;
		
		
	}
	
	
	public double Sum() {
		return radius*radius*PI;
	}
	
	public double Length() {
		return 2*radius*PI;
	}
	
		
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
		
	}
	
	
	public void incrementRadius() {
		radius += 1;
	}
	
	
	
}
