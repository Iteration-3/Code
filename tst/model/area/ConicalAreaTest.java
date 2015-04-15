package model.area;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utilities.Angle;
import utilities.LocationConversion;

public class ConicalAreaTest {

    private ConicalArea area = new ConicalArea(2, new RealCoordinate(952, 825), Angle.UP);

    @Before
    public void setUp() {
        LocationConversion.changeHexagonDimensionsByWidth(173);
    }

    @Test
    public void testInsideAreaUpTrue() {
        RealCoordinate loc = new RealCoordinate(952, 675);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpFalse() {
        RealCoordinate loc = new RealCoordinate(952, 525);
        assertFalse(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownTrue() {
        area.setDirection(Angle.DOWN);
        RealCoordinate loc = new RealCoordinate(952, 975);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpRightTrue() {
        area.setDirection(Angle.UP_RIGHT);
        RealCoordinate loc = new RealCoordinate(1081, 750);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaUpLeftTrue() {
        area.setDirection(Angle.UP_LEFT);
        RealCoordinate loc = new RealCoordinate(822, 750);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownLeftTrue() {
        area.setDirection(Angle.DOWN_LEFT);
        RealCoordinate loc = new RealCoordinate(822, 900);
        assertTrue(area.isInRange(loc));
    }
    
    @Test
    public void testInsideAreaUpLongRange() {
        area.setDirection(Angle.UP);
        area.setRange(3);
        assertTrue(area.isInRange(new RealCoordinate(1082,600)));
    }

    @Test
    public void testInsideAreaDownRightTrue() {
        area.setDirection(Angle.DOWN_RIGHT);
        RealCoordinate loc = new RealCoordinate(1081, 900);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDown() {
        area.setDirection(Angle.DOWN);
        area.setRange(5);
        RealCoordinate loc = new RealCoordinate(952, 1425);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testInsideAreaDownNewDimension() {
        LocationConversion.changeHexagonDimensionsByWidth(150);
        area.setStartLocation(new RealCoordinate(750, 650));
        area.setDirection(Angle.DOWN);
        area.setRange(5);
        RealCoordinate loc = new RealCoordinate(750, 1170);
        assertTrue(area.isInRange(loc));
    }

    @Test
    public void testGetLocationsRadius2() {
        area.setDirection(Angle.UP);
        area.setRange(2);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(2, locations.size());
    }

    @Test
    public void testGetLocationsRadius3() {
        area.setDirection(Angle.UP);
        area.setRange(3);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(5, locations.size());
    }

    @Test
    public void testGetLocationsRadius4() {
        area.setDirection(Angle.UP);
        area.setRange(4);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(8, locations.size());
    }

    @Test
    public void testGetLocationsRadius5() {
        area.setDirection(Angle.DOWN);
        area.setRange(5);
        List<RealCoordinate> locations = area.getCoveredLocations();
        assertEquals(13, locations.size());
    }

}
