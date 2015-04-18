package model.entity;

import java.util.ArrayList;
import java.util.Collection;

import model.KeyPreferences;
import model.ability.Ability;
import model.ability.summoner.enchantment.Silence;
import model.area.TileCoordinate;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;
import controller.listener.Listener;

public class Summoner extends Avatar {
	protected ItemManager itemManger = new ItemManager(this);
	
	private Collection<Ability> abilities= new ArrayList<Ability>();

	private Ability Cripple;
	private Ability Intimidate;
	private Ability Silence;
	private Ability HealBoon;
	private Ability MovementBoon;
	private Ability StrengthBoon;
	private Ability FireBolt;
	private Ability LightBeam;
	private Ability ShadowBlast;
	


	public Summoner(String name, EntityView view, TileCoordinate loc) {
		super(name, view, loc);
		//TODO(mbregg) abilities should level up in strength with you
		//Bane skills
		abilities.add(FireBolt);
		abilities.add(LightBeam);
		abilities.add(ShadowBlast);
		//Boon skills
		abilities.add(HealBoon);
		abilities.add(MovementBoon);
		abilities.add(StrengthBoon);
		//Enchantment Skills
		abilities.add(Cripple);
		abilities.add(Intimidate);
		abilities.add(new Silence());
	}
	
	@Override
	public Collection<Listener> getListeners(KeyPreferences preferences){
		Collection<Listener> listeners = new ArrayList<Listener>();
		return listeners;
		
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
