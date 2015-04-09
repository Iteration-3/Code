package model.area;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utilities.AreaAngle;
import utilities.LocationConversion;

public class LinearAreaTest {
    private LinearArea area = new LinearArea(2, new Location(952, 825), AreaAngle.UP);

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
        Location loc = new Location(1125, 675);
        assertTrue(area.isInRange(loc));
    }
    
    @Test
    public void testInsideAreaUpLeftTrue() {
        area.setDirection(AreaAngle.UP_LEFT);
        Location loc = new Location(779, 675);
        assertTrue(area.isInRange(loc));
    }
    
    @Test
    public void testInsideAreaDownLeftTrue() {
        area.setDirection(AreaAngle.DOWN_LEFT);
        Location loc = new Location(779, 975);
        assertTrue(area.isInRange(loc));
    }
    
    @Test
    public void testInsideAreaDownRightTrue() {
        area.setDirection(AreaAngle.DOWN_RIGHT);
        Location loc = new Location(1125, 975);
        assertTrue(area.isInRange(loc));
    }
    
    @Test
    public void testUpRightWithDifferentRegularDimension() {
        area.setDirection(AreaAngle.UP_RIGHT);
        LocationConversion.changeHexagonDimensionsByWidth(150);
        
        area.setStartLocation(new Location(825,715));
        
        Location loc = new Location(975,585);
        assertTrue(area.isInRange(loc));
    }
    
    @Test
    public void testUpRightWithAnotherDifferentRegularDimension() {
        area.setDirection(AreaAngle.UP_RIGHT);
        LocationConversion.changeHexagonDimensionsByWidth(50);
        
        area.setStartLocation(new Location(275,237));
        
        Location loc = new Location(325,194);
        assertTrue(area.isInRange(loc));
    }
    
    @Test
    public void testUpRightGetLocationsRadius1() {
        area.setDirection(AreaAngle.UP_RIGHT);
        area.setRange(1);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(1, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }
    
    @Test
    public void testUpRightGetLocationsRadius2() {
        System.out.println();
        area.setDirection(AreaAngle.UP_RIGHT);
        area.setRange(2);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(2, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }
    
    @Test
    public void testUpRightGetLocationsRadius3() {
        System.out.println();
        area.setDirection(AreaAngle.UP_RIGHT);
        area.setRange(3);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(3, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
    }
    
    @Test
    public void testUpRightGetLocationsRadius4() {
        System.out.println();
        area.setDirection(AreaAngle.UP_RIGHT);
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
        
        assertEquals(375.0, locations.get(3).getY(), .01);
        assertEquals(1471.0, locations.get(3).getX(), .01);
    }
    
    @Test
    public void testUpLeftGetLocationsRadius4() {
        System.out.println();
        area.setDirection(AreaAngle.UP_LEFT);
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
        
        assertEquals(375.0, locations.get(3).getY(), .01);
        assertEquals(433.0, locations.get(3).getX(), .01);
    }
    
    @Test
    public void testUpGetLocationsRadius4() {
        area.setDirection(AreaAngle.UP);
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
        
        assertEquals(375.0, locations.get(3).getY(), .01);
        assertEquals(952.0, locations.get(3).getX(), .01);
    }
    
    @Test
    public void testDownGetLocationsRadius4() {
        area.setDirection(AreaAngle.DOWN);
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
        
        assertEquals(1275.0, locations.get(3).getY(), .01);
        assertEquals(952.0, locations.get(3).getX(), .01);
    }
    
    @Test
    public void testDownLeftGetLocationsRadius4() {
        area.setDirection(AreaAngle.DOWN_LEFT);
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
        
        assertEquals(1275.0, locations.get(3).getY(), .01);
        assertEquals(433.0, locations.get(3).getX(), .01);
    }
    
    @Test
    public void testDownRightGetLocationsRadius4() {
        area.setDirection(AreaAngle.DOWN_RIGHT);
        area.setRange(4);
        List<Location> locations = area.getCoveredLocations();
        assertEquals(4, locations.size());
        for(Location loc: locations) {
            System.out.println(loc.getX() + " " + loc.getY());
        }
        
        assertEquals(1275.0, locations.get(3).getY(), .01);
        assertEquals(1471.0, locations.get(3).getX(), .01);
    }

}
