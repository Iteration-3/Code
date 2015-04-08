package model.area;

public class Location {
    private double x;
    private double y;

    // defaults constructor to 0
    public Location() {
        this.x = 0;
        this.y = 0;
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public boolean equals(Location location) {
        if (location.getX() == this.x && location.getY() == this.y) {
            return true;
        } else {
            return false;
        }
    }
}
