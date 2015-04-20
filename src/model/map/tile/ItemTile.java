package model.map.tile;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import factories.ItemFactory;
import model.entity.Entity;
import model.item.Item;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class ItemTile implements Saveable {
    private Collection<Item> items = new CopyOnWriteArrayList<Item>();

    public ItemTile(StructuredMap structuredMap) {
    	items = new CopyOnWriteArrayList<Item>();
    	StructuredMap[] itemArray = structuredMap.getStructuredMapArray("items");
    	for(int i = 0; i < itemArray.length; i++) {
    		items.add(ItemFactory.createItem(itemArray[i]));
    	}
	}
    
    public ItemTile() {
    	
    }
    
    @Override
    public StructuredMap getStructuredMap() {
        StructuredMap map = new StructuredMap();
        StructuredMap[] itemArray = new StructuredMap[items.size()];
        Iterator<Item> iterator = items.iterator();
        int i = 0;
        while(iterator.hasNext()) {
        	itemArray[i++] = iterator.next().getStructuredMap();
        }
        
        map.put("items", itemArray);
        return map;
    }

	public boolean addItem(Item i) {
        return items.add(i);
    }

    public void touch(Entity e) {
        // Takes an entity, makes it touch all the items on the square, and then
        // removes those items that get picked up from the map.
        for (Item i : items) {
            i.touch(e);
            i.attemptRemoveFrom(this);
        }
    }

    public boolean remove(Item i) {
        return items.remove(i);
    }

    /**
     * UNIMPLEMENTED
     */
    

    public boolean isBlocking() {
        for (Item i : items) {
            if (i.isBlocking()) {
                return true;
            }
        }
        return false;
    }
}
