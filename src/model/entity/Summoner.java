package model.entity;

import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Summoner extends Avatar {
	protected ItemManager itemManger = new ItemManager(this);
	
	public Summoner(String name, EntityView view) {
		super(name, view);
	}

	protected ItemManager createItemManager() {
		return new ItemManager(this);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * UNIMPLEMENTED
	 */
	public void bane(){
		
	}
	/**
	 * UNIMPLEMENTED
	 */
	public void boon(){
		
	}
	/**
	 * UNIMPLEMENTED
	 */
	public void enchantment(){
		
	}

}
