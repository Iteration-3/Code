package utilities;

public enum Angle {
    UP_RIGHT(0),
    UP(60),
    UP_LEFT(120),
    DOWN_LEFT(-180),
    DOWN(-120),
    DOWN_RIGHT(-60);

    private Angle(int theta) {
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

    public Angle getLeft() {
        Angle[] values = Angle.values();
        return values[(ordinal() - 1 + values.length) % values.length];
    }

    public Angle getRight() {
        Angle[] values = Angle.values();
        return Angle.values()[(ordinal() + 1) % values.length];
    }
}
