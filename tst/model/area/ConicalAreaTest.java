package model.area;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import utilities.Direction;

public class ConicalAreaTest {

    private ConicalArea area = new ConicalArea(2, new TileCoordinate(10, 10), Direction.UP);

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
        area.setDirection(Direction.DOWN);
        TileCoordinate loc = new TileCoordinate(10, 11);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpRightTrue() {
        area.setDirection(Direction.UP_RIGHT);
        TileCoordinate loc = new TileCoordinate(11, 9);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpLeftTrue() {
        area.setDirection(Direction.UP_LEFT);
        TileCoordinate loc = new TileCoordinate(9, 9);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownLeftTrue() {
        area.setDirection(Direction.DOWN_LEFT);
        TileCoordinate loc = new TileCoordinate(9, 10);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpLongRange() {
        area.setDirection(Direction.UP);
        area.setRange(3);
        TileCoordinate loc = new TileCoordinate(10, 8);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownRightTrue() {
        area.setDirection(Direction.DOWN_RIGHT);
        TileCoordinate loc = new TileCoordinate(11, 10);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDown() {
        area.setDirection(Direction.DOWN);
        area.setRange(5);
        TileCoordinate loc = new TileCoordinate(10, 11);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testGetLocationsRadius2() {
        area.setDirection(Direction.UP);
        area.setRange(2);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(2, locations.size());
    }

    @Test
    public void testGetLocationsRadius3() {
        area.setDirection(Direction.UP);
        area.setRange(3);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(5, locations.size());
    }

    @Test
    public void testGetLocationsRadius4() {
        area.setDirection(Direction.UP);
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(8, locations.size());
    }

    @Test
    public void testGetLocationsRadius5() {
        area.setDirection(Direction.DOWN);
        area.setRange(5);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(13, locations.size());
    }

}
