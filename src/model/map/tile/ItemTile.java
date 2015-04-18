package model.map.tile;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Entity;
import model.item.Item;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class ItemTile implements Saveable {
    private Collection<Item> items = new CopyOnWriteArrayList<Item>();

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
    @Override
    public StructuredMap getStructuredMap() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isBlocking() {
        for (Item i : items) {
            if (i.isBlocking()) {
                return true;
            }
        }
        return false;
    }
}
