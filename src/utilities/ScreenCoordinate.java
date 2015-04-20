package utilities;

public class ScreenCoordinate {
	private float x;
	private float y;
	
	public ScreenCoordinate() {
		this.x = 0;
		this.y = 0;
	}
	
	public ScreenCoordinate(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
}
