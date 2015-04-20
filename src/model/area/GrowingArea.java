package model.area;

public abstract class GrowingArea extends Area {
	
	private int maxRadius;
	private int curRadius;
	
	public GrowingArea(int maxRadius) {
		this.maxRadius = maxRadius;
		this.curRadius = 0;
	}
	
	public int getMaxRadius() {
		return maxRadius;
	}
	
	public int getCurRadius() {
		return curRadius;
	}
	
	protected void incrementCurRadius() {
		curRadius++;
	}

	public boolean canGrow() {
		return getCurRadius() < getMaxRadius();
	}

	public void grow() {
		incrementCurRadius();
	}
}