package model.entity;

import model.ability.smasher.SmasherWeaponAttack;
import model.area.TileCoordinate;
import model.skillmanager.SmasherSkillManager;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.entity.EntitySpriteFactory;
import view.entity.EntityView;

public class Smasher extends Avatar {
	private SmasherSkillManager skillManager;
	
	public Smasher() {
		this("Smasher", new EntityView(EntitySpriteFactory.getSmasherSpriteHolder()), new TileCoordinate(1, 1));
	}

	public Smasher(String name, EntityView view, TileCoordinate loc) {
		super(name, view,loc);

		skillManager = (new SmasherSkillManager());
		this.generateSkills();
	}
	
	public Smasher(StructuredMap map) {
		super(map);
		skillManager = new SmasherSkillManager(map.getStructuredMap("skillManager"));
		this.generateSkills();
	}
	
	@Override
	protected void generateSkills() {
		this.getAbilities().add(new SmasherWeaponAttack(this.getSkillManager()));
		super.generateSkills();
	}

	@Override
	protected ItemManager createItemManager() {
		return new ItemManager(this);
	}


	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("skillManager", skillManager.getStructuredMap());
		return map;
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
