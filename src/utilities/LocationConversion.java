package utilities;

import model.area.RealCoordinate;

public class LocationConversion {
    private static double hexagonWidth;
    private static double hexagonHeight;
    private static double radius;

    public static void changeHexagonDimensionsByWidth(double width) {
        hexagonWidth = (width);
        hexagonHeight =            width * Math.sqrt(3) / 2.0;
        setRadius();
    }

    public static void changeHexagonDimensionsByHeight(double height) {
        hexagonHeight = Math.round(height);
        hexagonWidth = Math.round(height * (2.0 / Math.sqrt(3)));
        setRadius();
    }

    public static double getHeight() {
        return hexagonHeight;
    }

    public static double getWidth() {
        return hexagonWidth;
    }

    /**
     * Put in a buffer because of rounding issues. Should work if everything is
     * converted to the center first.
     */
    private static void setRadius() {
        radius = Math.ceil(Math.sqrt(Math.pow((hexagonWidth + 2) * .75, 2) + Math.pow((hexagonHeight + 2) * .5, 2)));
    }

    public static double getRadius() {
        return radius;
    }

    public static void setHeight(double height) {
        hexagonHeight = height;
        setRadius();
    }

    public static void setWidth(double width) {
        hexagonWidth = width;
        setRadius();
    }

    /**
     * Converts any location to the center of its hexagon. The width or height
     * needs to be set at least once before this can be used correctly. The
     * width or height should correspond to the dimmensions of our hexagons
     * (pixel width?) This is broken and needs to fixed.
     * 
     * @param location
     * @return
     */
    public static RealCoordinate convertLocationToCenterOfHexagon(RealCoordinate location) {
        double q = location.getX() * (2.0/3.0) / (hexagonWidth / 2.0);
        double r = (-location.getX() / 3.0 + Math.sqrt(3.0)/ 3.0 * location.getY()) / (hexagonWidth / 2.0);

        Hex hex = convertCubeToOddQ(cubeRound(new Cube(q, (-q - r), r)));
        
        System.out.println("Hex " + hex.getX() + " " + hex.getY());

        return new RealCoordinate(hex.getX(), hex.getY());
    }

    private static Hex cubeToHex(Cube cubeRound) {
        double x = cubeRound.getX();
        double y = cubeRound.getZ();

        return new Hex(x, y);

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
    
    private static Hex convertCubeToOddQ(Cube cube) {
        double q = cube.getX();
        double r = cube.getZ() + (cube.getX() - ((int)cube.getX() & 1)) / 2;
        return new Hex(q,r);
    }
    
    private static Cube cubeRound(Cube hexToCube) {
        
        System.out.println("Cube: " + hexToCube.getX() + " "  + hexToCube.getY() + " " + hexToCube.getZ());
        
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

    private static Cube hexToCube(double q, double r) {
        double x = q;
        double z = r;
        double y = -x - z;

        return new Cube(x, y, z);
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

}
