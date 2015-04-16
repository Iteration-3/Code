package model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import model.area.RealCoordinate;

public class EntityManager implements Iterable<Entity> {
	
	private static EntityManager _entityManager = new EntityManager();	
	private ArrayList<NPC> partyNpcs;
	private ArrayList<NPC> nonPartyNpcs;
	private Avatar avatar;
	
	private EntityManager() {
	}
	
	private class EntityIterator implements Iterator<Entity> {
		
		private int index = 0;
		private int size;
		
		private EntityIterator() {
			size = partyNpcs.size()+nonPartyNpcs.size()+1;
		}
		
		public boolean hasNext() {
			int curSize = partyNpcs.size()+nonPartyNpcs.size()+1;
			
			if (curSize != size) 
				throw new ConcurrentModificationException("EntityManager modified during iterating");
			
			return index < size;
		}
		
		public Entity next() {
			int curSize = partyNpcs.size()+nonPartyNpcs.size()+1;
			
			if (curSize != size) 
				throw new ConcurrentModificationException("EntityManager modified during iterating");
			if (!hasNext())
				throw new NoSuchElementException("no entity left");
			
			if (index == size - 1) {
				index++;
				return avatar;
			}
			if (index < partyNpcs.size()) {
				index++;
				return partyNpcs.get(index-1);
			}
			if (index >= partyNpcs.size()) {
				index++;
				return nonPartyNpcs.get(index-1-partyNpcs.size());
			}
			throw new ConcurrentModificationException("EntityManager modified during iterating");
		}
	
		public void remove() {
			throw new UnsupportedOperationException("remove is not supported in EntityIterator");
		}
	}
	
	public static EntityManager getSingleton() {
		return _entityManager;
	}
	
	public void update() {
		for(Entity e : this){
			e.update();
		}
	}
	
	/**
	 * Returns null in the event an entity isn't found at given location
	 * @param location
	 * @return
	 */
	public Entity getEntityAtLocation(RealCoordinate location) {
		for(Entity e : this){
			if(location.equals(e.getLocation())){
				return e;
			}
		}
		return null;
	}
	
	public void addPartyNpc(NPC npc) {
		partyNpcs.add(npc);
	}

	public Collection<NPC> getPartyNpcs() {
		return Collections.unmodifiableCollection(partyNpcs);
	}

	public Collection<NPC> getNonPartyNpcs() {
		return Collections.unmodifiableCollection(nonPartyNpcs);
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	@Override
	public Iterator<Entity> iterator() {
		return new EntityIterator();
	}
}
