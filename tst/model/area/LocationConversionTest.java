package model.area;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LocationConversionTest {

    @Test
    public void testRealToTileEven() {
        RealCoordinate testLocation = new RealCoordinate(1.5, Math.sqrt(3) / 2.0);
        TileCoordinate coord = RealCoordinate.convertToTileCoordinate(testLocation);

        assertEquals(2, coord.getX());
        assertEquals(1, coord.getY());
    }

    @Test
    public void testRealToTileOdd() {
        RealCoordinate testLocation = new RealCoordinate(2.25, Math.sqrt(3) / 4.0);
        TileCoordinate coord = RealCoordinate.convertToTileCoordinate(testLocation);

        assertEquals(3, coord.getX());
        assertEquals(0, coord.getY());
    }
    
    @Test
    public void testTileToReal1() {
        TileCoordinate testLocation = new TileCoordinate(3, 0);
        RealCoordinate coord = TileCoordinate.convertToRealCoordinate(testLocation);

        assertEquals(2.25, coord.getX(), 0.1);
        assertEquals(Math.sqrt(3) / 4.0, coord.getY(), 0.1);
    }
    
    @Test
    public void testTileToReal2() {
        TileCoordinate testLocation = new TileCoordinate(2, 1);
        RealCoordinate coord = TileCoordinate.convertToRealCoordinate(testLocation);

        assertEquals(1.5, coord.getX(), 0.1);
        assertEquals(Math.sqrt(3) / 2, coord.getY(), 0.1);
    }
    
}
