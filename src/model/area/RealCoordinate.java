package model.area;

import utilities.Angle;

public class RealCoordinate {
    private double x;
    private double y;

    // defaults constructor to 0
    public RealCoordinate() {
        this.x = 0;
        this.y = 0;
    }

    public RealCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public RealCoordinate nextLocation(Angle angle) {
        int xDisplacement = 0, yDisplacement = 0;
        if (angle == Angle.UP_RIGHT || angle == Angle.UP || angle == Angle.UP_LEFT) {
            yDisplacement = -1;
        } else {
            yDisplacement = 1;
        }
        if (angle == Angle.UP_RIGHT || angle == Angle.DOWN_RIGHT) {
            xDisplacement = 1;
        } else if (angle == Angle.UP_LEFT || angle == Angle.UP_RIGHT) {
            xDisplacement = -1;
        }

        return new RealCoordinate(this.getX() + xDisplacement, this.getY() + yDisplacement);
    }

    public static TileCoordinate convertToTileCoordinate(RealCoordinate coord) {
        double q = coord.getX() * (2.0 / 3.0) / (1.0 / 2.0);
        double r = (-coord.getX() / 3.0 + Math.sqrt(3.0) / 3.0 * coord.getY()) / (1.0 / 2.0);

        Hex hex = convertCubeToOddQ(cubeRound(new Cube(q, (-q - r), r)));

        return new TileCoordinate((int) hex.getX(), (int) hex.getY());
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RealCoordinate other = (RealCoordinate) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        return true;
    }

    private static Hex convertCubeToOddQ(Cube cube) {
        double q = cube.getX();
        double r = cube.getZ() + (cube.getX() - ((int) cube.getX() & 1)) / 2;
        return new Hex(q, r);
    }

    private static Cube cubeRound(Cube hexToCube) {
        double rx = Math.round(hexToCube.getX());
        double ry = Math.round(hexToCube.getY());
        double rz = Math.round(hexToCube.getZ());

        double xDif = Math.abs(rx - hexToCube.getX());
        double yDif = Math.abs(ry - hexToCube.getY());
        double zDif = Math.abs(rz - hexToCube.getZ());

        if (xDif > yDif && xDif > zDif) {
            rx = (-ry - rz);
        } else if (yDif > zDif) {
            ry = (-rx - rz);
        } else {
            rz = (-rx - ry);
        }

        return new Cube(rx, ry, rz);
    }

    private static class Cube {
        private double x;
        private double y;
        private double z;

        public Cube(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }
    }

    private static class Hex {
        private double x;
        private double y;

        public Hex(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

}
