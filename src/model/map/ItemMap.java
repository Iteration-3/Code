package model.map;

import java.util.HashMap;
import java.util.Map;

import model.area.TileCoordinate;
import model.entity.Entity;
import model.item.Item;
import model.map.tile.ItemTile;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

/**
 * This one will generate a tile for an item if it doesn't exist. The reason for
 * that is that items should only be put where tiles already exist, and the
 * methods are to add and remove items. Since this was originally a collection
 * of item/location pairs, It expected many locations to change between empty
 * and filled. Thus, item tiles are auto made here if they don't exist. Also,
 * this is just a big container, where are the map has tiles of varying types.
 * 
 * Perhaps they could be pruned when empty, but not atm.
 *
 */
public class ItemMap implements Saveable {
    private Map<TileCoordinate, ItemTile> items = new HashMap<TileCoordinate, ItemTile>();

    
    public ItemMap(StructuredMap map) {
    	items = new HashMap<TileCoordinate, ItemTile>();
    	StructuredMap[] itemMap = map.getStructuredMapArray("itemMap");
    	for(StructuredMap item : itemMap) {
    		items.put(new TileCoordinate(item.getStructuredMap("coordinate")), new ItemTile(item.getStructuredMap("itemTile")));
    	}
    }
    
    public ItemMap() {

	}

	@Override
    public StructuredMap getStructuredMap() {
       StructuredMap map = new StructuredMap();
       StructuredMap[] itemMap = new StructuredMap[items.size()];
       int i = 0;
       for(Map.Entry<TileCoordinate, ItemTile> set : items.entrySet()) {
    	   StructuredMap tempMap = new StructuredMap();
    	   tempMap.put("coordinate", set.getKey().getStructuredMap());
    	   tempMap.put("itemTile", set.getValue().getStructuredMap());
    	   itemMap[i++] = tempMap;
       }
       map.put("itemMap", itemMap);
       return map;
    }

    private ItemTile getItemTileAtLocation(TileCoordinate loc) {
        ItemTile t = items.get(loc);
        if (t == null) {
            t = new ItemTile();
            items.put(loc, t);
        }
        return t;
    }

    public void touch(Entity e, TileCoordinate tileCoordinate) {
    	// it will touch the ones in front of us.  This is
    	// Because we need to see if the door will open. 
        getItemTileAtLocation(tileCoordinate).touch(e);
    }

    public void addItem(Item item, TileCoordinate loc) {
        getItemTileAtLocation(loc).addItem(item);
    }

    public boolean isBlocking(TileCoordinate potentialSpot) {
        return getItemTileAtLocation(potentialSpot).isBlocking();
    }

}
