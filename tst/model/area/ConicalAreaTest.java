package model.area;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utilities.AreaAngle;
import utilities.LocationConversion;

public class ConicalAreaTest {

    private ConicalArea area = new ConicalArea(2, new Location(952, 825), AreaAngle.UP);

    @Before
    public void setUp() {
        LocationConversion.changeHexagonDimensionsByWidth(173);
    }

    @Test
    public void testInsideAreaUpTrue() {
        Location loc = new Location(952, 675);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpFalse() {
        Location loc = new Location(952, 525);
        assertFalse(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownTrue() {
        area.setDirection(AreaAngle.DOWN);
        Location loc = new Location(952, 975);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpRightTrue() {
        area.setDirection(AreaAngle.UP_RIGHT);
        Location loc = new Location(1081, 750);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpLeftTrue() {
        area.setDirection(AreaAngle.UP_LEFT);
        Location loc = new Location(822, 750);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownLeftTrue() {
        area.setDirection(AreaAngle.DOWN_LEFT);
        Location loc = new Location(822, 900);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownRightTrue() {
        area.setDirection(AreaAngle.DOWN_RIGHT);
        Location loc = new Location(1081, 900);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDown() {
        area.setDirection(AreaAngle.DOWN);
        area.setRange(5);
        Location loc = new Location(952, 1425);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownNewDimension() {
        LocationConversion.changeHexagonDimensionsByWidth(150);
        area.setStartLocation(new Location(750, 650));
        area.setDirection(AreaAngle.DOWN);
        area.setRange(5);
        Location loc = new Location(750, 1170);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testGetLocationsRadius2() {
        area.setDirection(AreaAngle.UP);
        area.setRange(2);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(2, locations.size());
    }

    @Test
    public void testGetLocationsRadius3() {
        area.setDirection(AreaAngle.UP);
        area.setRange(3);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(5, locations.size());
    }

    @Test
    public void testGetLocationsRadius4() {
        area.setDirection(AreaAngle.UP);
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(8, locations.size());
    }

    @Test
    public void testGetLocationsRadius5() {
        area.setDirection(AreaAngle.DOWN);
        area.setRange(5);
        List<Location> locations = area.getCoveredLocations();
        for (Location loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
        assertEquals(13, locations.size());
    }

}
