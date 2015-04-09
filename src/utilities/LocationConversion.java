package utilities;

import model.area.Location;

public class LocationConversion {
    private static double hexagonWidth;
    private static double hexagonHeight;
    private static double radius;

    public static void changeHexagonDimensionsByWidth(double width) {
        hexagonWidth = Math.round(width);
        hexagonHeight = Math.round(width * Math.sqrt(3) / 2.0);
        setRadius();
    }

    public static void changeHexagonDimensionsByHeight(double height) {
        hexagonHeight = Math.round(height);
        hexagonWidth = Math.round(height * (2.0 / Math.sqrt(3)));
        setRadius();
    }
    
    public static void setRadius() {
        radius = Math.ceil(Math.sqrt(Math.pow(hexagonWidth,2) + Math.pow(hexagonHeight,2)));
    }
    
    public static double getRadius() {
        return radius;
    }

    /**
     * Converts any location to the center of its hexagon. The width or height
     * needs to be set at least once before this can be used correctly. The
     * width or height should correspond to the dimmensions of our hexagons
     * (pixel width?)
     * 
     * @param location
     * @return
     */
    public static Location convertLocationToCenterOfHexagon(Location location) {
        int x = (int) (location.getX() / hexagonWidth);
        int y = (int) (location.getY() / hexagonHeight);

        return new Location(Math.round((x * hexagonWidth + (hexagonWidth / 2.0))), Math.round(y * (hexagonHeight)
                + (hexagonHeight / 2.0)));
    }

}
