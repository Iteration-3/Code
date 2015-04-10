package utilities;

public enum Angle {

	UP_RIGHT(45),
	UP(90),
	UP_LEFT(135),
	DOWN_LEFT(235),
	DOWN(270),
	DOWN_RIGHT(315);

	private Angle(int theta) {
		this.theta = theta;
	}

	private int theta;

	public int getAngle() {
		return this.theta;
	}

	public double sin() {
		return Math.sin(theta);
	}

	public double cos() {
		return Math.cos(theta);
	}

	public Angle getLeft() {
		Angle[] values = Angle.values(); // Note this is an expensive operation,
											// we might want to cache this if it
											// slows the game enough.
		if (this.ordinal() > 0) {
			return values[this.ordinal() - 1];
		} else {
			return values[values.length - 1];
		}
	}
	
	public Angle getRight() {
		Angle[] values = Angle.values();
		return values[(this.ordinal() + 1) % values.length];
	}
}
