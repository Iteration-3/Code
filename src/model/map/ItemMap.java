package model.map;

import java.util.HashMap;
import java.util.Map;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.item.TakeableItem;
import model.map.tile.ItemTile;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;
/**
 * This one will generate a tile for an item if it doesn't exist.
 * The reason for that is that items should only be put where tiles already exist, and the methods are
 * to add and remove items. Since this was originally a collection of item/location pairs,
 * It expected many locations to change between empty and filled.
 * Thus, item tiles are auto made here if they don't exist.
 * Also, this is just a big container, where are the map has tiles of varying types.
 * 
 * Perhaps they could be pruned when empty, but not atm.
 *
 */
public class ItemMap implements SavableLoadable {
	private Map<TileCoordinate,ItemTile> items = new HashMap<TileCoordinate, ItemTile>();
	
	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}

	private ItemTile getItemTileAtLocation(TileCoordinate loc) {
		ItemTile t = items.get(loc);
		if (t == null) {
			t = new ItemTile();
		}
		items.put(loc, t);
		return t;
	}

	
	public void touch(Entity e, TileCoordinate tileCoordinate) {
		//Takes an entity, makes it touch all the items on the square, and then removes
		//those items that get picked up from the map. 
		getItemTileAtLocation(e.getLocation()).touch(e);
		
	}
	public void add(TakeableItem i, RealCoordinate loc){
		// System.out.println(RealCoordinate.convertToTileCoordinate(loc));
		getItemTileAtLocation(RealCoordinate.convertToTileCoordinate(loc)).addItem(i);
	}

}
