package model.map;

import java.util.HashMap;
import java.util.Map;

import model.area.Location;
import model.entity.Entity;
import model.map.tile.Tile;
import utilities.Point;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public class GameMap implements SavableLoadable{
	private Map<Location,Tile> tiles = new HashMap<Location, Tile>();
	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub	
	}
	/**
	 * Overwrites if tile already there.
	 * @param t
	 * @param p 
	 */
	public void add(Tile t, Location p){
		tiles.put(p,t);
	}
	/**
	 * If the tile is passable, returns if it can be passed by the given entity, else
	 * returns false.
	 * @param e
	 * @param loc
	 * @return
	 */
	public boolean isPassable(Entity e, Location loc){
		Tile t = tiles.get(loc);
		if(t==null){
			return false;
		}
		return t.isPassable(e);
	}
	/**
	 * Touches the tile, IF it exists.
	 * @param e
	 * @param loc
	 */
	public void touch(Entity e, Location loc){
		Tile t = tiles.get(loc);
		if(t == null){
			return;
		}
		t.touch(e);
		
	}
	
}
