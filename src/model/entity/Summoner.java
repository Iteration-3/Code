package model.entity;

import java.util.ArrayList;
import java.util.Collection;

import model.KeyPreferences;
import model.ability.Ability;
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
import controller.listener.Listener;

public class Summoner extends Avatar {
	protected ItemManager itemManger = new ItemManager(this);
	private Collection<Ability> abilities= new ArrayList<Ability>();
	
	public Summoner(String name, EntityView view, TileCoordinate loc) {
		super(name, view, loc);
		//TODO(mbregg) abilities should level up in strength with you
		//Bane skills
		abilities.add(new Firebolt());
		abilities.add(new LightBeam());
		abilities.add(new ShadowBlast());
		//Boone Skills
		abilities.add(new HealBoon());
		abilities.add(new MovementBoon());
		abilities.add(new StrengthBoon());
		//Enchantmentskills
		abilities.add(new Cripple());
		abilities.add(new Intimidate());
		abilities.add(new Silence());
	}
	
	@Override
	public Collection<Listener> getListeners(KeyPreferences preferences){
		return null;
		
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
