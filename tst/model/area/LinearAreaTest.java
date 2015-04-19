package model.area;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import utilities.Angle;

public class LinearAreaTest {
    private LinearArea area = new LinearArea(2, new TileCoordinate(10, 10), Angle.UP);

    @Test
    public void testInsideAreaUpTrue() {
    	TileCoordinate loc = new TileCoordinate(10, 9);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpFalse() {
    	TileCoordinate loc = new TileCoordinate(10, 11);
        assertFalse(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownTrue() {
        area.setDirection(Angle.DOWN);
        TileCoordinate loc = new TileCoordinate(10, 11);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpRightTrue() {
        area.setDirection(Angle.UP_RIGHT);
        TileCoordinate loc = new TileCoordinate(11, 9);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpLeftTrue() {
        area.setDirection(Angle.UP_LEFT);
        TileCoordinate loc = new TileCoordinate(9, 9);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownLeftTrue() {
        area.setDirection(Angle.DOWN_LEFT);
        TileCoordinate loc = new TileCoordinate(9, 10);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownRightTrue() {
        area.setDirection(Angle.DOWN_RIGHT);
        TileCoordinate loc = new TileCoordinate(11, 10);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testUpRightGetLocationsRadius1() {
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(1);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(1, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpRightGetLocationsRadius2() {
        System.out.println();
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(2);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(2, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpRightGetLocationsRadius3() {
        System.out.println();
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(3);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(3, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpRightGetLocationsRadius4() {
        System.out.println();
        area.setDirection(Angle.UP_RIGHT);
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpLeftGetLocationsRadius4() {
        System.out.println();
        area.setDirection(Angle.UP_LEFT);
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }

    @Test
    public void testUpGetLocationsRadius4() {
        area.setDirection(Angle.UP);
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

    }

    @Test
    public void testDownGetLocationsRadius4() {
        area.setDirection(Angle.DOWN);
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

    }

    @Test
    public void testDownLeftGetLocationsRadius4() {
        area.setDirection(Angle.DOWN_LEFT);
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (TileCoordinate loc : locations) {
            TileCoordinate loc2 = loc;
            System.out.println(loc2.getX() + " " + loc2.getY());
        }

    }

    @Test
    public void testDownRightGetLocationsRadius4() {
        area.setDirection(Angle.DOWN_RIGHT);
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for (TileCoordinate loc : locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }

    }
}
