package model.area;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utilities.LocationConversion;

public class RadialAreaTest {

    private RadialArea area = new RadialArea(2, new Location(952, 825));

    @Before
    public void setUp() {
        LocationConversion.changeHexagonDimensionsByWidth(173);
    }

    @Test
    public void testTilesContainedRadius2() {
        List<Location> locations = area.getCoveredLocations();
        assertEquals(7, locations.size());
    }

    @Test
    public void testTilesContainedRadius3() {
        area.setRange(3);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(19, locations.size());
    }

    @Test
    public void testTilesContainedRadius4() {
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(37, locations.size());
    }

    @Test
    public void testTilesContainedRadius5() {
        area.setRange(5);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(61, locations.size());
    }

}
