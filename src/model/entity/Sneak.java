package model.entity;

import model.ability.sneak.Creep;
import model.ability.sneak.DetectTrap;
import model.ability.sneak.PickPocket;
import model.ability.sneak.Ranged;
import model.ability.sneak.RemoveTrap;
import model.area.TileCoordinate;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Sneak extends Avatar {
	
	public Sneak(){
		super();
	}

	public Sneak(String name, EntityView view, TileCoordinate loc) {
		super(name, view,loc);
		this.getAbilities().add(new Creep());
		this.getAbilities().add(new DetectTrap());
		this.getAbilities().add(new PickPocket());
		this.getAbilities().add(new Ranged());
		this.getAbilities().add(new RemoveTrap());
	}
	
	public Sneak(StructuredMap map) {
		super(map);
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
		return super.getStructuredMap();
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	//Wasn't sneak going to have creap, and pickpocket? Not in uml anymore, we should discuss

	@Override
	public String getType() {
		return "sneak";
	}

}
