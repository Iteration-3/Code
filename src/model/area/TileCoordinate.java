package model.area;

public class TileCoordinate {
    private int x;
    private int y;

    public TileCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static RealCoordinate convertToRealCoordinate(TileCoordinate coord) {
        double x = (0.75 * coord.getX());
        double y = (double) ((Math.sqrt(3) / 2 * (double) coord.getY()) + (((double) coord.getX() % 2) * Math.sqrt(3.0) / 4.0));
        return new RealCoordinate(x, y);
    }

}
