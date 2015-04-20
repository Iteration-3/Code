package model.map;

import java.awt.Color;
import java.util.Arrays;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.light.LightManager;
import model.light.LightMap;
import model.map.tile.AirPassableTile;
import model.map.tile.ImpassableTile;
import model.map.tile.PassableTile;
import model.map.tile.Tile;
import utilities.structuredmap.JsonReader;
import utilities.structuredmap.StructuredMap;
import view.layout.GameplayLayout;
import view.map.BasicTileView;
import view.map.GameTileView;
import view.map.TileView;

public class MapLoader {
	public static GameMap loadMap(String filename, GameplayLayout layout) {
		StructuredMap mapData = JsonReader.readJson(filename);
		GameMap map = new GameMap();
		int width = mapData.getInteger("width");
		int height = mapData.getInteger("height");
		LightManager.getSingleton().setLightMap(new LightMap(width * 2, height / 2));
		GameTileView gameMapView = new GameTileView(width * 2, height / 2);
		StructuredMap[] layers = mapData.getStructuredMapArray("layers");
		int[] tileIds = layers[0].getIntArray("data");
		System.out.println(Arrays.toString(tileIds));
		for(int i = 0; i < width * height; ++i) {
			 TileView view = null;
			 Tile tile = null;
			 
			 int x = i % width;
			 int y = i / width;
			 
			 if(y % 2 == 0)
				 x *= 2;
			 else
				 x = 2*x + 1;
			 
			 y = y / 2;
			 
			 //System.out.println(x + ":" + y);
			 
			 switch(tileIds[i]) {
				case 1: // grass
					 view = new BasicTileView(new Color(0, 255, 0), Color.WHITE);
		             tile = new PassableTile(view);
		             break;
				case 2: // water
					 view = new BasicTileView(new Color(0, 0, 255), Color.WHITE);
		             tile = new AirPassableTile(view);
		             break;
			 	case 3: // mountain
					 view = new BasicTileView(new Color(255, 0, 0), Color.WHITE);
		             tile = new ImpassableTile(view);
		             break;
			  }
	         layout.setGameTileView(gameMapView);
             view.registerWithGameMapView(gameMapView, new RealCoordinate(x, y));
             map.add(tile, new TileCoordinate(x, y));
		}

		return map;
	}
}
