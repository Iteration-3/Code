package model.light;

import java.util.List;

import model.area.Area;
import model.area.TileCoordinate;

public class LightMap {
	private Visibility[][] visibilities;
	
	public LightMap(int x, int y) {
		visibilities = new Visibility[x][y];
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				this.visibilities[i][j] = new Visibility();
			}
		}
	}
	
	public void illuminate(LightSource lightSource) {
		Area lightArea = lightSource.getArea();
		List<TileCoordinate> coveredLocations = lightArea.getCoveredLocations();
		for (TileCoordinate location : coveredLocations) {
			int x = location.getX(); // jraviles - are these casts ok?
			int y = location.getY();
			visibilities[x][y].setValue(lightSource);
		}
	}
	
	public void dimLights() {
		for (int x = 0; x < visibilities.length; ++x) {
			for (int y = 0; y < visibilities[0].length; ++y) {
				visibilities[x][y].changeValue(-10);
			}
		}
	}

}
