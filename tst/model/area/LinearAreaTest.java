package model.area;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilities.AreaAngle;
import utilities.LocationConversion;

public class LinearAreaTest {
    private LinearArea area = new LinearArea(1, new Location(952, 825), AreaAngle.UP);

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

}
