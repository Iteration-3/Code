package model.area;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    
    

    

}
