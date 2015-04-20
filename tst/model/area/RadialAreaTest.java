package model.area;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class RadialAreaTest {

    private RadialArea area = new RadialArea(2, new TileCoordinate(4, 3));

    @Test
    public void testIsNotInRange() {
    	TileCoordinate location = new TileCoordinate(0, 3);
        area.setRange(4);
        assertFalse(area.isInRange(location));
    }

    @Test
    public void testIsInRange() {
    	TileCoordinate location = new TileCoordinate(3, 2);
        assertTrue(area.isInRange(location));
    }

    @Test
    public void testTilesContainedRadius2() {
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(7, locations.size());
    }

    @Test
    public void testTilesContainedRadius3() {
        area.setRange(3);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(19, locations.size());
    }

    @Test
    public void testTilesContainedRadius4() {
        area.setRange(4);
        List<TileCoordinate> locations = area.getCoveredLocations();
        for (TileCoordinate loc : locations) {
            TileCoordinate loc2 = loc;
            System.out.println(loc2.getX() + " " + loc2.getY());
        }
        assertEquals(37, locations.size());
    }

    @Test
    public void testTilesContainedRadius5() {
        area.setRange(5);
        List<TileCoordinate> locations = area.getCoveredLocations();
        assertEquals(61, locations.size());
    }

}
