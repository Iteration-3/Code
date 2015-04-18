package model.light;

import model.area.TileCoordinate;

public class LightMap {
	
	private Visibility[][] visibilities;
	
	public LightMap(int x, int y) {
		visibilities = new Visibility[x][y];
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				this.visibilities[i][j] = new Visibility(0);
			}
		}
	}
	
	public Visibility getVisibility(TileCoordinate loc) {
		return visibilities[loc.getX()][loc.getY()];
	}
	
	public void see(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= visibilities.length || loc.getY() >= visibilities[0].length)
			return;
		visibilities[loc.getX()][loc.getY()] = new Visibility(100);
		System.out.println("SEE: " + loc);
	}
}
