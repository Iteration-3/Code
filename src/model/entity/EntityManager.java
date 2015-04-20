package model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import model.area.TileCoordinate;
import model.map.ItemMap;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import factories.EntityFactory;

public class EntityManager implements Iterable<Entity>, Saveable {
	
	private static EntityManager _entityManager = new EntityManager();	
	private ArrayList<NPC> partyNpcs = new ArrayList<NPC>();
	private ArrayList<NPC> nonPartyNpcs = new ArrayList<NPC>();
	private Avatar avatar;
	private Queue<Entity> removeList = new LinkedList<Entity>();
	
	private EntityManager() {
	}
	
	public void loadEntities(StructuredMap map) {
		this.avatar = EntityFactory.createAvatar(map.getStructuredMap("avatar"));
		this.partyNpcs = new ArrayList<NPC>();
		this.nonPartyNpcs = new ArrayList<NPC>();
		StructuredMap[] array1 = map.getStructuredMapArray("partyNPC");
		StructuredMap[] array2 = map.getStructuredMapArray("nonPartyNPC");
		for(StructuredMap tempMap : array1) {
			this.partyNpcs.add(EntityFactory.createNPC(tempMap));
		}
		for(StructuredMap tempMap : array2) {
			this.nonPartyNpcs.add(EntityFactory.createNPC(tempMap));
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("avatar", avatar.getStructuredMap());
		StructuredMap[] partyNPCArray = new StructuredMap[partyNpcs.size()];
		for(int i = 0; i < partyNpcs.size(); i++) {
			partyNPCArray[i] = partyNpcs.get(i).getStructuredMap();
		}
		
		StructuredMap[] nonPartyNPCArray = new StructuredMap[nonPartyNpcs.size()];
		for(int i = 0; i < partyNpcs.size(); i++) {
			nonPartyNPCArray[i] = nonPartyNpcs.get(i).getStructuredMap();
		}
		
		map.put("partyNPC", partyNPCArray);
		map.put("nonPartyNPC", nonPartyNPCArray);
		
		return map;
		
	}
	
	private class EntityIterator implements Iterator<Entity> {
		
		private int index = 0;
		private int size;
		
		private EntityIterator() {
			size = partyNpcs.size()+nonPartyNpcs.size()+1;
		}
		
		@Override
		public boolean hasNext() {
			int curSize = partyNpcs.size()+nonPartyNpcs.size()+1;
			
			if (curSize != size) 
				throw new ConcurrentModificationException("EntityManager modified during iterating");
			
			return index < size;
		}
		
		@Override
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
	
		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove is not supported in EntityIterator");
		}
	}
	
	public static EntityManager getSingleton() {
		return _entityManager;
	}
	
	public void update(ItemMap itemMap, double deltaTime) {
		if (itemMap == null) {
			return;
		}
		for(Entity e : this){
			itemMap.touch(e, e.getLocation());
			e.update(deltaTime);
			e.perform(deltaTime);
			e.observe(deltaTime);
		}
		cleanRemovedEntities();
	}
	
	/**
	 * Returns null in the event an entity isn't found at given location
	 * @param location
	 * @return
	 */
	public Entity getEntityAtLocation(TileCoordinate location) {
		for(Entity entity : this) {
			if(location.equals(entity.getLocation())) {
				return entity;
			}
		}
		return null;
	}
	
	
	public Collection<Entity> getEntityFromLocaitons(Collection<TileCoordinate> locations){
		HashMap<TileCoordinate,Entity> mapOfEntities = new HashMap<TileCoordinate,Entity>();
		Collection<Entity> entitiesFound = new ArrayList<Entity>();
		for (Entity entity: this) {
			mapOfEntities.put(entity.getLocation(), entity);
		}
		for (TileCoordinate location : locations){
			if (mapOfEntities.containsKey(location)){
				entitiesFound.add(mapOfEntities.get(location));
			}
		}
		return entitiesFound;
	}
	
	public boolean findEntityFromLocations(Collection<TileCoordinate> locations, Entity target){
		for (Entity entity: this.getEntityFromLocaitons(locations)){
			if (entity == target){
				return true;
			}
		}
		return false;
	}
	
	public NPC getNPCAtLocation(TileCoordinate location) {
		for (NPC npc : this.getPartyNpcs()) {
			if (npc.getLocation().equals(location)) {
				return npc;
			}
		}
		for (NPC npc : this.getNonPartyNpcs()) {
			if (npc.getLocation().equals(location)) {
				return npc;
			}
		}
		return null;
	}
	
	public void addPartyNpc(NPC npc) {
		partyNpcs.add(npc);
	}
	
	public void addNonPartyNpc(NPC npc) {
		nonPartyNpcs.add(npc);
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
	
	public void removeEntity(Entity entity) {
		removeList.add(entity);
	}
	
	public void clear() {
		partyNpcs = new ArrayList<NPC>();
		nonPartyNpcs = new ArrayList<NPC>();
		avatar = null;
	}
	
	private void cleanRemovedEntities() {
		Entity entity;
		while (removeList.isEmpty() == false) {
			entity = removeList.poll();
			for (Entity e : partyNpcs) {
				if (e.equals(entity)) {
					partyNpcs.remove(e);
					break;
				}
			}
			for (Entity e : nonPartyNpcs) {
				if (e.equals(entity)) {
					e.revert();
					nonPartyNpcs.remove(e);
					break;
				}
			}
			if (getAvatar().equals(entity))  {
				entity.getEntityView().toggle();
				setAvatar(null);
			}	
		}
	}

}
