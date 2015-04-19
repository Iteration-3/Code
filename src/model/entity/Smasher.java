package model.entity;

import model.ability.smasher.SmasherWeaponAttack;
import model.area.TileCoordinate;
import model.skillmanager.SmasherSkillManager;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Smasher extends Avatar {
	


	private SmasherSkillManager skillManager;

	public Smasher(String name, EntityView view, TileCoordinate loc) {
		super(name, view,loc);
		this.getAbilities().add(new SmasherWeaponAttack());
		skillManager = (new SmasherSkillManager());
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
		return super.getStructuredMap();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		return "smasher";
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SmasherSkillManager getSkillManager() {
		return skillManager;
	}

}
