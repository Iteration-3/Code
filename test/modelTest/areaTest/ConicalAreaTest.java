package modelTest.areaTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.area.ConicalArea;
import model.area.LinearArea;
import model.area.Location;

import org.junit.Before;
import org.junit.Test;

import utilities.AreaAngle;
import utilities.LocationConversion;

public class ConicalAreaTest {

    private ConicalArea area = new ConicalArea(173, new Location(952, 825), AreaAngle.UP);
    private LinearArea area2 = new LinearArea(173, new Location(952, 825), AreaAngle.UP);

    @Before
    public void setUp() {
        LocationConversion.changeHexagonDimensionsByWidth(173);
        Location centerLoc = LocationConversion.convertLocationToCenterOfHexagon(area.getStartLocation());
        Location centerLoc2 = LocationConversion.convertLocationToCenterOfHexagon(area2.getStartLocation());
        System.out.println(centerLoc.getX() + " " + centerLoc.getY());
        System.out.println(centerLoc2.getX() + " " + centerLoc2.getY());
    }

    @Test
    public void testInsideAreaTrue() {
        Location loc = new Location(9,9);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaFalse() {
        Location loc = new Location(2, 2);
        assertFalse(area.isInRange(loc));
    }
    
    @Test
    public void testInsideAreaLinearFalse() {
        Location loc = new Location(2, 2);
        assertFalse(area2.isInRange(loc));
    }
    

}
