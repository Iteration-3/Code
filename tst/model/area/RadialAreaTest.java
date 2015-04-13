package model.area;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RadialAreaTest {

    private RadialArea area = new RadialArea(2, TileCoordinate.convertToRealCoordinate(new TileCoordinate(4, 3)));

    @Test
    public void testIsNotInRange() {
        RealCoordinate location = TileCoordinate.convertToRealCoordinate(new TileCoordinate(0, 3));
        area.setRange(4);
        assertFalse(area.isInRange(location));
    }

    @Test
    public void testIsInRange() {
        RealCoordinate location = TileCoordinate.convertToRealCoordinate(new TileCoordinate(3, 2));
        assertTrue(area.isInRange(location));
    }

    @Test
    public void testTilesContainedRadius2() {
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(7, locations.size());
    }

    @Test
    public void testTilesContainedRadius3() {
        area.setRange(3);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(19, locations.size());
    }

    @Test
    public void testTilesContainedRadius4() {
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        for (RealCoordinate loc : locations) {
            TileCoordinate loc2 = RealCoordinate.convertToTileCoordinate(loc);
            System.out.println(loc2.getX() + " " + loc2.getY());
        }
        assertEquals(37, locations.size());
    }

    @Test
    public void testTilesContainedRadius5() {
        area.setRange(5);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(61, locations.size());
    }

}
