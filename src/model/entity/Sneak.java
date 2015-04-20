package model.entity;

import model.ability.sneak.Creep;
import model.ability.sneak.DetectTrap;
import model.ability.sneak.PickPocket;
import model.ability.sneak.Ranged;
import model.ability.sneak.RemoveTrap;
import model.area.TileCoordinate;
import model.skillmanager.SneakSkillManager;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.entity.EntitySpriteFactory;
import view.entity.EntityView;

public class Sneak extends Avatar {
	private SneakSkillManager skillManager;
	private boolean isSurpriseAttack = false;
	
	public void setSurpriseAttackOn() {
		isSurpriseAttack = true;
	}
	public void setSurpriseAttackOff() {
		isSurpriseAttack = false;
	}
	
	@Override
	public void attackInFront(int damage){
		if(isSurpriseAttack){
			damage*=10;
			isSurpriseAttack = false;
		}
		super.attackInFront(damage);
	}

	public Sneak() {
		this("Sneak", new EntityView(EntitySpriteFactory.getSneakerSpriteHolder()), new TileCoordinate(1, 1));
	}

	public Sneak(String name, EntityView view, TileCoordinate loc) {
		super(name, view,loc);
		this.skillManager = (new SneakSkillManager());
		generateSkills();
	}
	
	public Sneak(StructuredMap map) {
		super(map);
		skillManager = new SneakSkillManager(map.getStructuredMap("skillManager"));
		this.generateSkills();
	}
	
	@Override
	protected void generateSkills(){
		this.getAbilities().add(new Creep(this.getSkillManager(),this));
		this.getAbilities().add(new DetectTrap(this.getSkillManager()));
		this.getAbilities().add(new PickPocket(this.getSkillManager()));
		this.getAbilities().add(new Ranged(this.getSkillManager()));
		this.getAbilities().add(new RemoveTrap(this.getSkillManager()));

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
	public void load(StructuredMap map) {
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
