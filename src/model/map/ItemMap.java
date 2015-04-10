package model.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.area.Location;
import model.entity.Entity;
import model.item.Item;
import model.map.tile.ItemTile;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public class ItemMap implements SavableLoadable {
	private Map<Location,ItemTile> items = new HashMap<Location, ItemTile>();
	
	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}
	private ItemTile getItemTileAtLocation(Location loc){
		ItemTile t = items.get(loc);
		if(t==null){t = new ItemTile();}
		return t;
	}

	
	public void touch(Entity e, Location loc){
		//Takes an entity, makes it touch all the items o nthe square, and then removes
		//those items that get picked up from the map.
		
	}
	public void add(Item i, Location loc){
		this.getItemTileAtLocation(loc).addItem(i);
	}

}
