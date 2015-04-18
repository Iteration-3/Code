package model.entity;

import model.ability.summoner.bane.Firebolt;
import model.ability.summoner.bane.LightBeam;
import model.ability.summoner.bane.ShadowBlast;
import model.ability.summoner.boon.HealBoon;
import model.ability.summoner.boon.MovementBoon;
import model.ability.summoner.boon.StrengthBoon;
import model.ability.summoner.enchantment.Cripple;
import model.ability.summoner.enchantment.Intimidate;
import model.ability.summoner.enchantment.Silence;
import model.area.TileCoordinate;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Summoner extends Avatar {
	protected ItemManager itemManger = new ItemManager(this);
	


	


	public Summoner(String name, EntityView view, TileCoordinate loc) {
		super(name, view, loc);
		//TODO(mbregg) abilities should level up in strength with you
		//Bane skills
		this.getAbilities().add(new Firebolt());
		this.getAbilities().add(new LightBeam());
		this.getAbilities().add(new ShadowBlast());
		//Boone skills
		this.getAbilities().add(new HealBoon());
		this.getAbilities().add(new MovementBoon());
		this.getAbilities().add(new StrengthBoon());
		//Enchantment Skills
		this.getAbilities().add(new Cripple());
		this.getAbilities().add(new Intimidate());
		this.getAbilities().add(new Silence());
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


}
