package model.area;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utilities.Angle;
import utilities.LocationConversion;

public class LinearAreaTest {
    private LinearArea area = new LinearArea(2, new RealCoordinate(952, 825), Angle.UP);

    @Before
    public void setUp() {
        LocationConversion.changeHexagonDimensionsByWidth(173);
    }

    @Test
    public void testInsideAreaUpTrue() {
        RealCoordinate loc = new RealCoordinate(952, 675);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpFalse() {
        RealCoordinate loc = new RealCoordinate(952, 525);
        assertFalse(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownTrue() {
        area.setDirection(Angle.DOWN);
        RealCoordinate loc = new RealCoordinate(952, 975);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpRightTrue() {
        area.setDirection(Angle.UP_RIGHT);
        RealCoordinate loc = new RealCoordinate(1082, 750);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpLeftTrue() {
        area.setDirection(Angle.UP_LEFT);
        RealCoordinate loc = new RealCoordinate(822, 750);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownLeftTrue() {
        area.setDirection(Angle.DOWN_LEFT);
        RealCoordinate loc = new RealCoordinate(822, 900);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownRightTrue() {
        area.setDirection(Angle.DOWN_RIGHT);
        RealCoordinate loc = new RealCoordinate(1082, 900);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testUpRightWithDifferentRegularDimension() {
        area.setDirection(Angle.UP_RIGHT);
        LocationConversion.changeHexagonDimensionsByWidth(150);

        area.setStartLocation(new RealCoordinate(188, 195));

        RealCoordinate loc = new RealCoordinate(301, 130);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testUpRightGetLocationsRadius1() {
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(1);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(1, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpRightGetLocationsRadius2() {
        System.out.println();
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(2);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(2, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpRightGetLocationsRadius3() {
        System.out.println();
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(3);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(3, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpRightGetLocationsRadius4() {
        System.out.println();
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

        assertEquals(600.0, locations.get(3).getY(), .01);
        assertEquals(1341.25, locations.get(3).getX(), .01);
    }

    @Test
    public void testUpLeftGetLocationsRadius4() {
        System.out.println();
        area.setDirection(Angle.UP_LEFT);
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

        assertEquals(600.0, locations.get(3).getY(), .01);
        assertEquals(562.75, locations.get(3).getX(), .01);
    }

    @Test
    public void testUpGetLocationsRadius4() {
        area.setDirection(Angle.UP);
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

        assertEquals(600.0, locations.get(3).getY(), .01);
        assertEquals(952.0, locations.get(3).getX(), .01);
    }

    @Test
    public void testDownGetLocationsRadius4() {
        area.setDirection(Angle.DOWN);
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

        assertEquals(1050.0, locations.get(3).getY(), .01);
        assertEquals(952.0, locations.get(3).getX(), .01);
    }

    @Test
    public void testDownLeftGetLocationsRadius4() {
        area.setDirection(Angle.DOWN_LEFT);
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

        assertEquals(1050.0, locations.get(3).getY(), .01);
        assertEquals(562.75, locations.get(3).getX(), .01);
    }

    @Test
    public void testDownRightGetLocationsRadius4() {
        area.setDirection(Angle.DOWN_RIGHT);
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (RealCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

        assertEquals(1050.0, locations.get(3).getY(), .01);
        assertEquals(1341.25, locations.get(3).getX(), .01);
    }
}
