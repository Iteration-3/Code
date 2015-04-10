package model.entity;

import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Smasher extends Avatar {

	public Smasher(String name, EntityView view) {
		super(name, view);
	}

	protected ItemManager getItemManager() {
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

	@Override
	protected model.slots.ItemManager createItemManager() {
		return null;
	}




}
