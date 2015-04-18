package model.entity;

import model.ability.smasher.SmasherWeaponAttack;
import model.area.TileCoordinate;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Smasher extends Avatar {
	
	public Smasher(){}

	public Smasher(String name, EntityView view, TileCoordinate loc) {
		super(name, view,loc);
		this.getAbilities().add(new SmasherWeaponAttack());
	}

	@Override
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

}
