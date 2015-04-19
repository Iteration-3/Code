package model.entity;

import model.ability.sneak.Creep;
import model.ability.sneak.DetectTrap;
import model.ability.sneak.PickPocket;
import model.ability.sneak.Ranged;
import model.ability.sneak.RemoveTrap;
import model.area.TileCoordinate;
import model.skillmanager.SkillManager;
import model.skillmanager.SneakSkillManager;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Sneak extends Avatar {
	
	private SneakSkillManager skillManager;


	public Sneak(String name, EntityView view, TileCoordinate loc) {
		super(name, view,loc);
		this.skillManager = (new SneakSkillManager());
	}
	
	public Sneak(StructuredMap map) {
		super(map);
	}
	
	@Override
	protected void generateSkills(){
		
		this.getAbilities().add(new Creep(this.getSkillManager()));
		this.getAbilities().add(new DetectTrap(this.getSkillManager()));
		this.getAbilities().add(new PickPocket(this.getSkillManager()));
		this.getAbilities().add(new Ranged(this.getSkillManager()));
		this.getAbilities().add(new RemoveTrap(this.getSkillManager()));
		super.generateSkills();
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


	@Override
	public SneakSkillManager getSkillManager() {
		return skillManager;
	}

}
