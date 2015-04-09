package utilities;

public enum AreaAngle {
    UP_RIGHT(0),
    UP(60),
    UP_LEFT(120),
    DOWN_LEFT(-180),
    DOWN(-120),
    DOWN_RIGHT(-60);

    private AreaAngle(int theta) {
        this.theta = theta;
    }

    private int theta;

    public int getAngle() {
        return this.theta;
    }

    public double sin() {
        return Math.sin(Math.toRadians(theta));
    }

    public double cos() {
        return Math.cos(Math.toRadians(theta));
    }
}
