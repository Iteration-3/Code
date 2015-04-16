package utilities;

public class Point {
	
	private int x;
	private int y;
	
	public Point(){
		this(0, 0);
	}
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void set(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public boolean equals(Point point){
		if (point.getX() == this.x && point.getY() == this.y){
			return true;
		}
		else{
			return false;
		}
	}

}
