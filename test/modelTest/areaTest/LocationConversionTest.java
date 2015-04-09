package modelTest.areaTest;

import static org.junit.Assert.*;
import model.area.Location;

import org.junit.Before;
import org.junit.Test;

import utilities.LocationConversion;

public class LocationConversionTest {

    @Before
    public void setUp() throws Exception {
        LocationConversion.changeHexagonDimensionsByWidth(173);
    }

    @Test
    public void testCenterToCenter() {
        Location testLocation = new Location(952,825);
        assertEquals(952.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(825.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    @Test
    public void testLeftBoundsToCenter() {
        Location testLocation = new Location(865,825);
        assertEquals(952.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(825.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    @Test
    public void testRightBoundsToCenter() {
        Location testLocation = new Location(1037,825);
        assertEquals(952.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(825.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    @Test
    public void testUpperBoundsToCenter() {
        Location testLocation = new Location(952,750);
        assertEquals(952.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(825.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }

    @Test
    public void testLowerBoundsToCenter() {
        Location testLocation = new Location(952,899);
        assertEquals(952.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(825.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    @Test
    public void testRandomPointToCenter() {
        Location testLocation = new Location(1000,775);
        assertEquals(952.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(825.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    @Test
    public void testRandomPointOuside() {
        Location testLocation = new Location(1038,900);
        assertNotEquals(952.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertNotEquals(825.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
}
