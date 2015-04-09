package utilities;

import model.area.Location;

public class LocationConversion {
    private static double hexagonWidth;
    private static double hexagonHeight;

    public static void changeHexagonDimensionsByWidth(double width) {
        hexagonWidth = Math.round(width);
        hexagonHeight = Math.round(width * Math.sqrt(3) / 2.0);
    }

    public static void changeHexagonDimensionsByHeight(double height) {
        hexagonHeight = height;
        hexagonWidth = hexagonHeight * (2.0 / Math.sqrt(3));
    }

    /**
     * Converts any location to the center of its hexagon. The width or height needs to be
     * set at least once before this can be used correctly. The width or height should correspond to
     * the dimmensions of our hexagons (pixel width?)
     * @param location
     * @return
     */
    public static Location convertLocationToCenterOfHexagon(Location location) {
        int x = (int) (location.getX() / hexagonWidth);
        int y = (int) (location.getY() / hexagonHeight);

        return new Location(Math.round((x * hexagonWidth + (hexagonWidth / 2.0))), Math.round(y * (hexagonHeight) + (hexagonHeight / 2.0)));
    }

}
