package model.area;

import static org.junit.Assert.*;
import model.area.RealCoordinate;

import org.junit.Before;
import org.junit.Test;

import utilities.LocationConversion;

public class LocationConversionTest {

    @Before
    public void setUp() throws Exception {
        LocationConversion.changeHexagonDimensionsByWidth(50);
    }
    /*
    @Test
    public void testCenterToCenter() {
        Location testLocation = new Location(25,25);
        assertEquals(0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    */
    @Test
    public void testCenterToCenter2() {
        RealCoordinate testLocation = new RealCoordinate(1.5, Math.sqrt(3)/2.0);
        LocationConversion.changeHexagonDimensionsByWidth(1);
        
        assertEquals(2, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(1, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    @Test
    public void testCenterToCenter3() {
        RealCoordinate testLocation = new RealCoordinate(2.25, Math.sqrt(3)/4.0);
        LocationConversion.changeHexagonDimensionsByWidth(1);
        
        assertEquals(3, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    /*
    @Test
    public void testCenterToCenter3() {
        Location testLocation = new Location(25, 125);
        assertEquals(0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(2, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    /*
    
    @Test
    public void testCenterToCenter2() {
        Location testLocation = new Location(346,75);
        assertEquals(346.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(75.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    @Test
    public void testCenterToCenter3() {
        Location testLocation = new Location(865,75);
        assertEquals(865.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getX(), .001);
        assertEquals(75.0, LocationConversion.convertLocationToCenterOfHexagon(testLocation).getY(), .001);
    }
    
    */
    /*
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
    */
}
